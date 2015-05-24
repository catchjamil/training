package docview3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Random;

public class globalserver {

    public static void main(String args[]) throws IOException 
    {
        globalserver g=new globalserver();
        
    }
    
    
        Hashtable log = new Hashtable();

       
    public int[] keygen(int limit) {
        int[] keyarr = new int[3];
        Random rn = new Random();
        keyarr[0] = rn.nextInt(limit);
        keyarr[1] = rn.nextInt(limit);
        keyarr[2] = rn.nextInt(limit);

        return keyarr;
    }

    public int unikey() 
     {
        int[] code = new int[3];
        code[0] = 0;
        code[1] = 0;
        code[2] = 0;

        int a = 50;
        Random key = new Random();
        int k = key.nextInt(50);

        while (log.containsKey(k) == true) 
        {
            k = unikey();
        }
        log.put(k, code);
        return k;
     }
    

    public void codeaccept(int unikey, int[] code) {
        log.put(unikey, code);
        System.out.println("new log entry generated");
          }



}
