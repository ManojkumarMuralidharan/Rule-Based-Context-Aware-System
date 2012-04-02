/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.String;
import java.util.Enumeration;
import javax.bluetooth.RemoteDevice;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.file.FileConnection;
import javax.microedition.media.MediaException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.RecordControl;
import javax.microedition.media.control.VideoControl;
import javax.microedition.xml.rpc.Element;
import org.kxml.parser.*;
import org.kxml.*;
import org.kxml.Xml;
import org.kxml.io.*;
import org.kxml.kdom.Document;
//import org.kxml.parser.XmlParser;
import org.kxml.kdom.Element.*;
import org.netbeans.microedition.lcdui.SplashScreen;
import org.netbeans.microedition.lcdui.wma.SMSComposer;

/**
 * @author admin
 */
public class VisualMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Image image1;
    private Image image;
    private Ticker ticker;
    private Command exitCommand2;
    private Command exitCommand1;
    private Command backCommand1;
    private Command SaveContext;
    private Command Select;
    private Command okCommand1;
    private Command Send;
    private Command Edit;
    private Command backCommand;
    private Command exitCommand;
    private Command SaveRule;
    private Command Save;
    private Command okCommand;
    private Command Stop;
    private Command Start;
    private Command screenCommand;
    private Command StartEngine;
    private Command Capture;
    private Command RulesRepository;
    private Command save_audio;
    private Command Savetext;
    private Command Retrive;
    private List Rules;
    private Form Contextmenu;
    private ChoiceGroup menuoptions;
    private List DynamicOption;
    private TextBox Filename;
    private Form ExistContext;
    private ChoiceGroup existcontext;
    private ChoiceGroup action;
    private List Context_available;
    private Form NewContext;
    private ChoiceGroup contextmedium;
    private TextField contextname;
    private TextField contextid;
    private Form MainUI;
    private ImageItem imageItem;
    private Form ActionForm;
    private Form VoiceRecorder;
    private SMSComposer smsComposer;
    private List ContextDefine;
    private SplashScreen splashScreen;
    private Form DynamicActionForm;
    private TextBox textBox;
    private List RulesCreated;
    private List Downloads;
    //</editor-fold>//GEN-END:|fields|0|
    String[] Contextname = new String[50];
    String[] Contextid = new String[50];
    String[] Contextaction = new String[50];
    String[] Contextid_pc = new String[50];
    String[] Contextmed_pc = new String[50];
    String edit_selected = null;
    String current_context = null;
    FileConnection fc;
    VideoControl m_objVideoControl;
    ByteArrayOutputStream outp;
    Player b_audPlayer;
    RecordControl rc;
    String found;
    int flagg = 0;
    String selectedcontext;
    byte[] recordedSoundArray = null;
    DataOutputStream dos = null;

    /**
     * The VisualMIDlet constructor.
     */
    public VisualMIDlet() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getSplashScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
    // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
    // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|15-getter|0|15-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|15-getter|0|15-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|15-getter|1|15-postInit
        // write post-init user code here
        }//GEN-BEGIN:|15-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|15-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: screenCommand ">//GEN-BEGIN:|17-getter|0|17-preInit
    /**
     * Returns an initiliazed instance of screenCommand component.
     * @return the initialized component instance
     */
    public Command getScreenCommand() {
        if (screenCommand == null) {//GEN-END:|17-getter|0|17-preInit
            // write pre-init user code here
            screenCommand = new Command("Screen", Command.SCREEN, 0);//GEN-LINE:|17-getter|1|17-postInit
        // write post-init user code here
        }//GEN-BEGIN:|17-getter|2|
        return screenCommand;
    }
    //</editor-fold>//GEN-END:|17-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: RulesRepository ">//GEN-BEGIN:|19-getter|0|19-preInit
    /**
     * Returns an initiliazed instance of RulesRepository component.
     * @return the initialized component instance
     */
    public Command getRulesRepository() {
        if (RulesRepository == null) {//GEN-END:|19-getter|0|19-preInit
            // write pre-init user code here
            RulesRepository = new Command("RulesRepository", Command.ITEM, 0);//GEN-LINE:|19-getter|1|19-postInit
        // write post-init user code here
        }//GEN-BEGIN:|19-getter|2|
        return RulesRepository;
    }
    //</editor-fold>//GEN-END:|19-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction

        // write pre-action user code here
        if (displayable == ActionForm) {//GEN-BEGIN:|7-commandAction|1|91-preAction
            if (command == Capture) {//GEN-END:|7-commandAction|1|91-preAction
                try {
                    byte[] data = m_objVideoControl.getSnapshot(null);
                    Image shot = Image.createImage(data, 0, data.length);
                    ActionForm.append(shot);

// m_objVideoControl.getSnapshot("encoding=png&width= 80&height=60"));
// m_objVideoControl.getSnapshot("encoding=bmp&width= 160&height=120"));
                } catch (Exception exc) {
                    ActionForm.append(exc.toString());
// handle Exception
                }

            // write pre-action user code here
//GEN-LINE:|7-commandAction|2|91-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|3|84-preAction
                //ActionForm.delete(1);
                ActionForm.deleteAll();
                switchDisplayable(null, getMainUI());
                // write pre-action user code here
                switchDisplayable(null, getDynamicOption());//GEN-LINE:|7-commandAction|4|84-postAction
                if (flagg == 0) {
                    set_dynamic_option();
                    flagg = 1;
                }
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|41-preAction
        } else if (displayable == ContextDefine) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|5|41-preAction
                // write pre-action user code here
                ContextDefineAction();//GEN-LINE:|7-commandAction|6|41-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|7|100-preAction
                // write pre-action user code here
                switchDisplayable(null, getRules());//GEN-LINE:|7-commandAction|8|100-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|133-preAction
        } else if (displayable == Context_available) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|9|133-preAction
                // write pre-action user code here
                Context_availableAction();//GEN-LINE:|7-commandAction|10|133-postAction
            // write post-action user code here
            } else if (command == Retrive) {//GEN-LINE:|7-commandAction|11|139-preAction
                String file_name = Context_available.getString(Context_available.getSelectedIndex());
                String id = Contextid_pc[Context_available.getSelectedIndex()];
                String med = Contextmed_pc[Context_available.getSelectedIndex()];
                String[] file = {new String(file_name + ".xml"),};
                try {
                    switchDisplayable(null, ObexPutClient.f);
                    ObexPutClient.main_client(file);
                    // ObexPutClient.second_get(file_name);
                    switchDisplayable(null, getMainUI());
                // write pre-action user code here
                // write post-action user code here
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                update_local_context_file(file_name, id, med);

                // write pre-action user code here
                switchDisplayable(null, getMainUI());//GEN-LINE:|7-commandAction|12|139-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|13|136-preAction
                // write pre-action user code here
                switchDisplayable(null, getDownloads());//GEN-LINE:|7-commandAction|14|136-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|165-preAction
        } else if (displayable == Contextmenu) {
            if (command == Save) {//GEN-END:|7-commandAction|15|165-preAction
                // write pre-action user code here
                String[] optselected = new String[menuoptions.size()];
                boolean[] get = new boolean[menuoptions.size()];
                menuoptions.getSelectedFlags(get);
                //ContextDefine.append("lenght"+ get.length ,null);
                for (int i = 0; i < get.length; i++) {
                    if (get[i]) {
                        optselected[i] = menuoptions.getString(i);
                    //    ContextDefine.append("size="+menuoptions.size(),null);
                    //     ContextDefine.append("i="+i+ optselected[i],null);
                    }
                }
                rulec c = new rulec();
                c.save_dynamic_options(selectedcontext, optselected);
                switchDisplayable(null, getMainUI());//GEN-LINE:|7-commandAction|16|165-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|17|166-preAction
                // write pre-action user code here
                switchDisplayable(null, getExistContext());//GEN-LINE:|7-commandAction|18|166-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|19|111-preAction
        } else if (displayable == Downloads) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|19|111-preAction
                // write pre-action user code here
                DownloadsAction();//GEN-LINE:|7-commandAction|20|111-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|21|122-preAction
                // write pre-action user code here
                switchDisplayable(null, getRules());//GEN-LINE:|7-commandAction|22|122-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|23|176-preAction
        } else if (displayable == DynamicActionForm) {
            if (command == Capture) {//GEN-END:|7-commandAction|23|176-preAction
                // write pre-action user code here
                try {
                    byte[] data = m_objVideoControl.getSnapshot(null);
                    Image shot = Image.createImage(data, 0, data.length);
                    DynamicActionForm.append(shot);
                    FileConnection filecon = (FileConnection) Connector.open("file:///e:/Image.png");

                    DataOutputStream in = filecon.openDataOutputStream();
                    in.write(data);
                    in.close();
                    filecon.close();
// m_objVideoControl.getSnapshot("encoding=png&width= 80&height=60"));
// m_objVideoControl.getSnapshot("encoding=bmp&width= 160&height=120"));
                } catch (Exception exc) {
                    DynamicActionForm.append(exc.toString());
// handle Exception
                }

//GEN-LINE:|7-commandAction|24|176-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|25|171-preAction
                // write pre-action user code here
                switchDisplayable(null, getDynamicOption());//GEN-LINE:|7-commandAction|26|171-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|27|125-preAction
        } else if (displayable == DynamicOption) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|27|125-preAction
                // write pre-action user code here
                DynamicOptionAction();//GEN-LINE:|7-commandAction|28|125-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|29|127-preAction
                // write pre-action user code here
                DynamicOption.deleteAll();
                switchDisplayable(null, getMainUI());//GEN-LINE:|7-commandAction|30|127-postAction
            // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|31|128-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|32|128-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|33|77-preAction
        } else if (displayable == ExistContext) {
            if (command == SaveRule) {//GEN-END:|7-commandAction|33|77-preAction
                // write pre-action user code here
                //ContextDefine.append("coming inside SaveRule",null);
                rulec r = new rulec();
                String[] selected = new String[action.size()];
                boolean[] get = new boolean[action.size()];
                action.getSelectedFlags(get);
                for (int i = 0; i < get.length; i++) {
                    if (get[i]) {
                        selected[i] = action.getString(i);
                    //  ContextDefine.append( selected[i],null);
                    }
                }

                /*    for(int i=action.size()-1;i>=0;i--)
                {
                ContextDefine.append("value of i="+i,null);
                if(action.isSelected(i))
                {
                selected[i]=action.getString(i);
                ContextDefine.append(selected[i],null);
                }
                else
                selected[i]=null;
                }*/
                selectedcontext = existcontext.getString(existcontext.getSelectedIndex());
                r.save_exist_context(existcontext.getString(existcontext.getSelectedIndex()), selected);
                switchDisplayable(null, getContextmenu());//GEN-LINE:|7-commandAction|34|77-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|35|66-preAction
                // write pre-action user code here
                switchDisplayable(null, getContextDefine());//GEN-LINE:|7-commandAction|36|66-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|37|198-preAction
        } else if (displayable == Filename) {
            if (command == backCommand) {//GEN-END:|7-commandAction|37|198-preAction
                // write pre-action user code here
                switchDisplayable(null, getVoiceRecorder());//GEN-LINE:|7-commandAction|38|198-postAction
                // write post-action user code here
            } else if (command == save_audio) {//GEN-LINE:|7-commandAction|39|193-preAction
                try {
                    // write pre-action user code here
                    FileConnection fc2 = (FileConnection) Connector.open("file:///e:/"+Filename.getString()+".amr");
                    //fc.rename("ok.amr");
                    if (!fc2.exists()) {
                    fc2.create();
                    }
                    dos = fc2.openDataOutputStream();
                    dos.write(recordedSoundArray);
                    fc2.close();



                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                switchDisplayable(null, getDynamicOption());//GEN-LINE:|7-commandAction|40|193-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|41|20-preAction
        } else if (displayable == MainUI) {
            if (command == RulesRepository) {//GEN-END:|7-commandAction|41|20-preAction
                // write pre-action user code here
                switchDisplayable(null, getRules());//GEN-LINE:|7-commandAction|42|20-postAction
            // write post-action user code here
            } else if (command == StartEngine) {//GEN-LINE:|7-commandAction|43|23-preAction
                // ObexPutClient.f.addCommand(backCommand);
                switchDisplayable(null, ObexPutClient.f);
                try {
                    //ObexPutClient.main_client(null);
                    RemoteDeviceDiscovery.main_deviceDiscovery(null);
                    retrive_devices();
                    for (Enumeration en = RemoteDeviceDiscovery.devicesDiscovered.elements(); en.hasMoreElements();) {
                        RemoteDevice btDevice = (RemoteDevice) en.nextElement();
                        for (int i = 0; Contextid[i] != null; i++) {
                            try {
                                //  ObexPutClient.f.append("id of device"+btDevice.getBluetoothAddress()+"value of i="+i);
                                if (btDevice.getBluetoothAddress().equals(Contextid[i])) {
                                    ObexPutClient.f.append("IdentifiedContext" + Contextname[i]);
                                    current_context = Contextname[i];
                                    retrive_action(Contextname[i]);
                                    activate();
                                }
                            } catch (Exception e) {
                                ObexPutClient.f.append("inside for exception" + e.toString());
                            }
                        }

                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            // write pre-action user code here
//GEN-LINE:|7-commandAction|44|23-postAction
            // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|45|27-preAction
                // write pre-action user code here
                // destroyApp(false);
                exitMIDlet();//GEN-LINE:|7-commandAction|46|27-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|47|59-preAction
        } else if (displayable == NewContext) {
            if (command == SaveContext) {//GEN-END:|7-commandAction|47|59-preAction
                // write pre-action user code here
                System.out.println("coming in here");
                rulec r = new rulec();
                r.save_new_context(contextname.getString(), contextmedium.getString(contextmedium.getSelectedIndex()), contextid.getString());
                switchDisplayable(null, getContextDefine());//GEN-LINE:|7-commandAction|48|59-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|49|74-preAction
                // write pre-action user code here
                switchDisplayable(null, getContextDefine());//GEN-LINE:|7-commandAction|50|74-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|51|32-preAction
        } else if (displayable == Rules) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|51|32-preAction
                // write pre-action user code here
                RulesAction();//GEN-LINE:|7-commandAction|52|32-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|53|37-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainUI());//GEN-LINE:|7-commandAction|54|37-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|55|98-preAction
        } else if (displayable == RulesCreated) {
            if (command == Edit) {//GEN-END:|7-commandAction|55|98-preAction
                // write pre-action user code here
                 /*edit_selected=RulesCreated.getString(RulesCreated.getSelectedIndex());
                for(int cnt=0;cnt<existcontext.size();cnt++)
                {
                if(edit_selected.compareTo(existcontext.getString(cnt))==0)
                {
                existcontext.setSelectedIndex(cnt, true);break;}
                }*/
                //existcontext.setSelectedFlags(new boolean[existcontext.size()]={})
                existcontext.setSelectedIndex(RulesCreated.getSelectedIndex(), true);
                switchDisplayable(null, getExistContext());//GEN-LINE:|7-commandAction|56|98-postAction
            // write post-action user code here
            } else if (command == List.SELECT_COMMAND) {//GEN-LINE:|7-commandAction|57|93-preAction
                // write pre-action user code here
                RulesCreatedAction();//GEN-LINE:|7-commandAction|58|93-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|59|96-preAction
                // write pre-action user code here
                switchDisplayable(null, getRules());//GEN-LINE:|7-commandAction|60|96-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|61|187-preAction
        } else if (displayable == VoiceRecorder) {
            if (command == Start) {//GEN-END:|7-commandAction|61|187-preAction
                // write pre-action user code here
                startrecording();

//GEN-LINE:|7-commandAction|62|187-postAction
            // write post-action user code here
            } else if (command == Stop) {//GEN-LINE:|7-commandAction|63|189-preAction
                // write pre-action user code here
                stoprecording();
                switchDisplayable(null, getFilename());//GEN-LINE:|7-commandAction|64|189-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|65|190-preAction
                // write pre-action user code here
                switchDisplayable(null, getDynamicOption());//GEN-LINE:|7-commandAction|66|190-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|67|143-preAction
        } else if (displayable == smsComposer) {
            if (command == SMSComposer.SEND_COMMAND) {//GEN-END:|7-commandAction|67|143-preAction
                try {
                    // write pre-action user code here
                    //smsComposer.setMessage(smsComposer.)
                    smsComposer.sendSMS();
                // write post-action user code here
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
//GEN-LINE:|7-commandAction|68|143-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|69|146-preAction
                // write pre-action user code here
                switchDisplayable(null, getActionForm());//GEN-LINE:|7-commandAction|70|146-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|71|154-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|71|154-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainUI());//GEN-LINE:|7-commandAction|72|154-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|73|175-preAction
        } else if (displayable == textBox) {
            if (command == Savetext) {//GEN-END:|7-commandAction|73|175-preAction
                // write pre-action user code here
                String name = textBox.getString();
                String f = name.substring(0, 6);
                try {
                    FileConnection c = (FileConnection) Connector.open("file:///e:/" + f + ".txt");
                    if (!c.exists()) {
                        c.create();
                    }
                    OutputStream out = c.openDataOutputStream();
                    out.write(textBox.getString().getBytes());
                    out.close();
                    c.close();
                // write post-action user code here
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
//GEN-LINE:|7-commandAction|74|175-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|75|177-preAction
                // write pre-action user code here
                switchDisplayable(null, getDynamicOption());//GEN-LINE:|7-commandAction|76|177-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|77|7-postCommandAction
        }//GEN-END:|7-commandAction|77|7-postCommandAction
 else if (displayable == ObexPutClient.f) {
            if (command == backCommand) {
                switchDisplayable(null, getMainUI());
            }



        } else if (displayable == DynamicActionForm) {
        }
    // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|78|
    //</editor-fold>//GEN-END:|7-commandAction|78|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: MainUI ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of MainUI component.
     * @return the initialized component instance
     */
    public Form getMainUI() {
        if (MainUI == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            MainUI = new Form("Rule Engine ", new Item[] { getImageItem() });//GEN-BEGIN:|14-getter|1|14-postInit
            MainUI.setTicker(getTicker());
            MainUI.addCommand(getRulesRepository());
            MainUI.addCommand(getStartEngine());
            MainUI.addCommand(getExitCommand());
            MainUI.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
        // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return MainUI;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: StartEngine ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of StartEngine component.
     * @return the initialized component instance
     */
    public Command getStartEngine() {
        if (StartEngine == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            StartEngine = new Command("StartEngine", Command.ITEM, 0);//GEN-LINE:|22-getter|1|22-postInit
        // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return StartEngine;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Edit ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of Edit component.
     * @return the initialized component instance
     */
    public Command getEdit() {
        if (Edit == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            Edit = new Command("Edit", Command.ITEM, 0);//GEN-LINE:|24-getter|1|24-postInit
        // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return Edit;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|26-getter|1|26-postInit
        // write post-init user code here
        }//GEN-BEGIN:|26-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initiliazed instance of image1 component.
     * @return the initialized component instance
     */
    public Image getImage1() {
        if (image1 == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|29-getter|1|29-@java.io.IOException
                image1 = Image.createImage("/cartman_ch.PNG");
            } catch (java.io.IOException e) {//GEN-END:|29-getter|1|29-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|29-getter|2|29-postInit
        // write post-init user code here
        }//GEN-BEGIN:|29-getter|3|
        return image1;
    }
    //</editor-fold>//GEN-END:|29-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: imageItem ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of imageItem component.
     * @return the initialized component instance
     */
    public ImageItem getImageItem() {
        if (imageItem == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            imageItem = new ImageItem("Rule Engine", getImage1(), ImageItem.LAYOUT_DEFAULT, "<Missing Image>");//GEN-LINE:|28-getter|1|28-postInit
        // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return imageItem;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|36-getter|1|36-postInit
        // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|38-getter|1|38-postInit
        // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|38-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Rules ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of Rules component.
     * @return the initialized component instance
     */
    public List getRules() {
        if (Rules == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            Rules = new List("Rule Interface", Choice.IMPLICIT);//GEN-BEGIN:|30-getter|1|30-postInit
            Rules.append("Create Rules", null);
            Rules.append("Edit Rules", null);
            Rules.append("Download Rules", null);
            Rules.addCommand(getBackCommand());
            Rules.setCommandListener(this);
            Rules.setSelectedFlags(new boolean[] { false, false, false });//GEN-END:|30-getter|1|30-postInit
        // write post-init user code here
        }//GEN-BEGIN:|30-getter|2|
        return Rules;
    }
    //</editor-fold>//GEN-END:|30-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: RulesAction ">//GEN-BEGIN:|30-action|0|30-preAction
    /**
     * Performs an action assigned to the selected list element in the Rules component.
     */
    public void RulesAction() {//GEN-END:|30-action|0|30-preAction
        // enter pre-action user code here
        String __selectedString = getRules().getString(getRules().getSelectedIndex());//GEN-BEGIN:|30-action|1|34-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Create Rules")) {//GEN-END:|30-action|1|34-preAction
                // write pre-action user code here
                switchDisplayable(null, getContextDefine());//GEN-LINE:|30-action|2|34-postAction
            // write post-action user code here
            } else if (__selectedString.equals("Edit Rules")) {//GEN-LINE:|30-action|3|35-preAction
                // write pre-action user code here
                switchDisplayable(null, getRulesCreated());//GEN-LINE:|30-action|4|35-postAction
            // write post-action user code here
            } else if (__selectedString.equals("Download Rules")) {//GEN-LINE:|30-action|5|108-preAction
                // write pre-action user code here
                switchDisplayable(null, getDownloads());//GEN-LINE:|30-action|6|108-postAction
            // write post-action user code here
            }//GEN-BEGIN:|30-action|7|30-postAction
        }//GEN-END:|30-action|7|30-postAction
    // enter post-action user code here
    }//GEN-BEGIN:|30-action|8|
    //</editor-fold>//GEN-END:|30-action|8|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ContextDefine ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initiliazed instance of ContextDefine component.
     * @return the initialized component instance
     */
    public List getContextDefine() {
        if (ContextDefine == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            ContextDefine = new List("list", Choice.IMPLICIT);//GEN-BEGIN:|40-getter|1|40-postInit
            ContextDefine.append("NewContext", null);
            ContextDefine.append("ExistContext", null);
            ContextDefine.addCommand(getBackCommand());
            ContextDefine.setCommandListener(this);
            ContextDefine.setSelectedFlags(new boolean[] { false, false });//GEN-END:|40-getter|1|40-postInit
        // write post-init user code here
        }//GEN-BEGIN:|40-getter|2|
        return ContextDefine;
    }
    //</editor-fold>//GEN-END:|40-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ContextDefineAction ">//GEN-BEGIN:|40-action|0|40-preAction
    /**
     * Performs an action assigned to the selected list element in the ContextDefine component.
     */
    public void ContextDefineAction() {//GEN-END:|40-action|0|40-preAction
        // enter pre-action user code here
        String __selectedString = getContextDefine().getString(getContextDefine().getSelectedIndex());//GEN-BEGIN:|40-action|1|43-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("NewContext")) {//GEN-END:|40-action|1|43-preAction
                // write pre-action user code here
                switchDisplayable(null, getNewContext());//GEN-LINE:|40-action|2|43-postAction
            // write post-action user code here
            } else if (__selectedString.equals("ExistContext")) {//GEN-LINE:|40-action|3|44-preAction
                // write pre-action user code here
                switchDisplayable(null, getExistContext());//GEN-LINE:|40-action|4|44-postAction
            // write post-action user code here
            }//GEN-BEGIN:|40-action|5|40-postAction
        }//GEN-END:|40-action|5|40-postAction
    // enter post-action user code here
    }//GEN-BEGIN:|40-action|6|
    //</editor-fold>//GEN-END:|40-action|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: NewContext ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of NewContext component.
     * @return the initialized component instance
     */
    public Form getNewContext() {
        if (NewContext == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
            NewContext = new Form("Define Ur Context", new Item[] { getContextname(), getContextmedium(), getContextid() });//GEN-BEGIN:|45-getter|1|45-postInit
            NewContext.addCommand(getSaveContext());
            NewContext.addCommand(getBackCommand());
            NewContext.setCommandListener(this);//GEN-END:|45-getter|1|45-postInit
        // write post-init user code here
        }//GEN-BEGIN:|45-getter|2|
        return NewContext;
    }
    //</editor-fold>//GEN-END:|45-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: contextname ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of contextname component.
     * @return the initialized component instance
     */
    public TextField getContextname() {
        if (contextname == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            contextname = new TextField("ContextName", null, 32, TextField.ANY);//GEN-LINE:|47-getter|1|47-postInit
        // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return contextname;
    }
    //</editor-fold>//GEN-END:|47-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: contextmedium ">//GEN-BEGIN:|48-getter|0|48-preInit
    /**
     * Returns an initiliazed instance of contextmedium component.
     * @return the initialized component instance
     */
    public ChoiceGroup getContextmedium() {
        if (contextmedium == null) {//GEN-END:|48-getter|0|48-preInit
            // write pre-init user code here
            contextmedium = new ChoiceGroup("ContextMedium", Choice.EXCLUSIVE);//GEN-BEGIN:|48-getter|1|48-postInit
            contextmedium.append("Bluetooth", null);
            contextmedium.append("WiFi", null);
            contextmedium.setSelectedFlags(new boolean[] { false, false });
            contextmedium.setFont(0, null);
            contextmedium.setFont(1, null);//GEN-END:|48-getter|1|48-postInit
        // write post-init user code here
        }//GEN-BEGIN:|48-getter|2|
        return contextmedium;
    }
    //</editor-fold>//GEN-END:|48-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: contextid ">//GEN-BEGIN:|52-getter|0|52-preInit
    /**
     * Returns an initiliazed instance of contextid component.
     * @return the initialized component instance
     */
    public TextField getContextid() {
        if (contextid == null) {//GEN-END:|52-getter|0|52-preInit
            // write pre-init user code here
            contextid = new TextField("ContextId", null, 32, TextField.ANY);//GEN-LINE:|52-getter|1|52-postInit
        // write post-init user code here
        }//GEN-BEGIN:|52-getter|2|
        return contextid;
    }
    //</editor-fold>//GEN-END:|52-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SaveContext ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initiliazed instance of SaveContext component.
     * @return the initialized component instance
     */
    public Command getSaveContext() {
        if (SaveContext == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            SaveContext = new Command("SaveContext", Command.ITEM, 0);//GEN-LINE:|58-getter|1|58-postInit
        // write post-init user code here
        }//GEN-BEGIN:|58-getter|2|
        return SaveContext;
    }
    //</editor-fold>//GEN-END:|58-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of backCommand1 component.
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|60-getter|1|60-postInit
        // write post-init user code here
        }//GEN-BEGIN:|60-getter|2|
        return backCommand1;
    }
    //</editor-fold>//GEN-END:|60-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ExistContext ">//GEN-BEGIN:|65-getter|0|65-preInit
    /**
     * Returns an initiliazed instance of ExistContext component.
     * @return the initialized component instance
     */
    public Form getExistContext() {
        if (ExistContext == null) {//GEN-END:|65-getter|0|65-preInit
            // write pre-init user code here
            ExistContext = new Form("Define Actions", new Item[] { getExistcontext(), getAction() });//GEN-BEGIN:|65-getter|1|65-postInit
            ExistContext.addCommand(getBackCommand());
            ExistContext.addCommand(getSaveRule());
            ExistContext.setCommandListener(this);//GEN-END:|65-getter|1|65-postInit






        // write post-init user code here
        }//GEN-BEGIN:|65-getter|2|
        return ExistContext;
    }
    //</editor-fold>//GEN-END:|65-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: existcontext ">//GEN-BEGIN:|68-getter|0|68-preInit
    /**
     * Returns an initiliazed instance of existcontext component.
     * @return the initialized component instance
     */
    public ChoiceGroup getExistcontext() {
        if (existcontext == null) {//GEN-END:|68-getter|0|68-preInit
            // write pre-init user code here
            existcontext = new ChoiceGroup("Select Context", Choice.EXCLUSIVE);//GEN-BEGIN:|68-getter|1|68-postInit
            existcontext.setSelectedFlags(new boolean[] {  });//GEN-END:|68-getter|1|68-postInit
            StreamConnection c = null;
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
                        for (int j = 0; j < babies; j++) {
                            if (el.getName().compareTo("context") == 0) {
                                existcontext.append(el.getText(), null);
                            }
                        }

                    }
                }
            } catch (Exception ioe) {
                ContextDefine.append("final catch" + ioe.toString(), null);
            }

        //     ExistContext.append(contextgroup);

        }//GEN-BEGIN:|68-getter|2|
        return existcontext;
    }
    //</editor-fold>//GEN-END:|68-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: action ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initiliazed instance of action component.
     * @return the initialized component instance
     */
    public ChoiceGroup getAction() {
        if (action == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            action = new ChoiceGroup("Action", Choice.MULTIPLE);//GEN-BEGIN:|70-getter|1|70-postInit
            action.append("Sms", null);
            action.append("Camera", null);
            action.append("Voice Recorder", null);
            action.append("Alert", null);
            action.setSelectedFlags(new boolean[] { false, false, false, false });
            action.setFont(0, null);
            action.setFont(1, null);
            action.setFont(2, null);
            action.setFont(3, null);//GEN-END:|70-getter|1|70-postInit
        // write post-init user code here
        }//GEN-BEGIN:|70-getter|2|
        return action;
    }
    //</editor-fold>//GEN-END:|70-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SaveRule ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initiliazed instance of SaveRule component.
     * @return the initialized component instance
     */
    public Command getSaveRule() {
        if (SaveRule == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            SaveRule = new Command("SaveRule", Command.ITEM, 0);//GEN-LINE:|76-getter|1|76-postInit
        // write post-init user code here
        }//GEN-BEGIN:|76-getter|2|
        return SaveRule;
    }
    //</editor-fold>//GEN-END:|76-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ActionForm ">//GEN-BEGIN:|83-getter|0|83-preInit
    /**
     * Returns an initiliazed instance of ActionForm component.
     * @return the initialized component instance
     */
    public Form getActionForm() {
        if (ActionForm == null) {//GEN-END:|83-getter|0|83-preInit
            // write pre-init user code here
            ActionForm = new Form("ActionForm");//GEN-BEGIN:|83-getter|1|83-postInit
            ActionForm.addCommand(getBackCommand());
            ActionForm.addCommand(getCapture());
            ActionForm.setCommandListener(this);//GEN-END:|83-getter|1|83-postInit
        // write post-init user code here
        }//GEN-BEGIN:|83-getter|2|
        return ActionForm;
    }
    //</editor-fold>//GEN-END:|83-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|85-getter|0|85-preInit
    /**
     * Returns an initiliazed instance of exitCommand1 component.
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {//GEN-END:|85-getter|0|85-preInit
            // write pre-init user code here
            exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|85-getter|1|85-postInit
        // write post-init user code here
        }//GEN-BEGIN:|85-getter|2|
        return exitCommand1;
    }
    //</editor-fold>//GEN-END:|85-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: save_audio ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initiliazed instance of save_audio component.
     * @return the initialized component instance
     */
    public Command getSave_audio() {
        if (save_audio == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            save_audio = new Command("Save", Command.ITEM, 0);//GEN-LINE:|89-getter|1|89-postInit
        // write post-init user code here
        }//GEN-BEGIN:|89-getter|2|
        return save_audio;
    }
    //</editor-fold>//GEN-END:|89-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Capture ">//GEN-BEGIN:|90-getter|0|90-preInit
    /**
     * Returns an initiliazed instance of Capture component.
     * @return the initialized component instance
     */
    public Command getCapture() {
        if (Capture == null) {//GEN-END:|90-getter|0|90-preInit
            // write pre-init user code here
            Capture = new Command("Capture", Command.ITEM, 0);//GEN-LINE:|90-getter|1|90-postInit
        // write post-init user code here
        }//GEN-BEGIN:|90-getter|2|
        return Capture;
    }
    //</editor-fold>//GEN-END:|90-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: RulesCreated ">//GEN-BEGIN:|92-getter|0|92-preInit
    /**
     * Returns an initiliazed instance of RulesCreated component.
     * @return the initialized component instance
     */
    public List getRulesCreated() {
        if (RulesCreated == null) {//GEN-END:|92-getter|0|92-preInit
            // write pre-init user code here
            RulesCreated = new List("Rule List", Choice.EXCLUSIVE);//GEN-BEGIN:|92-getter|1|92-postInit
            RulesCreated.addCommand(getBackCommand());
            RulesCreated.addCommand(getEdit());
            RulesCreated.setCommandListener(this);//GEN-END:|92-getter|1|92-postInit
            StreamConnection c = null;
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
                        for (int j = 0; j < babies; j++) {
                            if (el.getName().compareTo("context") == 0) {
                                RulesCreated.append(el.getText(), null);
                            }
                        }

                    }
                }
            } catch (Exception ioe) {
                RulesCreated.append(ioe.toString(), null);
            }
        // write post-init user code here
        }//GEN-BEGIN:|92-getter|2|
        return RulesCreated;
    }
    //</editor-fold>//GEN-END:|92-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: RulesCreatedAction ">//GEN-BEGIN:|92-action|0|92-preAction
    /**
     * Performs an action assigned to the selected list element in the RulesCreated component.
     */
    public void RulesCreatedAction() {//GEN-END:|92-action|0|92-preAction
        // enter pre-action user code here
        String __selectedString = getRulesCreated().getString(getRulesCreated().getSelectedIndex());//GEN-LINE:|92-action|1|92-postAction
    // enter post-action user code here
    }//GEN-BEGIN:|92-action|2|
    //</editor-fold>//GEN-END:|92-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Start ">//GEN-BEGIN:|106-getter|0|106-preInit
    /**
     * Returns an initiliazed instance of Start component.
     * @return the initialized component instance
     */
    public Command getStart() {
        if (Start == null) {//GEN-END:|106-getter|0|106-preInit
            // write pre-init user code here
            Start = new Command("Start", Command.ITEM, 0);//GEN-LINE:|106-getter|1|106-postInit
        // write post-init user code here
        }//GEN-BEGIN:|106-getter|2|
        return Start;
    }
    //</editor-fold>//GEN-END:|106-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Downloads ">//GEN-BEGIN:|110-getter|0|110-preInit
    /**
     * Returns an initiliazed instance of Downloads component.
     * @return the initialized component instance
     */
    public List getDownloads() {
        if (Downloads == null) {//GEN-END:|110-getter|0|110-preInit
            // write pre-init user code here
            Downloads = new List("list", Choice.IMPLICIT);//GEN-BEGIN:|110-getter|1|110-postInit
            Downloads.append("PC", null);
            Downloads.append("Web", null);
            Downloads.addCommand(getBackCommand());
            Downloads.setCommandListener(this);
            Downloads.setSelectedFlags(new boolean[] { false, false });//GEN-END:|110-getter|1|110-postInit
        // write post-init user code here
        }//GEN-BEGIN:|110-getter|2|
        return Downloads;
    }
    //</editor-fold>//GEN-END:|110-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: DownloadsAction ">//GEN-BEGIN:|110-action|0|110-preAction
    /**
     * Performs an action assigned to the selected list element in the Downloads component.
     */
    public void DownloadsAction() {//GEN-END:|110-action|0|110-preAction
        // enter pre-action user code here
        String __selectedString = getDownloads().getString(getDownloads().getSelectedIndex());//GEN-BEGIN:|110-action|1|113-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("PC")) {//GEN-END:|110-action|1|113-preAction
                String[] file = {"contextinf.xml",};
                try {
                    switchDisplayable(null, ObexPutClient.f);
                    ObexPutClient.main_client(file);
                //  ObexPutClient.disconnect();
                // write pre-action user code here
                // write post-action user code here
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                // write pre-action user code here

                switchDisplayable(null, getContext_available());//GEN-LINE:|110-action|2|113-postAction
            //   download_pc();
            // write post-action user code here
            } else if (__selectedString.equals("Web")) {//GEN-LINE:|110-action|3|114-preAction
                // write pre-action user code here
//GEN-LINE:|110-action|4|114-postAction
                // write post-action user code here
            }//GEN-BEGIN:|110-action|5|110-postAction
        }//GEN-END:|110-action|5|110-postAction
    // enter post-action user code here
    }//GEN-BEGIN:|110-action|6|
    //</editor-fold>//GEN-END:|110-action|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand2 ">//GEN-BEGIN:|117-getter|0|117-preInit
    /**
     * Returns an initiliazed instance of exitCommand2 component.
     * @return the initialized component instance
     */
    public Command getExitCommand2() {
        if (exitCommand2 == null) {//GEN-END:|117-getter|0|117-preInit
            // write pre-init user code here
            exitCommand2 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|117-getter|1|117-postInit
        // write post-init user code here
        }//GEN-BEGIN:|117-getter|2|
        return exitCommand2;
    }
    //</editor-fold>//GEN-END:|117-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: DynamicOption ">//GEN-BEGIN:|124-getter|0|124-preInit
    /**
     * Returns an initiliazed instance of DynamicOption component.
     * @return the initialized component instance
     */
    public List getDynamicOption() {
        if (DynamicOption == null) {//GEN-END:|124-getter|0|124-preInit
            // write pre-init user code here
            DynamicOption = new List("DynamicOption", Choice.IMPLICIT);//GEN-BEGIN:|124-getter|1|124-postInit
            DynamicOption.addCommand(getBackCommand());
            DynamicOption.addCommand(getExitCommand());
            DynamicOption.setCommandListener(this);//GEN-END:|124-getter|1|124-postInit
        // write post-init user code here
        }//GEN-BEGIN:|124-getter|2|
        return DynamicOption;
    }
    //</editor-fold>//GEN-END:|124-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: DynamicOptionAction ">//GEN-BEGIN:|124-action|0|124-preAction
    /**
     * Performs an action assigned to the selected list element in the DynamicOption component.
     */
    public void DynamicOptionAction() {//GEN-END:|124-action|0|124-preAction
        // enter pre-action user code here
        String __selectedString = getDynamicOption().getString(getDynamicOption().getSelectedIndex());//GEN-LINE:|124-action|1|124-postAction
        if (__selectedString.equals(new String("Notes"))) {

            switchDisplayable(null, getTextBox());
        //
        //  DynamicActionForm.append(new TextField(found, found, maxSize, constraints));
        }
        if (__selectedString.equals(new String("Camera"))) {
            try {
                Player m_objPlayer = Manager.createPlayer("capture://video");
                m_objPlayer.realize();
                switchDisplayable(null, getActionForm());
                m_objVideoControl = (VideoControl) m_objPlayer.getControl("VideoControl");
                if (m_objVideoControl != null) {
                    ActionForm.append((Item) m_objVideoControl.initDisplayMode(
                            VideoControl.USE_GUI_PRIMITIVE, null));
                    m_objPlayer.start();
                }
            } catch (Exception exc) {
                ObexPutClient.f.append("camera Exception:" + exc.toString());
// handle Exception
            }
        }
        if (__selectedString.equals(new String("Sms"))) {
            //switchDisplayable(null,DynamicActionForm);
            // DynamicActionForm.append("Sms");
            switchDisplayable(null, getSmsComposer());

        }

        if (__selectedString.equals(new String("VoiceRecorder"))) {
            switchDisplayable(null, getVoiceRecorder());




        }
    // enter post-action user code here
    }//GEN-BEGIN:|124-action|2|
    //</editor-fold>//GEN-END:|124-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Context_available ">//GEN-BEGIN:|132-getter|0|132-preInit
    /**
     * Returns an initiliazed instance of Context_available component.
     * @return the initialized component instance
     */
    public List getContext_available() {
        if (Context_available == null) {//GEN-END:|132-getter|0|132-preInit
            // write pre-init user code here
            Context_available = new List("ChooseContext", Choice.IMPLICIT);//GEN-BEGIN:|132-getter|1|132-postInit
            Context_available.addCommand(getBackCommand());
            Context_available.addCommand(getRetrive());
            Context_available.setCommandListener(this);//GEN-END:|132-getter|1|132-postInit
            download_pc();
        // write post-init user code here
        }//GEN-BEGIN:|132-getter|2|
        return Context_available;
    }
    //</editor-fold>//GEN-END:|132-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: Context_availableAction ">//GEN-BEGIN:|132-action|0|132-preAction
    /**
     * Performs an action assigned to the selected list element in the Context_available component.
     */
    public void Context_availableAction() {//GEN-END:|132-action|0|132-preAction
        // enter pre-action user code here
        String __selectedString = getContext_available().getString(getContext_available().getSelectedIndex());//GEN-LINE:|132-action|1|132-postAction
    // enter post-action user code here
    }//GEN-BEGIN:|132-action|2|
    //</editor-fold>//GEN-END:|132-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Retrive ">//GEN-BEGIN:|138-getter|0|138-preInit
    /**
     * Returns an initiliazed instance of Retrive component.
     * @return the initialized component instance
     */
    public Command getRetrive() {
        if (Retrive == null) {//GEN-END:|138-getter|0|138-preInit
            // write pre-init user code here
            Retrive = new Command("Item", Command.ITEM, 0);//GEN-LINE:|138-getter|1|138-postInit
        // write post-init user code here
        }//GEN-BEGIN:|138-getter|2|
        return Retrive;
    }
    //</editor-fold>//GEN-END:|138-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: smsComposer ">//GEN-BEGIN:|141-getter|0|141-preInit
    /**
     * Returns an initiliazed instance of smsComposer component.
     * @return the initialized component instance
     */
    public SMSComposer getSmsComposer() {
        if (smsComposer == null) {//GEN-END:|141-getter|0|141-preInit
            //getAppProperty("SMS-Port")

            // write pre-init user code here
            smsComposer = new SMSComposer(getDisplay());//GEN-BEGIN:|141-getter|1|141-postInit
            smsComposer.setTitle("smsComposer");
            smsComposer.addCommand(SMSComposer.SEND_COMMAND);
            smsComposer.addCommand(getBackCommand());
            smsComposer.setCommandListener(this);
            smsComposer.setBGColor(-3355444);
            smsComposer.setFGColor(-16777216);
            smsComposer.setPort(50000);
            smsComposer.setMessage("");
            smsComposer.setSendAutomatically(false);
            smsComposer.setPhoneNumberLabel("Phone Number :");
            smsComposer.setMessageLabel("Message :");//GEN-END:|141-getter|1|141-postInit

        // smsComposer.setMessage();
        // write post-init user code here
        }//GEN-BEGIN:|141-getter|2|
        return smsComposer;
    }
    //</editor-fold>//GEN-END:|141-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Send ">//GEN-BEGIN:|150-getter|0|150-preInit
    /**
     * Returns an initiliazed instance of Send component.
     * @return the initialized component instance
     */
    public Command getSend() {
        if (Send == null) {//GEN-END:|150-getter|0|150-preInit
            // write pre-init user code here
            Send = new Command("Send Sms", Command.ITEM, 0);//GEN-LINE:|150-getter|1|150-postInit
        // write post-init user code here
        }//GEN-BEGIN:|150-getter|2|
        return Send;
    }
    //</editor-fold>//GEN-END:|150-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image ">//GEN-BEGIN:|155-getter|0|155-preInit
    /**
     * Returns an initiliazed instance of image component.
     * @return the initialized component instance
     */
    public Image getImage() {
        if (image == null) {//GEN-END:|155-getter|0|155-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|155-getter|1|155-@java.io.IOException
                image = Image.createImage("/AI-brain.jpg");
            } catch (java.io.IOException e) {//GEN-END:|155-getter|1|155-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|155-getter|2|155-postInit
        // write post-init user code here
        }//GEN-BEGIN:|155-getter|3|
        return image;
    }
    //</editor-fold>//GEN-END:|155-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|152-getter|0|152-preInit
    /**
     * Returns an initiliazed instance of splashScreen component.
     * @return the initialized component instance
     */
    public SplashScreen getSplashScreen() {
        if (splashScreen == null) {//GEN-END:|152-getter|0|152-preInit
            // write pre-init user code here
            splashScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|152-getter|1|152-postInit
            splashScreen.setTitle("splashScreen");
            splashScreen.setCommandListener(this);
            splashScreen.setFullScreenMode(true);
            splashScreen.setImage(getImage());
            splashScreen.setTimeout(4000);//GEN-END:|152-getter|1|152-postInit
        // write post-init user code here
        }//GEN-BEGIN:|152-getter|2|
        return splashScreen;
    }
    //</editor-fold>//GEN-END:|152-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Save ">//GEN-BEGIN:|164-getter|0|164-preInit
    /**
     * Returns an initiliazed instance of Save component.
     * @return the initialized component instance
     */
    public Command getSave() {
        if (Save == null) {//GEN-END:|164-getter|0|164-preInit
            // write pre-init user code here
            Save = new Command("Save", Command.ITEM, 0);//GEN-LINE:|164-getter|1|164-postInit
        // write post-init user code here
        }//GEN-BEGIN:|164-getter|2|
        return Save;
    }
    //</editor-fold>//GEN-END:|164-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Contextmenu ">//GEN-BEGIN:|158-getter|0|158-preInit
    /**
     * Returns an initiliazed instance of Contextmenu component.
     * @return the initialized component instance
     */
    public Form getContextmenu() {
        if (Contextmenu == null) {//GEN-END:|158-getter|0|158-preInit
            // write pre-init user code here
            Contextmenu = new Form("Contextmenu", new Item[] { getMenuoptions() });//GEN-BEGIN:|158-getter|1|158-postInit
            Contextmenu.addCommand(getSave());
            Contextmenu.addCommand(getBackCommand());
            Contextmenu.setCommandListener(this);//GEN-END:|158-getter|1|158-postInit
        // write post-init user code here
        }//GEN-BEGIN:|158-getter|2|
        return Contextmenu;
    }
    //</editor-fold>//GEN-END:|158-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: menuoptions ">//GEN-BEGIN:|159-getter|0|159-preInit
    /**
     * Returns an initiliazed instance of menuoptions component.
     * @return the initialized component instance
     */
    public ChoiceGroup getMenuoptions() {
        if (menuoptions == null) {//GEN-END:|159-getter|0|159-preInit
            // write pre-init user code here
            menuoptions = new ChoiceGroup("Menu Options", Choice.MULTIPLE);//GEN-BEGIN:|159-getter|1|159-postInit
            menuoptions.append("Sms", null);
            menuoptions.append("Camera", null);
            menuoptions.append("VoiceRecorder", null);
            menuoptions.append("Notes", null);
            menuoptions.setSelectedFlags(new boolean[] { false, false, false, false });
            menuoptions.setFont(0, null);
            menuoptions.setFont(1, null);
            menuoptions.setFont(2, null);
            menuoptions.setFont(3, null);//GEN-END:|159-getter|1|159-postInit
        // write post-init user code here
        }//GEN-BEGIN:|159-getter|2|
        return menuoptions;
    }
    //</editor-fold>//GEN-END:|159-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: DynamicActionForm ">//GEN-BEGIN:|170-getter|0|170-preInit
    /**
     * Returns an initiliazed instance of DynamicActionForm component.
     * @return the initialized component instance
     */
    public Form getDynamicActionForm() {
        if (DynamicActionForm == null) {//GEN-END:|170-getter|0|170-preInit
            // write pre-init user code here
            DynamicActionForm = new Form("form");//GEN-BEGIN:|170-getter|1|170-postInit
            DynamicActionForm.addCommand(getBackCommand());
            DynamicActionForm.addCommand(getCapture());
            DynamicActionForm.setCommandListener(this);//GEN-END:|170-getter|1|170-postInit
        // write post-init user code here
        }//GEN-BEGIN:|170-getter|2|
        return DynamicActionForm;
    }
    //</editor-fold>//GEN-END:|170-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Savetext ">//GEN-BEGIN:|174-getter|0|174-preInit
    /**
     * Returns an initiliazed instance of Savetext component.
     * @return the initialized component instance
     */
    public Command getSavetext() {
        if (Savetext == null) {//GEN-END:|174-getter|0|174-preInit
            // write pre-init user code here
            Savetext = new Command("Item", Command.ITEM, 0);//GEN-LINE:|174-getter|1|174-postInit
        // write post-init user code here
        }//GEN-BEGIN:|174-getter|2|
        return Savetext;
    }
    //</editor-fold>//GEN-END:|174-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textBox ">//GEN-BEGIN:|173-getter|0|173-preInit
    /**
     * Returns an initiliazed instance of textBox component.
     * @return the initialized component instance
     */
    public TextBox getTextBox() {
        if (textBox == null) {//GEN-END:|173-getter|0|173-preInit
            // write pre-init user code here
            textBox = new TextBox("textBox", null, 100, TextField.ANY);//GEN-BEGIN:|173-getter|1|173-postInit
            textBox.addCommand(getSavetext());
            textBox.addCommand(getBackCommand());
            textBox.setCommandListener(this);//GEN-END:|173-getter|1|173-postInit

        // write post-init user code here
        }//GEN-BEGIN:|173-getter|2|
        return textBox;
    }
    //</editor-fold>//GEN-END:|173-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Select ">//GEN-BEGIN:|181-getter|0|181-preInit
    /**
     * Returns an initiliazed instance of Select component.
     * @return the initialized component instance
     */
    public Command getSelect() {
        if (Select == null) {//GEN-END:|181-getter|0|181-preInit
            // write pre-init user code here
            Select = new Command("Item", Command.ITEM, 0);//GEN-LINE:|181-getter|1|181-postInit
        // write post-init user code here
        }//GEN-BEGIN:|181-getter|2|
        return Select;
    }
    //</editor-fold>//GEN-END:|181-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: VoiceRecorder ">//GEN-BEGIN:|186-getter|0|186-preInit
    /**
     * Returns an initiliazed instance of VoiceRecorder component.
     * @return the initialized component instance
     */
    public Form getVoiceRecorder() {
        if (VoiceRecorder == null) {//GEN-END:|186-getter|0|186-preInit
            // write pre-init user code here
            VoiceRecorder = new Form("Voice Recorder");//GEN-BEGIN:|186-getter|1|186-postInit
            VoiceRecorder.addCommand(getStart());
            VoiceRecorder.addCommand(getStop());
            VoiceRecorder.addCommand(getBackCommand());
            VoiceRecorder.setCommandListener(this);//GEN-END:|186-getter|1|186-postInit
        // write post-init user code here
        }//GEN-BEGIN:|186-getter|2|
        return VoiceRecorder;
    }
    //</editor-fold>//GEN-END:|186-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Stop ">//GEN-BEGIN:|188-getter|0|188-preInit
    /**
     * Returns an initiliazed instance of Stop component.
     * @return the initialized component instance
     */
    public Command getStop() {
        if (Stop == null) {//GEN-END:|188-getter|0|188-preInit
            // write pre-init user code here
            Stop = new Command("Stop", Command.ITEM, 0);//GEN-LINE:|188-getter|1|188-postInit
        // write post-init user code here
        }//GEN-BEGIN:|188-getter|2|
        return Stop;
    }
    //</editor-fold>//GEN-END:|188-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Filename ">//GEN-BEGIN:|192-getter|0|192-preInit
    /**
     * Returns an initiliazed instance of Filename component.
     * @return the initialized component instance
     */
    public TextBox getFilename() {
        if (Filename == null) {//GEN-END:|192-getter|0|192-preInit
            // write pre-init user code here
            Filename = new TextBox("Enter File Name", null, 100, TextField.ANY);//GEN-BEGIN:|192-getter|1|192-postInit
            Filename.addCommand(getSave_audio());
            Filename.addCommand(getBackCommand());
            Filename.setCommandListener(this);//GEN-END:|192-getter|1|192-postInit
        // write post-init user code here
        }//GEN-BEGIN:|192-getter|2|
        return Filename;
    }
    //</editor-fold>//GEN-END:|192-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ticker ">//GEN-BEGIN:|203-getter|0|203-preInit
    /**
     * Returns an initiliazed instance of ticker component.
     * @return the initialized component instance
     */
    public Ticker getTicker() {
        if (ticker == null) {//GEN-END:|203-getter|0|203-preInit
            // write pre-init user code here
            ticker = new Ticker("WELCOME TO RUL-E-NGINE");//GEN-LINE:|203-getter|1|203-postInit
            // write post-init user code here
        }//GEN-BEGIN:|203-getter|2|
        return ticker;
    }
    //</editor-fold>//GEN-END:|203-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void retrive_devices() {

        StreamConnection c = null;
        InputStream s = null;
        ObexPutClient.f.append("Inside retrive");
        try {
            c = (StreamConnection) Connector.open("file:///e:/context.xml");
            s = c.openInputStream();
            XmlParser parser = new XmlParser(new InputStreamReader(s));
            Document document = new Document();
            document.parse(parser);

            org.kxml.kdom.Element root = document.getRootElement();
            int children = root.getChildCount();
            ObexPutClient.f.append("Coming inside try statement");

            for (int i = 0; i < children; i++) {
                if (root.getType(i) == Xml.ELEMENT) {
                    org.kxml.kdom.Element el = root.getElement(i);
                    int babies = el.getChildCount();
                    for (int j = 0, k = 0; j < babies; j++) {
                        if (el.getName().compareTo("context") == 0) {
                            Contextname[k] = el.getText();
                            ObexPutClient.f.append(Contextname[k]);
                        }
                        if (el.getName().compareTo("contextid") == 0) {
                            Contextid[k] = el.getText();
                            ObexPutClient.f.append(Contextid[k]);
                            k++;
                        }
                    }

                }
            }
            ObexPutClient.f.append("succesfully parsed");
        } catch (Exception ioe) {
            ObexPutClient.f.append("final catch" + ioe.toString());
        }
    /*  for (int i = 0; i < Contextname.length; i++) {
    if (Contextid[i].compareTo(found) == 0) {
    ObexPutClient.f.append("ContextName=" + Contextname);
    }
    }*/

    }

    public void retrive_action(String filen) {
        StreamConnection c = null;
        InputStream s = null;
        ObexPutClient.f.append("Inside Action Ret with filen" + filen);
        try {
            c = (StreamConnection) Connector.open("file:///e:/" + filen + ".xml");
            s = c.openInputStream();
            XmlParser parser = new XmlParser(new InputStreamReader(s));
            Document document = new Document();
            document.parse(parser);

            org.kxml.kdom.Element root = document.getRootElement();
            int children = root.getChildCount();
            ObexPutClient.f.append("Coming in try statement");
            int k = 0;
            for (int i = 0; i < children; i++) {

                if (root.getType(i) == Xml.ELEMENT) {
                    org.kxml.kdom.Element el = root.getElement(i);
                    int babies = el.getChildCount();
                    for (int j = 0; j < babies; j++) {
                        if (el.getName().compareTo("action") == 0) {
                            Contextaction[k] = el.getText();
                            ObexPutClient.f.append(Contextaction[k] + "i=" + k);
                            k++;
                        }

                    }

                }
            }
            ObexPutClient.f.append("succesfully parsed action");
        } catch (Exception ioe) {
            ObexPutClient.f.append("final catch" + ioe.toString());
        }

    }

    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    public void activate() {
        for (int i = 0; Contextaction[i] != null; i++) {
            ObexPutClient.f.append("coming inside for" + Contextaction[i]);
            if (Contextaction[i].equals(new String("Camera"))) {
                try {
                    Player m_objPlayer = Manager.createPlayer("capture://video");
                    m_objPlayer.realize();
                    switchDisplayable(null, getActionForm());
                    m_objVideoControl = (VideoControl) m_objPlayer.getControl("VideoControl");
                    if (m_objVideoControl != null) {
                        ActionForm.append((Item) m_objVideoControl.initDisplayMode(
                                VideoControl.USE_GUI_PRIMITIVE, null));
                        m_objPlayer.start();
                    }
                } catch (Exception exc) {
                    ObexPutClient.f.append("camera Exception:" + exc.toString());
// handle Exception
                }

            }
            if (Contextaction[i].equals(new String("Sms"))) {
                ObexPutClient.f.append("coming inside Sms");
                switchDisplayable(null, getSmsComposer());
            //switchDisplayable(null, getSmsComposer());
            }
            if (Contextaction[i].equals(new String("VoiceRecorder"))) {
                switchDisplayable(null, getVoiceRecorder());
            }
            if (Contextaction[i].equals(new String("Alert"))) {
                Alert a = new Alert("Alerting you ");
                switchDisplayable(a, getDynamicOption());
                set_dynamic_option();
                a.setString("Identified Context"+current_context);
                a.setTimeout(Alert.FOREVER);
            }

        }
    //  ObexPutClient.activate_camera();

    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void set_dynamic_option() {
        StreamConnection c = null;
        InputStream s = null;
        DynamicOption.append("Welcome , Context: " + current_context, null);
        try {
            c = (StreamConnection) Connector.open("file:///e:/" + current_context + "_menu.xml");
            s = c.openInputStream();
            XmlParser parser = new XmlParser(new InputStreamReader(s));
            Document document = new Document();
            document.parse(parser);

            org.kxml.kdom.Element root = document.getRootElement();
            int children = root.getChildCount();
            //DynamicOption.append("Coming in SET DYNAMIC OPTION statement", null);

            for (int i = 0; i < children; i++) {
                if (root.getType(i) == Xml.ELEMENT) {
                    org.kxml.kdom.Element el = root.getElement(i);
                    int babies = el.getChildCount();
                    for (int j = 0, k = 0; j < babies; j++) {
                        if (el.getName().compareTo("menu") == 0) {
                            Contextaction[k] = el.getText();
                            DynamicOption.append(Contextaction[k], null);
                            k++;
                        }

                    }

                }
            }
        // DynamicOption.append("succesfully parsed action", null);
        } catch (Exception ioe) {
            DynamicOption.append("final catch" + ioe.toString(), null);
        }


    }

    public void download_pc() {
        StreamConnection c = null;
        InputStream s = null;
        // Context_available.append("Inside retrive",null);
        try {
            c = (StreamConnection) Connector.open("file:///e:/contextinf.xml");
            s = c.openInputStream();
            XmlParser parser = new XmlParser(new InputStreamReader(s));
            Document document = new Document();
            document.parse(parser);

            org.kxml.kdom.Element root = document.getRootElement();
            int children = root.getChildCount();
            //    Context_available.append("Coming inside try statement", null);

            for (int i = 0; i < children; i++) {
                if (root.getType(i) == Xml.ELEMENT) {
                    org.kxml.kdom.Element el = root.getElement(i);
                    int babies = el.getChildCount();
                    for (int j = 0, k = 0; j < babies; j++) {
                        if (el.getName().compareTo("context") == 0) {
                            Contextname[k] = el.getText();
                            Context_available.append(Contextname[k], null);
                        }
                        if (el.getName().compareTo("medium") == 0) {
                            Contextmed_pc[k] = el.getText();
                        //Context_available.append(Contextname[k], null);
                        }
                        if (el.getName().compareTo("contextid") == 0) {
                            Contextid_pc[k] = el.getText();
                            k++;
                        //Context_available.append(Contextname[k], null);
                        }
                    }

                }
            }
        //   Context_available.append("succesfully parsed",null);
        } catch (Exception ioe) {
            Context_available.append("final catch" + ioe.toString(), null);
        }
    }

    public void update_local_context_file(String dwnld_context, String id, String med) {
        int found = 0;
        StreamConnection c = null;
        InputStream s = null;
        try {
            c = (StreamConnection) Connector.open("file:///e:/context.xml");
            s = c.openInputStream();
            XmlParser parser = new XmlParser(new InputStreamReader(s));
            Document document = new Document();
            document.parse(parser);

            org.kxml.kdom.Element root = document.getRootElement();
            int children = root.getChildCount();
            //    Context_available.append("Coming inside try statement", null);

            for (int i = 0; i < children; i++) {
                if (root.getType(i) == Xml.ELEMENT) {
                    org.kxml.kdom.Element el = root.getElement(i);
                    int babies = el.getChildCount();
                    for (int j = 0, k = 0; j < babies; j++) {
                        if (el.getName().compareTo("context") == 0) {
                            Contextname[k] = el.getText();
                            if (Contextname[k].equals(dwnld_context)) {
                                found = 1;
                            }
                        }
                    }

                }
            }
            if (found == 0) {
                FileConnection filecon = (FileConnection) Connector.open("file:///e:/context.xml");

                DataInputStream in = filecon.openDataInputStream();
                String b = "";
                if (in.available() > 0) {

                    int a = in.read();

                    while (a != -1) {
                        b = b + (char) a;
                        a = in.read();
                    }
                }



                String newcontent = b.substring(0, b.length() - 10);
                in.close();

                filecon.delete();
                filecon.close();
                filecon = (FileConnection) Connector.open("file:///e:/context.xml");
                if (!filecon.exists()) {
                    filecon.create();

                }
                OutputStream out = filecon.openOutputStream();
                PrintStream output = new PrintStream(out);
                output.println(newcontent);
                output.println("<context>" + dwnld_context + "</context>");
                output.println("<Medium>" + med + "</Medium>");
                output.println("<contextid>" + id + "</contextid>");
                output.println("</rooter>");
                output.close();
                out.close();


                filecon.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }

    public void startrecording() {
        try {
            VoiceRecorder.append("Recording");
            b_audPlayer = Manager.createPlayer("capture://audio");
            b_audPlayer.realize();
            //  VoiceRecorder.append(b_audPlayer);
            rc = (RecordControl) b_audPlayer.getControl("RecordControl");
            outp = new ByteArrayOutputStream();
            rc.setRecordStream(outp);
            rc.startRecord();
            b_audPlayer.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
    }

    public void stoprecording() {

        try {
            VoiceRecorder.append("finish record... ");
            VoiceRecorder.append("wait");
            VoiceRecorder.append("creating audio file.....");
            rc.stopRecord();
           // VoiceRecorder.append("1");
            rc.commit();
          //  VoiceRecorder.append("2");
            b_audPlayer.stop();
          //  VoiceRecorder.append("3");
            b_audPlayer.close();
            recordedSoundArray = outp.toByteArray();
            //String name = "audio";
        /*     fc = (FileConnection) Connector.open("file:///e:/audio.amr");
              if (!fc.exists()) {
                    fc.create();
                }
                dos = fc.openDataOutputStream();
                dos.write(recordedSoundArray);

            fc.close();*/
           

           
        } catch (Exception e) {
            VoiceRecorder.append("stop command: " + e.toString());
        }
    }


    //   Context_available.append("succesfully parsed",null);
    /**
     * Prompt for and send the message
     */
    public void destroyApp(boolean unconditional) {
    }
}
