
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class rulec {

    public void save_new_context(String name,String medium,String id)
    {

        try{
        FileConnection filecon = (FileConnection)Connector.open("file:///e:/context.xml");
        if(!filecon.exists())
        {
        filecon.create();
        OutputStream out=filecon.openOutputStream();
        PrintStream output=new PrintStream(out);
        output.println( "<rooter>" );
        output.println( "</rooter>" );
        output.close();
        out.close();
        }
       
        DataInputStream in=filecon.openDataInputStream();
        String b="";
        if(in.available()>0)
        {

            int a=in.read();

            while(a!=-1)
            {
            b=b+(char)a;
            a=in.read();
            }
        }



        String newcontent=b.substring(0, b.length()-10);
        in.close();

        filecon.delete();
        filecon.close();
        filecon = (FileConnection)Connector.open("file:///e:/context.xml");
        if(!filecon.exists())
        {
        filecon.create();
       
        }
        OutputStream out=filecon.openOutputStream();
        PrintStream output = new PrintStream( out );
        output.println(newcontent);
        output.println("<context>"+name+"</context>");
        output.println("<Medium>"+medium+"</Medium>");
        output.println("<contextid>"+id+"</contextid>");
        output.println( "</rooter>" );
        output.close();
        out.close();
        

        filecon.close();
         }
        catch(Exception e)
        {
        System.out.println(e.toString());
        }
        
    }
        public void save_exist_context(String context,String[] action)
    {
        try
        {
        FileConnection filecon = (FileConnection)Connector.open("file:///e:/"+context+".xml");
        if(filecon.exists())
        {
          filecon.delete();
          filecon.close();
          filecon = (FileConnection)Connector.open("file:///e:/"+context+".xml");
        }

            filecon.create();
            OutputStream out = filecon.openOutputStream();
            PrintStream output = new PrintStream(out);
            output.println("<rooter>");
             output.println("<context>"+context+"</context>");
         int actioncount=action.length;
         int temp=0;
         while(temp<actioncount)
         {
          //output.println("actioncount="+actioncount);
         
          if(action[temp]!=null)
          output.println("<action>"+action[temp]+"</action>");
          temp++;
         }
          output.println( "</rooter>" );
          out.close();
          filecon.close();
        }

        catch(Exception e)
        {
        System.out.println(e.toString());
        }
             
    }
        public void save_dynamic_options(String context,String [] option)
        {
             try
        {
        FileConnection filecon = (FileConnection)Connector.open("file:///e:/"+context+"_menu.xml");
        if(filecon.exists())
        {
          filecon.delete();
          filecon.close();
          filecon = (FileConnection)Connector.open("file:///e:/"+context+"_menu.xml");
        }

            filecon.create();
            OutputStream out = filecon.openOutputStream();
            PrintStream output = new PrintStream(out);
            output.println("<rooter>");
             output.println("<context>"+context+"</context>");
         int actioncount=option.length;
         int temp=0;
         while(temp<actioncount)
         {
          //output.println("actioncount="+actioncount);

          if(option[temp]!=null)
          output.println("<menu>"+option[temp]+"</menu>");
          temp++;
         }
          output.println( "</rooter>" );
          out.close();
          filecon.close();
        }

        catch(Exception e)
        {
        System.out.println(e.toString());
        }

        }

}
