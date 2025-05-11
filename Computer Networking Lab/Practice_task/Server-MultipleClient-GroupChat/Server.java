package fun;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiClientChatServer {
    ServerSocket serverSocket;
    List<ClientHandler> clients = new ArrayList<>();

    public MultiClientChatServer() {
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                ClientHandler handler = new ClientHandler(clientSocket, this);
                clients.add(handler);
                new Thread(handler).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void broadcast(String message, ClientHandler sender) {
        for (ClientHandler ch : clients) {
            if (ch != sender) {
                ch.sendMessage(message);
            }
        }
    }

    public synchronized void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        new MultiClientChatServer();
    }
}
