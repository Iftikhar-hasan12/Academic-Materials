package fun;

import java.io.*;
import java.net.*;

public class MultiClientChatClient {
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public MultiClientChatClient() {
        try {
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("Connected to Chat Server!");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            startReading();
            startWriting();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startReading() {
        Runnable r1 = () -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (Exception e) {
                System.out.println("Connection closed.");
            }
        };
        new Thread(r1).start();
    }

    public void startWriting() {
        Runnable r2 = () -> {
            try {
                BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
                String userInput;
                while ((userInput = consoleInput.readLine()) != null) {
                    out.println(userInput);
                    if (userInput.equalsIgnoreCase("OFF")) {
                        socket.close();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Connection closed.");
            }
        };
        new Thread(r2).start();
    }

    public static void main(String[] args) {
        new MultiClientChatClient();
    }
}
