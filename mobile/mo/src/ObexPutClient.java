/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.Form;
import javax.obex.*;

/**
 *
 * @author admin
 */
public class ObexPutClient {

    public static Form f = new Form("Status ...");
    public static ClientSession clientSession;
    public int Flag = 1;
//    public static Operation operation;

    public static void main_client(String args[]) throws IOException, InterruptedException {

        String serverURL = null;
        /*if ((args != null) && (args.length > 0)) {
        serverURL = args[0];
        }*/
        if (serverURL == null) {
            String[] searchArgs = null;
            // Connect to OBEXPutServer from examples
            // searchArgs = new String[] { "11111111111111111111111111111123" };
            f.append("calling search service\n");
            ServicesSearch.main_search_service(searchArgs);
            f.append("returned to putclient");
            if (ServicesSearch.serviceFound.size() == 0) {
                int append = f.append("OBEX service not found\n");
                return;
            }
            
            // Select the first service found
            serverURL = (String) ServicesSearch.serviceFound.elementAt(1);
            f.append("server url" + serverURL);
        }
        f.append("req file:" + args[0]);
        f.append(")Connecting to " + serverURL + "\n");

        clientSession = (ClientSession) Connector.open(serverURL);
        f.append("clientsession created " + clientSession.toString() + "\n");
        HeaderSet hsConnectReply = clientSession.connect(null);
        f.append("header set " + hsConnectReply.toString());
        if (hsConnectReply.getResponseCode() != ResponseCodes.OBEX_HTTP_OK) {
            System.out.println("Failed to connect");
            return;
        }
        //GetMessage();
        //HeaderSet hsOperation=null;
        //  byte data1[] = "Hello world!".getBytes("iso-8859-1");

        HeaderSet hsOperation = clientSession.createHeaderSet();
        // if(hs)
        //  {


        //   }
        //   Long ds=new Long(data1.length);

        hsOperation.setHeader(HeaderSet.NAME, args[0]);
        //HeaderSet.TARGET
        hsOperation.setHeader(HeaderSet.TYPE, "text");
        //    hsOperation.setHeader(HeaderSet.LENGTH,ds);
        f.append("header set created\n");
        //Long lengt=data1.length;
        // Integer tek=new Integer(data1.length);


        //Create PUT Operation
        //Operation putOperation = clientSession.put(hsOperation);
        //Operation putOperation = clientSession.get(null);
        Operation putOperation = clientSession.get(hsOperation);
        //      f.append("get:"+getOperation.toString());
        //f.append("HsOpN:"+hsOperation.getHeader(HeaderSet.NAME));
        // f.append("HsOpD:"+hsOperation.getHeader(HeaderSet.DESCRIPTION));
        //  f.append("HsOpL:"+hsOperation.getHeader(HeaderSet.LENGTH));
        // f.append("ResponseCode:"+putOperation.getResponseCode());
        byte[] data1 = null;

        HeaderSet head = putOperation.getReceivedHeaders();
        if (head == null) {
            f.append(" getHeader == null ");
            putOperation.close();
            return;
        }

        f.append("HdpN:" + head.getHeader(HeaderSet.NAME));
        f.append("HdpD:" + head.getHeader(HeaderSet.TYPE));
        f.append("HdpL:" + head.getHeader(HeaderSet.LENGTH));
        data1 = new byte[256];

        try {
            //waiting two seconds for next attemp to getting
            //response code
            Thread.sleep(1000);
            int responseCode = head.getResponseCode();
            if (responseCode == ResponseCodes.OBEX_HTTP_OK) {
                //it's Ok! getting the message
                //     break;
                f.append("Positive Response Code");
            //break;
            }
            if (responseCode == ResponseCodes.OBEX_HTTP_NO_CONTENT) {
                //it's no content! wait for next message
                //f.append("OBEX_HTTP_NO_CONTENT");
                putOperation.close();
                f.append("No Content Response Code");
                return;
            } else {
                f.append("response code is" + responseCode);
            }
        } catch (InterruptedException ex) {
            f.append(ex.toString());
        //TODO: write handler code
        }






        // f.append("put:"+putOperation.toString());
        //clientSession.
        // Send some text to server
        // byte data[]=null;

        //  OutputStream os = putOperation.openOutputStream();
        InputStream is = putOperation.openInputStream();
        if (is == null) {
            f.append(" error input stream ");
            putOperation.close();
            return;
        }

        // is.read(data);
        f.append("get operation Called\n");

        //is.read(data1, 0,head.LENGTH );
        f.append("Available bytes:" + is.available());
        is.read(data1);
        try {
            // String name=(String) hsOperation.getHeader(HeaderSet.NAME);
            FileConnection filecon = (FileConnection) Connector.open("file:///e:/" + args[0]);
            if (!filecon.exists()) {
                filecon.create();
            }
            OutputStream out = filecon.openOutputStream();
            out.write(data1);
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        /*ByteArrayOutputStream outBuf =new ByteArrayOutputStream();
        int data = is.read();
        while (data != -1) {
        outBuf.write((byte)data);
        data = is.read();
        }*/
        // f.append("strijng is"+outBuf.toString());
     /*   while(true)
        {
        if(is.available()>0)
        {

        is.read(data1);
        is.close();
        f.append("bytes length"+data1.length);
        String d=new String(data1);
        f.append("messg is:"+d);
        break;
        }
        else
        {
        f.append("waiting for input");
        try
        {
        Thread.sleep(1000);}
        catch(Exception u)
        {f.append(u.toString());}
        
        }
        }*/

        //int responseCode = putOperation.getResponseCode();
        //     String y="gh"+responseCode;
        //     f.append(y);
        //  f.append(responseCode) ;
        // os.wait();
        //data1.length
        //data1.clear();
        for(int h=0;h<256;h++)
        {
        data1[h]='\0';
        }
        putOperation.close();
        f.append("Done Writing Data");
        clientSession.disconnect(null);
        clientSession.close();
    //  is.close();

    //  getOperation.close();


    }

   /* public static void disconnect() throws IOException {
        f.append("closed");
        clientSession.disconnect(null);
        clientSession.close();
    }*/
    /*public static void GetMessage() {
    //we can use only one Operation object at one time
    //it mean's that when we send GET request we can't
    //sending PUT request
    //  synchronized(clientSession) {
    //header creating for GET request
    HeaderSet head = clientSession.createHeaderSet();
    try {
    // Set the type of the object to retrieve
    head.setHeader(HeaderSet.TYPE, "BtObexMessage");
    //  head.setHeader(HeaderSet.LENGTH, new Long(0));
    } catch (IllegalArgumentException ex) {
    f.append(ex.toString());
    //TODO: write handler code
    return;
    }


    try {
    //creating new Operation object for current connection
    operation = clientSession.get(head);
    f.append(operation.toString());
    } catch (IOException ex) {
    f.append(ex.toString());
    return;
    }

    try {
    // getting header...
    HeaderSet getHeader = operation.getReceivedHeaders();
    if(getHeader == null) {
    f.append(" getHeader == null ");
    operation.close();
    return;
    }

    // ...and checking the response code
    while(true) {
    int responseCode = getHeader.getResponseCode();
    if(responseCode == ResponseCodes.OBEX_HTTP_OK) {
    //it's Ok! getting the message
    break;
    }
    if(responseCode == ResponseCodes.OBEX_HTTP_NO_CONTENT) {
    //it's no content! wait for next message
    //f.append("OBEX_HTTP_NO_CONTENT");
    operation.close();
    return;
    }
    try {
    //waiting two seconds for next attemp to getting
    //response code
    Thread.sleep(2000);
    } catch (InterruptedException ex) {
    f.append(ex.toString());
    //TODO: write handler code
    }
    }


    //getting the headerlist where we have additional information
    //about message, like length
    int[] fieldsIDs = getHeader.getHeaderList();
    if(fieldsIDs == null) {
    f.append(" header on GET response is empty");
    operation.close();
    return;
    }

    // Get the object from the input stream
    DataInputStream in = operation.openDataInputStream();
    if(in == null) {
    f.append(" error input stream ");
    operation.close();
    return;
    }

    //getting lenght of message
    Long stringLength =
    (Long) getHeader.getHeader(HeaderSet.LENGTH);
    //creating string object
    byte[] object = new byte[ (int)stringLength.longValue() ];
    in.read(object);
    String objectString = new String(object);
    f.append( objectString );
    //closing input stream
    in.close();
    //closing current operation
    operation.close();
    } catch (IOException ex) {
    f.append(ex.toString());
    //TODO: write handler code
    }
    //  }
    }*/

    public static void second_get(String args) throws IOException {
        HeaderSet hsOperation = clientSession.createHeaderSet();
        hsOperation.setHeader(HeaderSet.NAME, args);
        //HeaderSet.TARGET
        hsOperation.setHeader(HeaderSet.TYPE, "text");
        //    hsOperation.setHeader(HeaderSet.LENGTH,ds);
        f.append("header set created\n");
        Operation putOperation = clientSession.get(hsOperation);
        byte[] data1 = null;
        HeaderSet head = putOperation.getReceivedHeaders();
        if (head == null) {
            f.append(" getHeader == null ");
            putOperation.close();
            return;
        }

        f.append("HdpN:" + head.getHeader(HeaderSet.NAME));
        f.append("HdpD:" + head.getHeader(HeaderSet.TYPE));
        f.append("HdpL:" + head.getHeader(HeaderSet.LENGTH));
        data1 = new byte[(int) head.LENGTH];

        try {
            //waiting two seconds for next attemp to getting
            //response code
            Thread.sleep(1000);
            int responseCode = head.getResponseCode();
            if (responseCode == ResponseCodes.OBEX_HTTP_OK) {
                //it's Ok! getting the message
                //     break;
                f.append("Positive Response Code");
            //break;
            }
            if (responseCode == ResponseCodes.OBEX_HTTP_NO_CONTENT) {
                //it's no content! wait for next message
                //f.append("OBEX_HTTP_NO_CONTENT");
                putOperation.close();
                f.append("No Content Response Code");
                return;
            } else {
                f.append("response code is" + responseCode);
            }
        } catch (InterruptedException ex) {
            f.append(ex.toString());
        //TODO: write handler code
        }







        InputStream is = putOperation.openInputStream();
        if (is == null) {
            f.append(" error input stream ");
            putOperation.close();
            return;
        }


        f.append("get operation Called\n");


        f.append("Available bytes:" + is.available());
        is.read(data1);
        try {
            FileConnection filecon = (FileConnection) Connector.open("file:///e:/" + args);
            if (!filecon.exists()) {
                filecon.create();
            }
            OutputStream out = filecon.openOutputStream();
            out.write(data1);
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        f.append("Done Writing Data");


    }
}
