package groupchat;

import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private BufferedReader inputReader;
    private PrintWriter outputWriter;
    private BufferedReader serverReader; 

    public Client(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            System.out.println("Client got Connection");
            inputReader = new BufferedReader(new InputStreamReader(System.in));
            outputWriter = new PrintWriter(socket.getOutputStream(), true);
            serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 

            
            new Thread(() -> {
                try {
                    String message;
                    while ((message = serverReader.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            }).start();

          
            new Thread(() -> {
                try {
                    String message;
                    while ((message = inputReader.readLine()) != null) {
                        outputWriter.println(message);
                        if (message.equalsIgnoreCase("exit")) {
                            socket.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error sending message.");
                }
            }).start();

        } catch (IOException e) {
            System.out.println("Unable to connect to server.");
        }
    }

    public static void main(String[] args) {
        new Client("127.0.0.1", 9999);
    }
}
