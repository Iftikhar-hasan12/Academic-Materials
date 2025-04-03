
package groupchat;



import java.io.IOException;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
int k=1;
    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Chat Server started on port " + port);

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("client-"+k+" connected.");
                k++;
                ClientHandler clientHandler = new ClientHandler(client);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            System.out.println("Server encountered an issue: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Server(9999);
    }
}
