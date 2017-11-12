/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverpackage;

import handlers.SocketHandler;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import static java.rmi.server.LogStream.log;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.ConnectionTypeObject;

/**
 *
 * @author Mahmoud S. Ahmed
 */
public class ConnectionClass extends Thread {
    private Socket connectionSocket;
    private int clientnumber;
    
    public ConnectionClass (Socket socket, int clientnumber)
    {
        this.connectionSocket = socket;
        this.clientnumber = clientnumber;
        System.out.println("New connection with client# " + clientnumber + " at " + socket);
    }
    
    public void run()
    {
        try {
            ObjectOutputStream outToAdmin = new ObjectOutputStream(connectionSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(connectionSocket.getInputStream());
            SocketHandler sockethandler = new SocketHandler();
            ConnectionTypeObject cto = new ConnectionTypeObject();
            String result = null;
            
            while (true) {
                 
                //cto = (ConnectionTypeObject) ois.readObject();
                
                result = (String) ois.readObject();
                System.out.println(result);
                
                switch (result) {
                    
                    case "The login Data Required":
                        sockethandler.loginconnection(ois, outToAdmin);
                        break;
                    case "The Dashboard Data Required":
                        sockethandler.dashboardconnection(ois, outToAdmin);
                        break;
                    case "The AcceptedReservations Data Required":
                        sockethandler.acceptedreservationsconnection(ois, outToAdmin);
                        break;
                    case "The AllRoom Data Required":
                        sockethandler.addroomconnection(ois, outToAdmin);
                        break;
                    case "The AddRoom Data Required":
                        sockethandler.allroomconnection(ois, outToAdmin);
                        break;
                    case "The DeleteRoom Data Required":
                        sockethandler.deleteroomconnection(ois, outToAdmin);
                        break;
                    case "The EditRoom Data Required":
                        sockethandler.editroomconnection(ois, outToAdmin);
                        break;
                    case "Android Login Check":
                        sockethandler.androidlogincheck(ois, outToAdmin);
                        break;
                    default:
                       System.out.println("something else");
                       break;       
                }
            }   
            
        } catch (IOException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                    connectionSocket.close();
            } catch (IOException ex) {
             Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
