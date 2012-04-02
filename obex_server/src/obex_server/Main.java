/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obex_server;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.bluetooth.*;
import javax.microedition.io.Connection;
import javax.microedition.io.Connector;
import javax.obex.*;

/**
 *
 * @author admin
 */
public class Main {
    static final String serverUUID = "11111111111111111111111111111123";
    static final UUID OBEX_FILE_TRANSFER = new UUID(0x1106);
    public static Connection server;
    public static SessionNotifier serverConnection;

    public static void main(String[] args) throws IOException {
        System.out.println("application started");

        LocalDevice.getLocalDevice().setDiscoverable(DiscoveryAgent.GIAC);

        System.out.println("local device enabled"+LocalDevice.getLocalDevice().getBluetoothAddress());
        serverConnection = (SessionNotifier) Connector.open("btgoep://localhost:"
                + OBEX_FILE_TRANSFER + ";name=ObexExample");
        System.out.println("serverConnection"+serverConnection.toString());
        int count = 0;
        while(count<3) {
            System.out.println("come inside while ");
            RequestHandler handler = new RequestHandler();
            System.out.println("request handler created");
            //serverConnection.acceptAndOpen(handler)
            System.out.println(handler.toString());
          //  for (;;) {
          try {
          // Wait for a client to connect
          System.out.println("coming Inside for");
          server =serverConnection.acceptAndOpen(handler);
          System.out.println(server.toString());
          } catch (IOException e) {
          System.out.println("Transport Error");
          return;
          }
          //  System.out.println("jjdf"+serverConnection.acceptAndOpen(handler).toString());
            System.out.println("Received OBEX connection " + (++count));
            //handler.onPut(op);
    //    }
    
        }

    }
     public static void discon()
        {
           /*try{
            serverConnection.close();}
           catch(Exception e)
           {System.out.println(e.toString());}*/
        }
    private static class RequestHandler extends ServerRequestHandler {

       //this.

        public RequestHandler() {
            System.out.println("Create.....");
             }
        //@Override
        @Override
        public int onConnect(HeaderSet request, HeaderSet reply) {
            System.out.println("trying to connect.....");
            return ResponseCodes.OBEX_HTTP_OK;
        }
        @Override
    public int onGet(Operation op)
        {
          byte bitearray[] = new byte[256];
          System.out.println("Coming inside get")  ;
          DataOutputStream out = null;
          HeaderSet header = null;


            try
    {
         HeaderSet received = op.getReceivedHeaders();

           String file_name =(String) received.getHeader(HeaderSet.NAME);
           System.out.println(file_name);
     FileInputStream in =
       new FileInputStream("D:\\xml\\obex_server\\src\\obex_server\\"+file_name);
     BufferedInputStream bufin =new BufferedInputStream(in);

     
     int numbytesread;
     int avb=bufin.available();
      System.out.println(avb);
     while (bufin.available()>0)
      {
        numbytesread = bufin.read(bitearray);
        //System.out.println
       //("Number of bytes read = " + numbytesread);
        //String s = new String(bitearray, 0, avb);
        //System.out.println(s);
      }
   }
   catch(IOException ioe)
   {
        System.out.println(ioe.toString());
   }


          //ends here

          //byte[] arrMsgBytes=null;
            //try {
                //arrMsgBytes=temp.getBytes("iso-8859-1");
            //} catch (UnsupportedEncodingException ex) {
              //  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            //}
       // HeaderSet header = op.getReceivedHeaders();
          header = createHeaderSet();
       //adding our headers
       //TYPE - represents obex message
          header.setHeader(HeaderSet.NAME,"sample.txt");
          header.setHeader( HeaderSet.TYPE, "text" );
       //LENGTH - holds message length
          header.setHeader( HeaderSet.LENGTH,new Long ( bitearray.length ) );
          System.out.println("Length ="+bitearray.length);
          //String r=new  String(bitearray);
         // System.out.println(r);
          try {
          op.sendHeaders( header );
          } catch ( Exception ex ) {
          System.out.println("Error setting up header!"+ex.toString() );
          }
          try {
      // Open the output stream to put the object to it
         out =  op.openDataOutputStream();
         System.out.println("stream created"+out.toString());
                 
      // Sending the object to client
         //out.write( arrMsgBytes );
         int length=bitearray.length;
         int k=0;
         while (k<length)
         {
         out.write(bitearray[k]);
         k++;
         }
       /*  try
         {
         Thread.sleep(35000);
         }
         catch(Exception t)
         {
         System.out.println(t.toString());
         }*/
        // out.flush();

         
       //  out.write(arrMsgBytes, 0, arrMsgBytes.length);
         System.out.println("Written");
       //  server.close();

         //out.flush();
         } catch (Exception e) {
         System.out.println("Error sending a message!" + e.toString());

         /*try{
         server.close();}
         catch(Exception eg){System.out.println("cannot Close Server"+eg.toString());}
*/

         }
          finally
          {
 if( out != null ) {
                try {
                 out.close();
                 op.close();
                         System.out.println("output Stream Closed");
                    }
      catch (Exception e) {
                 System.out.println("Error closing data stream!" + e.toString());
                /* try{
                 server.close();}
                 catch(Exception eg){System.out.println("cannot Close Server"+eg.toString());}*/

                           }
             }
          }
          
          return ResponseCodes.OBEX_HTTP_OK;
          }
          
    
             //this.onPut{}
          

      //  @Override
    /*    public void onDisconnect(HeaderSet arg0, HeaderSet arg1) {
            System.out.println("Disconnected");
            super.onDisconnect(arg0, arg1);
            try{
                discon();
            Main.server.close();
            }
            catch(Exception e){System.out.println(e.toString()); }
                        //exit();
            
        }*/
     //   @Override
        @Override
        public int onPut(Operation op) {
            HeaderSet hs;
            System.out.println("coming inside onput..");
          //  HeaderSet header=null;
            HeaderSet header = null;
            try {
                
                header = op.getReceivedHeaders();
                String name =(String)header.getHeader(HeaderSet.NAME);
                if (name == null) {
                // If no NAME header is received, then it is not
                // a valid
                // request.
                return ResponseCodes.OBEX_HTTP_BAD_REQUEST;
            }
                else
                    System.out.println(name);

                 } catch (Exception e) {
            System.out.println("Error getting request header!" );
                 }
            
            System.out.println("enter into onput");
           try {
                //op
                hs = op.getReceivedHeaders();
                if(hs==null)
                {
                System.out.println("no hearder received");
                }
                String name = (String) hs.getHeader(HeaderSet.NAME);
                //int z= (int) hs.getHeader(HeaderSet.LENGTH);
                if (name != null) {
                    System.out.println("put name:" + name);
                }

                InputStream is = op.openInputStream();
                System.out.println("input stream created");
//OutputStream is=op.
                //Byte
                //Object l=hs.getHeader(HeaderSet.LENGTH);
                Long stringLength =
                        (Long) hs.getHeader(HeaderSet.LENGTH);
int z=stringLength.intValue();
                byte[] b = new byte[z];
                is.read(b);
                //StringBuffer buf = new StringBuffer();
               /*int data;

               while ((data = is.read()) != -1) {
                    b.;
                }*/

                //file operation

                try
    {
     FileOutputStream out =
       new FileOutputStream("D:\\xml\\obex_server\\src\\obex_server\\"+name);
     BufferedOutputStream bufin =new BufferedOutputStream(out);


     int numbytesread=b.length;
     //int x=0;
     //int avb=bufin.available();
      //System.out.println(avb);
     if (numbytesread>0)
      {
       bufin.write(b);
      }
     System.out.println("file created");
     bufin.close();
     System.out.println("sTREAM cLOSED");
   }
   catch(IOException ioe)
   {
        System.out.println(ioe.toString());
   }
                //end of file operation
               // System.out.println("got:" + buf.toString());

                op.close();
                return ResponseCodes.OBEX_HTTP_OK;
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseCodes.OBEX_HTTP_UNAVAILABLE;
            }
            finally
            {
                //super.onPut(op);
            }
        }
       
        
    };


    /**
     * @param args the command line arguments
     */
    

}
