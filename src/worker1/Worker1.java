package worker1;

import java.io.IOException;

public class Worker1 {

    public static void main(String[] args) throws IOException {
        
        /* Set connection with master */
        Connection connectionToServer = new Connection();
       // for (int i=0; i<10000; i++) {}
        System.out.println( connectionToServer.getMessage() );

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
