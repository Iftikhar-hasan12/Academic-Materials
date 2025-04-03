**Server**
The Server.java file is responsible for managing client connections and facilitating message broadcasting in the multi-client chat system. It listens for incoming client requests on a specified port (9999) and assigns each new connection to a dedicated thread using the ClientHandler class. The server ensures that messages sent by one client are broadcasted to all connected clients, enabling real-time group chat. To use this, first, run the Server.java file, which will initialize the server and keep it running, waiting for clients to join. This file plays a crucial role in handling multiple users simultaneously, making the chat system functional and scalable.

**ClientHandler**
The ClientHandler.java file is a core component of the chat system that manages communication between the server and individual clients. Whenever a new client connects, a separate instance of ClientHandler is created, allowing multiple clients to send and receive messages independently. This file ensures that messages received from a client are distributed to all other connected clients. It also monitors client disconnections and removes inactive clients to maintain a smooth chat experience. Since the application is multi-threaded, each client runs in a separate thread, allowing seamless communication without interference.

**Client**
The Client.java file is responsible for establishing a connection with the server and enabling users to send and receive messages in real time. Once the client connects to the server, it continuously listens for incoming messages while also allowing users to type and send their messages to the chat. To use this file, first ensure the Server.java is running, then execute Client.java multiple times to simulate multiple users in the chat room. The program provides a simple way to exchange messages, and users can type "exit" to leave the chat. The client application utilizes Java sockets and multi-threading to facilitate real-time communication across different users.








