package fun;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    MultiClientChatServer server;

    public ClientHandler(Socket socket, MultiClientChatServer server) {
        try {
            this.socket = socket;
            this.server = server;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    @Override
    public void run() {
        try {
            out.println("Welcome to Group Chat! Type OFF to exit.");
            String name = "User" + socket.getPort();
            server.broadcast(name + " joined the chat!", this);

            String msg;
            while ((msg = in.readLine()) != null) {
                if (msg.equalsIgnoreCase("OFF")) {
                    server.broadcast(name + " left the chat.", this);
                    break;
                }
               // System.out.println(name + ": " + msg);
                server.broadcast(name + ": " + msg, this);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
                server.removeClient(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
