package fun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    public Server() {
        try {
            server = new ServerSocket(9999);
            System.out.println("Server is Running ...");
            System.out.println("Waiting for Client..");
            socket = server.accept();
            System.out.println("Server got connection");
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream());
            startReading();
            startWriting();

        } catch (Exception e) {

        }
    }

    public void startReading() {
        Runnable r1 = () -> {

            System.out.println("Reading Started ..");
            while (true) {
                try {
                    String msg = br.readLine();
                    if (msg.equals("OFF")) {
                        System.out.println("System Terminated ");
                        break;
                    }
                    System.out.println("Client : " + msg);

                } catch (Exception e) {

                }

            }

        };
        new Thread(r1).start();
        

    }

    public void startWriting() {
        Runnable r2 = () -> {

            System.out.println("Writing Started..");
            while (true) {
                try {
                    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                    String content = input.readLine();
                    out.println(content);
                    out.flush();
                } catch (Exception e) {

                }
            }

        };
 new Thread(r2).start();
    }

    public static void main(String[] args) {
        new Server();
    }

}
