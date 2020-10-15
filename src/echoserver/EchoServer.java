package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNumber = 6013;
    public static void main(String[] args) {
        try {

          ServerSocket socket = new ServerSocket(portNumber);


          // Wait until someone connects
          Socket client = socket.accept(); // Connect to client

        
          InputStream input = client.getInputStream(); // Stream from the client

          OutputStream output = client.getOutputStream(); // Stream into the server socket
          

          
        // *Very* minimal error handling.
        } catch (IOException ioe) {
          System.out.println("We caught an unexpected exception");
          System.err.println(ioe);
        }
    }
}
