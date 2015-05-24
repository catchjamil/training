package docview3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class regclient extends Thread {


//private static final String HOST = "192.168.1.12";
private static final String HOST = "127.0.0.1";
private static final int PORT = 56565;
private static final int EOR = -1;
private static final int EOS = 65535;
public static int unikey;
public static String hashstring;
public static boolean runn=false;
 String ts;
public  regclient(String toserver)
 {
     System.out.println("in constructor");
    ts=toserver;     
 }
 
  


public void run() {
    runn=true;
    String fromserver;

    System.out.println("in run of regclient ");
Socket sock = null;
BufferedReader input = null;
BufferedWriter output = null;
try {
 System.out.println("Connect our socket to the server.");
sock = new Socket(HOST, PORT);

input = new BufferedReader(new InputStreamReader(sock.getInputStream()));

//output = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

 System.out.println("Send some data to the server.");
//output.write(ts+","+EOS);
//output.write(EOS);
//output.flush();
// output.close();
DataOutputStream out = new DataOutputStream(sock.getOutputStream());
out.writeUTF(ts+","+EOS);


System.out.println("value of ts-->"+ts);
String[] t1=ts.split(",");
 ts=t1[0];       
if(Integer.parseInt(ts)==1)
 {
 /*    char[] cbuff=new char[1];
System.out.println("waiting for output from server");
StringBuilder sb=new StringBuilder( );
int c;
while((c=input.read())!=-1)
{ System.out.println("input recv "+c);
    sb.append(c);
}*/
	
	 InputStream inFromServer = sock.getInputStream();
     DataInputStream in = new DataInputStream(inFromServer);
    // System.out.println("Server says " + in.readUTF());
    	
fromserver=in.readUTF();
System.out.println("key recv from server "+fromserver);
     
                       
                       unikey=Integer.parseInt(fromserver);
 }




if(Integer.parseInt(ts)==3)
 {/*
     char[] cbuff=new char[1];
System.out.println("waiting for output from server");
StringBuilder sb=new StringBuilder( );
int c;
while((c=input.read())!=EOS)
{ System.out.println("input recv "+c);
    sb.append((char)c);
}*/
InputStream inFromServer = sock.getInputStream();
DataInputStream in = new DataInputStream(inFromServer);
// System.out.println("Server says " + in.readUTF());
	
fromserver=in.readUTF();


// fromserver=sb.toString();
System.out.println("key recv from server "+fromserver);
     
                       System.out.println("key is in client module-->"+fromserver);
                       hashstring=fromserver;
                       
 }


//output.newLine();
//output.flush();



} catch (final IOException ex) {ex.printStackTrace();
    System.out.println("\nin first catch of regclients");
} 
runn=false;
}

} 