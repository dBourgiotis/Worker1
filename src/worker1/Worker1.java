package worker1;

import java.io.IOException;
import java.net.Socket;

public class Worker1 {

    public static void main(String[] args) throws IOException {
        
        final String ip = "127.0.0.1";
        final int port = 8000;
        
        try (
            Socket connection = new Socket( ip, port);
        ) {}
    } 
}
