
package groupchat;



import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;
    private static List<ClientHandler> clientList = new ArrayList<>();

    public ClientHandler(Socket socket) {
        try {
            this.clientSocket = socket;
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.output = new PrintWriter(socket.getOutputStream(), true);
            clientList.add(this);
        } catch (IOException e) {
            System.out.println("Error setting up client handler: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = input.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    disconnectClient();
                    break;
                }
                broadcastMessage(message);
            }
        } catch (IOException e) {
            System.out.println("Client disconnected.");
        }
    }

    private void broadcastMessage(String message) {
        for (ClientHandler client : clientList) {
            if (client != this) {
                client.output.println("User: " + message);
            }
        }
    }

    private void disconnectClient() {
        try {
            clientList.remove(this);
            clientSocket.close();
            System.out.println("A client has left the chat.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
