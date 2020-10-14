package echoserver;

import java.net.*;
import java.io.*;

public class EchoClient {
    public static final int portNumber = 6013;
    public static void main(String[] args) throws IOException {
        String server;
        // Use "127.0.0.1", i.e., localhost, if no server is specified.
        if (args.length == 0) {
          server = "127.0.0.1";
        } else {
          server = args[0];
        }
    
    try {
  
    Socket socket = new Socket(server, portNumber); // Connect to the server
   
    // Establish input and output streams into and out of the socket
    OutputStream output = socket.getOutputStream();
    InputStream input = socket.getInputStream();
  

    /* Create variable to store bytes from the System.in stream
    An int is used because we need additional space to represent the end of the stream
    The convention to use an int rather than a short is established by System.in */
    int dataFromInput;

    // Read until the end of file or stream
    while ((dataFromInput = System.in.read()) != -1) {
      output.write((byte) dataFromInput); // Write dataFromInput byte to output stream

      // Read echos and write them to output
      byte incomingByte = (byte) input.read(); // Get byte from stream
      System.out.write(incomingByte);
    }
    
    // Flush streams
    output.flush();
    System.out.flush();

    // Close the socket when we're done reading from it
    socket.close();

    // Close streams
    input.close();
    output.close();

    // Provide some minimal error handling
  } catch (ConnectException ce) {
    System.out.println("We were unable to connect to " + server);
    System.out.println("You should make sure the server is running.");
} catch (IOException ioe) {
    System.out.println("We caught an unexpected exception");
    System.err.println(ioe);
}
}
}