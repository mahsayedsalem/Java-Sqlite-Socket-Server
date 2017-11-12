/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverpackage;


import handlers.SocketHandler;
import java.io.*;
import java.net.*;
import objects.ConnectionTypeObject;

/**
 *
 * @author Mahmoud S. Ahmed
 */
public class ServerMain extends Thread {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    /**
     * Connect to a sample database
     *
     * @param args
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("MSA Communication server is running.");
        ServerSocket welcomeSocket = new ServerSocket(6789);
        int clientNumber = 0;
        try {
	        	while (true) {
                            clientNumber++;
                            new ConnectionClass(welcomeSocket.accept(), clientNumber).start();
	        	}
	        }
	        finally {
	            welcomeSocket.close();
	        }
    }
}

