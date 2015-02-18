package worker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {

    private final String ip = "127.0.0.1"; // ip of master
    private final int port = 8080;         // port number of master
    private static Socket connectionToServer = null; 
    private static String ServerIP;
    private static int ServerPort;
    private String status = "Incomplete";
    private ObjectInputStream out;
    private ObjectOutputStream output;
    
    Connection() throws IOException {
        
        connectionToServer = new Socket( ip, port);
        
        try { /* Get Server's Info */
            ServerIP = connectionToServer.getInetAddress().getHostName() ;
            ServerPort = connectionToServer.getPort();
        } catch ( Exception si) {
            System.err.println("Couldn't get server's info!");
        }
        
        try { /* Redirect streams */
            out = new ObjectInputStream( connectionToServer.getInputStream() );
            output = new ObjectOutputStream( connectionToServer.getOutputStream());
        } catch ( Exception streams) {
            
        }
        /* Print Info */
        System.out.println("Connection Established!");
        System.out.println(">>  IP: " + ServerIP );
        System.out.println(">>Port: " + ServerPort );
        
        status = "ok";
    }
    
    public String getMessage() {
        
        String message="lol";
        // Get message
        try {
            message = (String) out.readObject();
        } catch ( Exception m ) {
            System.err.println("Message cannot be read!");
        }
        // Return message
        return message;
    }
    
    public void close() {
        try {
            connectionToServer.close();
        } catch (Exception close) {
            System.err.println("Connection didn't close correctly!");
        }
    }  

    public String getStatus() { return status; }
    
} // class Connection
