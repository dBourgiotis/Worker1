package worker1;

import java.io.IOException;
import java.net.Socket;

public class Connection {

    final String ip = "127.0.0.1"; // ip of master
    final int port = 8000;         // port number of master
    Socket connectionToServer = new Socket( ip, port);
    
    Connection() throws IOException {
        
            System.out.println("Connection Established!");
            System.out.println(">>  IP: " + connectionToServer.getInetAddress().getHostName() );
            System.out.println(">>Port: " + connectionToServer.getPort());

    }
    
    public void close() {
        try {
            connectionToServer.close();
        } catch (Exception close) {}
    }  
} // class Connection
