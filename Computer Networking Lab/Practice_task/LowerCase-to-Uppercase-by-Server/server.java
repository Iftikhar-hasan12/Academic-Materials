
package fun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server_Cal {
    
    BufferedReader br;
    ServerSocket server;
    Socket socket;
    PrintWriter out;
    
    
    public Server_Cal()
    {
        try{
            server = new ServerSocket(2222);
            System.out.println("Server is running");
            socket = server.accept();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            startReading();
            
            
        }catch(Exception e)
        {
            
        }
        
    }
    
    void startReading()
    {
        Runnable r1 = ()->{
          
           try{
               
               while(true)
               {
                   String msg = br.readLine();
                   String upmsg = msg.toUpperCase();
                   out.println(upmsg);
                   out.flush();
                   
                   
               }
               
               
               
           } catch(Exception e)
           {
               
               
           }
            
            
        };
        new Thread(r1).start();
    }
    public static void main(String[] args) {
        new Server_Cal();
    }
    
    
    
}
