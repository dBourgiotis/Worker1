package worker1;

import java.io.IOException;

public class Worker1 {

    public static void main(String[] args) throws IOException {
        //set connection with master
        Connection connectionToServer = new Connection();
        while ( true ) {
            // wait for request
            if ( true /* special command from master */ ){
                break;
            }
            // give answer
        }
        connectionToServer.close();
    } 
}
