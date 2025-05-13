
package fun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Client_Cal {
    
    BufferedReader br;
    ServerSocket server;
    Socket socket;
    PrintWriter out;
    
    
    public Client_Cal()
    {
        try{
             socket = new Socket("127.0.0.1", 2222);
            System.out.println("Client is running");
           
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            startReading();
            startWriting();
            
            
        }catch(Exception e)
        {
            
        }
        
    }
    
    void startReading()
    {
        Runnable r1 = ()->{
          
           try{
               System.out.println("Enter any two digit to get summation (6 sum 3 ) : ");
               
               while(true)
               {
               String msg = br.readLine();
                   System.out.println("Server : "+msg);
                 
                   
               }
               
               
               
           } catch(Exception e)
           {
               
               
           }
            
            
        };
        new Thread(r1).start();
    }
    
    
    void startWriting()
    {
        Runnable r2 = ()->
        {
            
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while(true)
            {
                try{
                    String msg = input.readLine();
                    out.println(msg);
                    out.flush();
                    
                }catch(Exception e)
                {
                    
                }
            }
            
        };
        new Thread(r2).start();
        
    }
  
    
    public static void main(String[] args) {
        new Client_Cal();
    }
    
    
    
}
