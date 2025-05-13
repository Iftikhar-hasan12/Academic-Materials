
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
                   String [] s = msg.split(" ");
                    int a = Integer.parseInt(s[0]);
                    String op = s[1];
                    int b = Integer.parseInt(s[2]);
                    
                    if(op.equalsIgnoreCase("sum"))
                        
                    {
                        int res = a+b;
                        out.println(res);
                        out.flush();
                    }
                   
                   
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
