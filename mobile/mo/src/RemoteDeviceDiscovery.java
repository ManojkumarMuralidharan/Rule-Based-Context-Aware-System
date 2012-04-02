/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;
import javax.bluetooth.*;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import org.kxml.Xml;
import org.kxml.kdom.Document;
import org.kxml.parser.XmlParser;

/**
 *
 * @author admin
 */
public class RemoteDeviceDiscovery {

    public static final Vector devicesDiscovered = new Vector();/*<RemoteDevice>*/


    public static void main_deviceDiscovery(String[] args) throws IOException, InterruptedException {
        final String[] Contextname = new String[50];
        final String[] Contextid = new String[50];
        final Object inquiryCompletedEvent = new Object();
        ObexPutClient.f.append("entered into device discovery");
        //  devicesDiscovered.clear();

        DiscoveryListener listener = new DiscoveryListener() {

            public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                System.out.println("Device " + btDevice.getBluetoothAddress() + " found");
                String found = btDevice.getBluetoothAddress();
                devicesDiscovered.addElement(btDevice);
                try {
                    ObexPutClient.f.append("name " + btDevice.getFriendlyName(false) + "\n");
                /*    StreamConnection c = null;
                    InputStream s = null;
                    try {
                        c = (StreamConnection) Connector.open("file:///e:/context.xml");
                        s = c.openInputStream();
                        XmlParser parser = new XmlParser(new InputStreamReader(s));
                        Document document = new Document();
                        document.parse(parser);

                        org.kxml.kdom.Element root = document.getRootElement();
                        int children = root.getChildCount();
                        for (int i = 0; i < children; i++) {
                            if (root.getType(i) == Xml.ELEMENT) {
                                org.kxml.kdom.Element el = root.getElement(i);
                                int babies = el.getChildCount();
                                for (int j = 0, k = 0; j < babies; j++) {
                                    if (el.getName().compareTo("context") == 0) {
                                        Contextname[k] = el.getText();
                                    }
                                    if (el.getName().compareTo("contextid") == 0) {
                                        Contextid[k++] = el.getText();
                                    }
                                }

                            }
                        }
                         ObexPutClient.f.append("succesfully parsed");
                    } catch (Exception ioe) {
                        ObexPutClient.f.append("final catch" + ioe.toString());
                    }
                    for (int i = 0; i < Contextname.length; i++) {
                        if (Contextid[i].compareTo(found) == 0) {
                            ObexPutClient.f.append("ContextName=" + Contextname);
                        }
                    }*/



                } catch (IOException cantGetDeviceName) {
                    ObexPutClient.f.append(cantGetDeviceName.toString());
                }
            }

            public void inquiryCompleted(int discType) {
                ObexPutClient.f.append("Device Inquiry completed!\n");
                synchronized (inquiryCompletedEvent) {
                    inquiryCompletedEvent.notifyAll();
                }
            }

            public void serviceSearchCompleted(int transID, int respCode) {
            }

            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
            }
        };

        synchronized (inquiryCompletedEvent) {
            boolean started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
            if (started) {
                ObexPutClient.f.append("wait for device inquiry to complete...\n");
                inquiryCompletedEvent.wait();
                ObexPutClient.f.append(devicesDiscovered.size() + " device(s) found\n");
            }
        }
    }
}
