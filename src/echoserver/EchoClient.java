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

  
