package worker;

import java.io.IOException;

public class Worker1 {

    public static void main(String[] args) throws IOException {
        
        /* Set connection with master */
        Connection connectionToServer = new Connection();
        
        if ( connectionToServer.getStatus().equals("ok") ) {
            
            System.out.println( connectionToServer.getMessage() );
            
            while ( true ) {
                // wait for request
                if ( true /* special command from master */ ){
                    break;
                }
                // give answer
            }
        }
        
        connectionToServer.close();
    } 
}
