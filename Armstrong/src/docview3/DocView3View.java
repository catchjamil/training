

package docview3;
import java.io.IOException;
import java.net.UnknownHostException;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdesktop.application.Task;

public class DocView3View extends FrameView {


    globalserver g=new globalserver();
    
    
    
    

    private File file = new File("untitled.txt");
    private boolean modified = false;
    private static boolean send = false, receive = false;
    private static String senderIP = "127.0.0.8";
    private static final int transmitPort = 56563;
    private static String sendFile;
    private static String receivedFile;
    private static boolean received;
    public DocView3View(SingleFrameApplication app) {
        super(app);

        initComponents();

       
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
        
    }


    public void startTransmission(){
        new Thread(new Runnable() {

            public void run() {

                    ServerSocket serverSocket=null;
                try {
                    serverSocket = new ServerSocket(transmitPort);
                    System.out.println("Server socket created : " + serverSocket);
                } catch (IOException ex) {
//                    Logger.getLogger(DocView3View.class.getName()).log(Level.SEVERE, null, ex);
                }
                    System.out.println("Server socket created : " + serverSocket);
                    if (serverSocket!=null) {
                        try {
                            Socket socket = serverSocket.accept();
                            System.out.println("connection accepted : " + socket);
                            OutputStream o = socket.getOutputStream();
                            BufferedOutputStream bos = new BufferedOutputStream(o);
                            DataOutputStream dos = new DataOutputStream(bos);
                            while (!send) {
                                Thread.sleep(10000);
                            }
                            System.out.println("Transmitting File");
                            if (sendFile != null && !sendFile.equals("")) {
                                File transferFile = new File(sendFile);
                                byte[] bytearray = new byte[(int) transferFile.length()];
                                FileInputStream fin = new FileInputStream(transferFile);
                                BufferedInputStream bin = new BufferedInputStream(fin);
                                bin.read(bytearray, 0, bytearray.length);
                                System.out.println("Sending File...");
                                o.write(bytearray, 0, bytearray.length);
                                o.flush();
                                socket.close();
                                System.out.println("File transfer complete");
                            }
                        } catch (Exception e) {
                            System.out.println("File Transfer failed.");
                            e.printStackTrace();
                        } finally {
                            send = false;
                            try{
                                if(serverSocket!=null) serverSocket.close();
                                serverSocket=null;
                            } catch (Exception e){}
                        }
                    }

            }


        }).start();
    }
    public File getFile() {
        return file;
    }


     private void setFile(File file) {
        File oldValue = this.file;
        this.file = file;
        String appId = getResourceMap().getString("Application.id");
        getFrame().setTitle(file.getName() + " - " + appId);
        firePropertyChange("file", oldValue, this.file);
    }




      public boolean isModified() {
        return modified;
    }

   
    private void setModified(boolean modified) {
        boolean oldValue = this.modified;
        this.modified = modified;
        firePropertyChange("modified", oldValue, this.modified);
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = DocView3App.getApplication().getMainFrame();
            aboutBox = new DocView3AboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        DocView3App.getApplication().show(aboutBox);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jComboBox1 = new javax.swing.JComboBox();

        mainPanel.setName("mainPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("JTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(docview3.DocView3App.class).getContext().getActionMap(DocView3View.class, this);
        jButton1.setAction(actionMap.get("Send")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(docview3.DocView3App.class).getContext().getResourceMap(DocView3View.class);
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jComboBox2.setName("jComboBox2"); // NOI18N

        jButton3.setAction(actionMap.get("listpopulate")); // NOI18N
        jButton3.setLabel(resourceMap.getString("jButton3.label")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        jButton4.setAction(actionMap.get("startserver")); // NOI18N
        jButton4.setLabel(resourceMap.getString("jButton4.label")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N

        jButton2.setAction(actionMap.get("Receive")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(135, 135, 135))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        jMenuItem2.setAction(actionMap.get("Send")); // NOI18N
        jMenuItem2.setText(resourceMap.getString("sendmenu.text")); // NOI18N
        jMenuItem2.setName("sendmenu"); // NOI18N
        fileMenu.add(jMenuItem2);

        jMenuItem3.setAction(actionMap.get("Receive")); // NOI18N
        jMenuItem3.setText(resourceMap.getString("receivemenu.text")); // NOI18N
        jMenuItem3.setName("receivemenu"); // NOI18N
        fileMenu.add(jMenuItem3);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        jMenu2.setLabel(resourceMap.getString("jMenu2.label")); // NOI18N
        jMenu2.setName(""); // NOI18N

        jMenuItem6.setAction(actionMap.get("Register")); // NOI18N
        jMenuItem6.setLabel(resourceMap.getString("jMenuItem6.label")); // NOI18N
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAction(actionMap.get("enrcolorcode")); // NOI18N
        jMenuItem7.setLabel(resourceMap.getString("jMenuItem7.label")); // NOI18N
        jMenuItem7.setName("jMenuItem7"); // NOI18N
        jMenu2.add(jMenuItem7);

        menuBar.add(jMenu2);

        statusPanel.setName("statusPanel"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(statusMessageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(statusAnimationLabel))
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane1.setName("jLayeredPane1"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setName("jComboBox1"); // NOI18N

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents


int[] enkey=g.keygen(9);
int[] colorint=g.keygen(255);

Hashtable h1=new Hashtable();
@Action
public void listpopulate()
 { 
     h1=gethashtable();
     String key;
     
      Enumeration e;
      e=h1.keys();
      System.out.println("refresh button clicked current size of h1-->"+h1.size());
      
      jComboBox2.removeAll();
      
      while(e.hasMoreElements())
            {
                key=(String)e.nextElement();
                jComboBox2.addItem(key);
                System.out.println("key-->"+key+" its hash value--->"+h1.get(key));
               
            }         
 }

 

@Action
public void startserver()
{
    System.out.println("Staart Server called... ");
    
}
Hashtable h=new Hashtable();
String ht;
@Action
public Hashtable gethashtable()
 {
     String ts="3";
System.out.println("choice send-->"+ts);
 System.out.println("befrore calling rgclient");
 regclient rg=new regclient(ts);
      System.out.println("After calling rgclient");
 rg.start();
 System.out.println("before while"+rg.runn);
 rg.runn=true;
 while(rg.runn){
     System.out.println("In while");
                 try {
      System.out.println("waiting for client ");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DocView3View.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      }
 
 ht=rg.hashstring;
 
 
 System.out.println("hashstring received "+ht);
 String[] pair=ht.split(":");
 System.out.println("entries of hashtable");
 for(int d=0; d<pair.length && pair[d]!=""; d++)
     {
         System.out.println(""+pair[d]);
         String[] temp=pair[d].split(",");
         String temp1=temp[1]+","+temp[2]+","+temp[3];
         h.put(temp[0], temp1);
          System.out.println("key-->"+temp[0]+"-->"+h.get(temp[0]));
     }
 
     
 return h;
 
 }

 int[] encolor=new int[3];
       @Action
public int[] enrcolorcode() 
{
   
    for(int k=0; k<3; k++)
      {
          encolor[k]=enkey[k]+colorint[k];
      }
         
    String temp;
    temp="2";
    temp=temp+","+key;
    for(int k=0; k<3; k++) {temp=temp+","+encolor[k]; }
     System.out.println("befrore sending colorcode choice");
    regclient rg=new regclient(temp);
    System.out.println("after sending colorcode choice");
 rg.start();
    
    return encolor;
}

          int[] dencolor=new int[3];
public int[] decrpcode(int[] encolorint) 
{
 
    for(int k=0; k<3; k++)
      {
          dencolor[k]=encolorint[k]-enkey[k];
      }
    
    return dencolor;
}

int ch=0;
int key;
@Action
public int Register()
{
 String ts="1";
System.out.println("choice send-->"+ts);
 System.out.println("befrore sending uniquekey choice");
 regclient rg=new regclient(ts);
 System.out.println("After sending uniquekey choice");
 rg.start();
 System.out.println("before while: "+rg.runn);
 rg.runn=true;
 while(rg.runn){
     System.out.println("In while");
                 try {
      System.out.println("waiting for client ");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(DocView3View.class.getName()).log(Level.SEVERE, null, ex);
            }
 }
key=rg.unikey;
System.out.println("Return value from start mweethod->"+key);
 return key;
    
}



    @Action
    public Task Send() throws IOException
    {
        
        int index=jComboBox2.getSelectedIndex();
        String keyts=jComboBox2.getItemAt(index).toString();
       String colorcode=h1.get(keyts).toString();
       System.out.println("key selected to index and send"+index+"-->"+keyts);
     
         Task task=null;

        String S=jTextArea1.getText();
        System.out.println(S);

int n=S.length(); int [] asc=new int[n];
for (int i=0; i<n;i++)
 { asc[i]=(int)S.charAt(i); System.out.println("ASCII value of: "+S.charAt(i) + " is:"+ (int)S.charAt(i) );}

int[] ams={1,5,3,1,25,9,1,125,27};

int[] add=new int[n]; int j=0;
for(int i=0;i<n;i++){ add[i]=asc[i]+ams[j]; if(ams[j]==27) {j=-1;} j=j+1;  }


System.out.println("Enter the elements of Encoding matrix");
 int c,d; int[][] enc=new int[3][3]; int i=0;
      for ( c = 0 ; c < 3 ; c++ )
        {  for ( d = 0 ; d < 3 ; d++ )  { enc[c][d] = ams[i]; i++;}   }
 
  System.out.println("Enter the elements of addition matrix");

  int p,q; int m=n/3; if(n%3!=0) {m=m+1;}
  System.out.println(m);
  int z=0;  int[][]addmat= new int[3][m];
         for ( c = 0 ; c < m ; c++ )
          { for ( d = 0 ; d < 3 ; d++ ){ if(z>=n){addmat[d][c]=0;}
                                  else { addmat[d][c] = add[z];}
                                         z++;
                                       }
         }

  
  System.out.println("Multiplication of two matrix");
  int multiply[][] = new int[3][m]; int sum=0;int x=3*m;          // length of array  e.g 3*4=12   12-1=11
  int[] encodearr=new int[x];  // e.g size 11 so no of elements 12 in array
  int k; i=0;
  for ( c = 0 ; c < 3 ; c++ )
         { for ( d = 0 ; d < m ; d++ )  {  for ( k = 0 ; k < 3 ; k++ )
                                           {    sum = sum + enc[c][k]*addmat[k][d]; }
                                                encodearr[i]=sum; i++;  // store the
                                                multiply[c][d] = sum;
                                                  sum = 0;
                                         }
         }




System.out.print("Final encoded array \t");
String ms="";
for(i=0;i<encodearr.length;i++)  
{

        System.out.print(encodearr[i]+"\t");
        ms += encodearr[i]+" ";

}

ms=colorcode+":"+ms;

System.out.println("\nmessage befrore sending->"+ms);
Steganography.hide(ms, "images\\bigcat.png");
sendFile = Steganography.outputFile;

send = true;
startTransmission();
              return task;
    }

    @Action
    public Task Receive() throws UnknownHostException, IOException
     {
   
     
     int filesize=1022386;
        int bytesRead;
        int currentTot = 0;
        Task task=null;
   
receivedFile = "images\\recv.png";
receive = true;


received = false;
new Thread(new Runnable(){

    public void run(){
                received = false;
                InputStream ris = null;
                Socket socket = null;
                try {
                    socket = new Socket(senderIP,transmitPort);
                    System.out.println("client side Socket intitalised " );
                    int filesize = 1024*1024;
                    int bytesRead;
                    int currentTot = 0;
                    byte [] bytearray  = new byte [filesize];
                    ris = socket.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(ris);
                    DataInputStream dis = new DataInputStream(bis);
                    while (!receive) {
                        Thread.sleep(1000);
                    }
                    FileOutputStream fos = new FileOutputStream(receivedFile);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    bytesRead = ris.read(bytearray, 0, bytearray.length);
                    currentTot = bytesRead;
                    do {
                        System.out.println("File receiving "+currentTot);
                        bytesRead = ris.read(bytearray, currentTot, bytearray.length - currentTot);
                        if (bytesRead >= 0) {
                            currentTot += bytesRead;
                        }
                    } while (bytesRead > -1);
                    bos.write(bytearray, 0, currentTot);
                    bos.flush();
                    bos.close();
                    socket.close();
                    System.out.println("File received."+currentTot);
                    received = true;
                } catch (Exception ex) {
                    Logger.getLogger(DocView3View.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    receive = false;
                    try {
                        if(ris!=null) ris.close();
                        if(socket!=null) socket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(DocView3View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }
}).start();

try {
    while(!received)
    Thread.sleep(1000);
} catch (InterruptedException ex) {
    Logger.getLogger(DocView3View.class.getName()).log(Level.SEVERE, null, ex);
}
String revealFile = receivedFile.substring(0, receivedFile.lastIndexOf("."));
String msg = Steganography.reveal(revealFile);
System.out.println("original coded msg before spliting"+msg);

String[] tempp=msg.split(":");
msg=tempp[1];
System.out.println("code"+tempp[0]);
System.out.println("msg after spliting"+tempp[1]);
String[] code=tempp[0].split(",");
int[] encodecode=new int[3];
for(int p=0; p<3; p++){ encodecode[p]=Integer.parseInt(code[p]);}
int [] color=decrpcode(encodecode);
System.out.println("My color code original "+colorint[0]+" "+colorint[1]+" "+colorint[2]);

System.out.println("My color code obtained after decoding and splitting msg "+color[0]+" "+color[1]+" "+color[2]);
// if(color[0]==colorint[0] && color[1]==colorint[1] && color[2]==colorint[2]){
if(true){
System.out.println("Message is "+msg);


int[] dec={-450,240,-30,-18,24,-6,100,-120,20};
String[] temp=msg.split(" ");
int[] array = new int[temp.length];
int length = array.length;
for(int i=0;i<array.length;i++)
    array[i]=Integer.parseInt(temp[i]);
System.out.println("decarray "+length);
for(int i=0;i<length;i++){ System.out.println(array[i]); //System.out.println(((float)dec[i]/-240));
}
System.out.println("Enter the elements of Decoding matrix");
 int c,d;
 float[][] invm=new float[3][3];
 int i=0;
      for ( c = 0 ; c < 3 ; c++ ) { for ( d = 0 ; d < 3 ; d++ )  { invm[c][d] =(((float)dec[i]/-240));i++; } }


int h=length/3; if(length%3!=0) {h=h+1;}
System.out.println("Enter the elements of Received Encoded matrix");
int z=0;
  int[][] renc= new int[3][h];
         for ( c = 0 ; c < 3 ; c++ )
          { for ( d = 0 ; d < h ; d++ ) {if(z>=length){renc[c][d]=0;}else { renc[c][d] = array[z];} z++;  } }




    System.out.println("Multiplication of two matrix");
  int demultiply[][] = new int [3][h]; float sum=0; int x=3*h;          // length of array  e.g 3*4=12   12-1=11
  int [] decodearr=new int [x];  // e.g size 11 so no of elements 12 in array
  int k; i=0;
  for ( c = 0 ; c < 3 ; c++ ){for ( d = 0 ; d < h ; d++ ){for ( k = 0 ; k < 3 ; k++ ){sum = sum + invm[c][k]*  renc[k][d]; }
               //decodearr[i]=(int)sum; i++;  // store the
               demultiply[c][d] =(int) sum;  sum = 0;    }
                             }




i=0; System.out.print("Array length"+x); System.out.print(decodearr.length); System.out.print("Array entry \t");
for ( c = 0 ; c < h ; c++ ){ for ( d = 0 ; d < 3 ; d++ ) { System.out.print(demultiply[d][c] + "\t");
             decodearr[i]=demultiply[d][c]; i++;  // store matrix in array format
                                                         }
    System.out.print("\n");  }


int[] ams={1,5,3,1,25,9,1,125,27};
int[] sub=new int[decodearr.length];
int j=0;
for(i=0;i<decodearr.length;i++){ sub[i]=decodearr[i]-ams[j];
                      if(ams[j]==27) {j=-1;} j=j+1;
                      if(decodearr[i]==0){sub[i]=32;}
                               }

System.out.print("Substraction array\n");
String ds="";
for(i=0;i<length;i++)  
{
    System.out.print(sub[i]+"\t");
    System.out.print((char)sub[i]+"\n");
    char g=(char)sub[i];
    ds+=Character.toString(g);
}

jTextArea1.setText(ds);
        
        
        
        
        
     }
else
   {
       String ds="You Are Not Authentcated to view message.";
    jTextArea1.setText(ds);
   }

return task;
    }



    @Action
     public Task open() {
        JFileChooser fc = createFileChooser("openFileChooser");
        int option = fc.showOpenDialog(getFrame());
        Task task = null;
        if (JFileChooser.APPROVE_OPTION == option) {
            task = new LoadFileTask(fc.getSelectedFile());
        
        }
        return task;
    }


  private class LoadFileTask extends DocView3App.LoadTextFileTask {

        LoadFileTask(File file) {
            super(DocView3View.this.getApplication(), file);
        }

        @Override 
        protected void succeeded(String fileContents) {

            
            setFile(getFile());
            jTextArea1.setText(fileContents);
            setModified(true);
        }



        @Override
        protected void failed(Throwable e) {
            logger.log(Level.WARNING, "couldn't load " + getFile(), e);
            String msg = getResourceMap().getString("loadFailedMessage", getFile());
            String title = getResourceMap().getString("loadFailedTitle");
            int type = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(getFrame(), msg, title, type);
        }

    }

    private JFileChooser createFileChooser(String name) {
        JFileChooser fc = new JFileChooser();
        return fc;
    }

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    private static final Logger logger = Logger.getLogger(DocView3View.class.getName());
}
