/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import javax.bluetooth.*;

/**
 *
 * @author admin
 */
public class ServicesSearch {
    static final UUID OBEX_FILE_TRANSFER = new UUID(0x1106);

    public static final Vector/*<String>*/ serviceFound = new Vector();

    public static void main_search_service(String[] args) throws IOException, InterruptedException {
        ObexPutClient.f.append("entered into service serach");
        // First run RemoteDeviceDiscovery and use discoved device
        RemoteDeviceDiscovery.main_deviceDiscovery(null);

//        serviceFound.clear();

        UUID serviceUUID = new UUID(0x1106);
        if ((args != null) && (args.length > 0)) {
            serviceUUID = new UUID(args[0], false);
        }

        final Object serviceSearchCompletedEvent = new Object();

        DiscoveryListener listener = new DiscoveryListener() {

            public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
            }

            public void inquiryCompleted(int discType) {
            }

            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
                for (int i = 0; i < servRecord.length; i++) {
                    String url = servRecord[i].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
                    if (url == null) {
                        continue;
                    }
                    serviceFound.addElement(url);
                    DataElement serviceName = servRecord[i].getAttributeValue(0x0100);
                    if (serviceName != null) {
                        ObexPutClient.f.append("service " + serviceName.getValue() + " found " + url+"\n");
                    } else {
                        ObexPutClient.f.append("service found " + url+"\n");
                    }
                }
            }

            public void serviceSearchCompleted(int transID, int respCode) {
               ObexPutClient.f.append("service search completed!");
                synchronized(serviceSearchCompletedEvent){
                    serviceSearchCompletedEvent.notifyAll();
                }
            }

        };

        UUID[] searchUuidSet = new UUID[] { serviceUUID };
        int[] attrIDs =  new int[] {
                0x0100 // Service name
        };

        for(Enumeration en = RemoteDeviceDiscovery.devicesDiscovered.elements(); en.hasMoreElements(); ) {
            RemoteDevice btDevice = (RemoteDevice)en.nextElement();

            synchronized(serviceSearchCompletedEvent) {
                ObexPutClient.f.append("search services on " + btDevice.getBluetoothAddress() + " " + btDevice.getFriendlyName(false));
                LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet, btDevice, listener);
                serviceSearchCompletedEvent.wait();
            }
        }



}
}
