package docview3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;

public class regserver extends Thread
{

    globalserver g=new globalserver();
    public static final int EOS=65535;
    public static final int EOR=-1;
    public static void main(String args[])
      {
          regserver rg=new regserver();
          rg.start();
          
      }
            public void run() { 
            
            System.out.println("in servercode of regserver");
             int PORT = 56565; 
            
ServerSocket server = null;
Socket sock = null;

BufferedReader input = null;
BufferedWriter output = null; 



try {

server = new ServerSocket(PORT);


while(true)

{
sock = server.accept();
System.out.println("server.accept()"+sock);

/*input =new BufferedReader(new InputStreamReader(sock.getInputStream()));
output = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
DataInputStream in = new DataInputStream(sock.getInputStream());
// System.out.println("Read Data: "+in.readUTF());
char[] cbuff=new char[1];
System.out.println("Waiting for input in server");
StringBuilder sb=new StringBuilder( );
int c;
// System.out.println(input.readLine());
while((c=input.read())!=-1)
{ System.out.println("input recv "+c);
    sb.append((char)c);
}
*/
DataInputStream in = new DataInputStream(sock.getInputStream());

String fromclient=in.readUTF();
System.out.println("input recv from client "+fromclient);
String[] fc=fromclient.split(",");


int ch=Integer.parseInt(fc[0]);
DataOutputStream out =  new DataOutputStream(sock.getOutputStream());



if(ch==1)
{
         System.out.println("choice one accepted");
    int key=g.unikey();
    System.out.println("unique key generated -->"+key);
    // output.write(key);
    // output.write(EOR);
   // out.writeUTF(key+""+EOR);
    out.writeUTF(key+"");
}

if(ch==2)
 {
     System.out.println("choice two accepted");
     System.out.println("all parameters from client for choice 2--> "+fc);
     int key=Integer.parseInt(fc[1]);
     int[] code= new int[3];
     for(int k=0; k<3; k++){code[k]=Integer.parseInt(fc[2+k]); System.out.println(code[k]); }
     
     StringBuilder sn=new StringBuilder();
     for(int h=0; h<3; h++)
     {
         sn.append(code[h]);
     }
        System.out.println("in server before making entry-->"+key+" "+code[0]+" "+code[1]+" "+code[2]);
     
     g.codeaccept(key, code);
     
     
 }
String ke,cod="";
String temp="";
if(ch==3)
{
    System.out.println("choice three accepted");
    Enumeration  e;
    e=g.log.keys();
    System.out.println("size of log"+g.log.size());
    while(e.hasMoreElements())
          {
              Object obj=e.nextElement(); 
              ke=obj.toString();
              
               System.out.println("key is"+ke);
              int[] cod1=(int[])g.log.get(obj);
              
              System.out.println("Brfore sending the data code1==>"+cod1[0]+" "+cod1[1]+" "+cod1[2]);
              cod = "";
              for(int j=0; j<cod1.length; j++)
              { 
                  cod+=cod1[j];
                  if(cod1.length-1>j)cod+=",";
                  System.out.println("cod-->"+cod);
              }
                  System.out.println("temp-->"+temp);
              temp=temp+ke+","+cod+":";
          }
    System.out.println("final -->temp-->"+temp);
    // output.write(temp);
   // output.write(EOR);
    out.writeUTF(temp);
}

//output.newLine();
//output.flush(); 
//output.close();
try {
if (sock != null) {
sock.close();
}
} catch (final IOException ex) {   ex.printStackTrace();
}
}
} catch (final IOException ex) {
            ex.printStackTrace();
}finally {


try {
if (server != null) {
server.close();
}
} catch (final IOException ex) {    ex.printStackTrace();
}
}
    }
}
