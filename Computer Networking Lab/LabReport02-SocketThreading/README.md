**Multi-User Chat Application**
**Overview**
This is a group chat application built using socket programming, where multiple users can join the chat by running the client program multiple times. The server manages all client connections and ensures that messages sent by one client are broadcasted to all other connected clients. This project demonstrates real-time communication using sockets and multithreading.

How It Works
The server listens for incoming client connections and manages them using multithreading.

Each client connects to the server and can send and receive messages.

A separate thread handles message reception on the client side to avoid blocking user input.

The server relays messages from one client to all others, creating a real-time chat experience.

Class Structure
Server Class: Manages the server socket, accepts client connections, and broadcasts messages to all connected users.

Client Class: Connects to the server, sends messages, and receives messages in a separate thread.

ClientHandler Class: Runs on the server side to handle communication with each connected client in a separate thread.

This project enhances understanding of socket programming, multithreading, and real-time network communication. It can be further improved to include features like user authentication, message encryption, and a GUI interface.

