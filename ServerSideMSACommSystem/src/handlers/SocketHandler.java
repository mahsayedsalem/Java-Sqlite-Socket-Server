/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package handlers;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import objects.AcceptedReservationsObject;
import objects.AdminObject;
import objects.AllRoomsObject;
import objects.ConnectionResultObject;
import objects.DBDataObject;
import objects.LoginDataObject;
import objects.ReservationObject;
import objects.RoomObject;

/**
 *
 * @author Mahmoud S. Ahmed
 */
public class SocketHandler {
    
    public void loginconnection(ObjectInputStream ois, ObjectOutputStream outToAdmin) throws IOException, ClassNotFoundException {
        DBHandler dbhandler = new DBHandler();
        AdminObject adminobjectdata = new AdminObject();
        ConnectionResultObject cro = new ConnectionResultObject("Login Result");
        outToAdmin.writeObject(cro);
        adminobjectdata = (AdminObject) ois.readObject();
        LoginDataObject ldo = new LoginDataObject();
        
        String cr;
        int connectionresult = 0;
        
        connectionresult = dbhandler.login(adminobjectdata.getUserName(), adminobjectdata.getPassword());
        
        if (connectionresult == 1) {
            ldo.setLoginResult("true");
        } else {
            ldo.setLoginResult("false");
        }
        
        outToAdmin.writeObject(ldo);
        outToAdmin.flush();
    }
    
    public void dashboardconnection(ObjectInputStream ois, ObjectOutputStream outToAdmin) throws IOException, ClassNotFoundException {
        DBHandler dbhandler = new DBHandler();
        ConnectionResultObject cro = new ConnectionResultObject("Dashboard Result");
        outToAdmin.writeObject(cro);
        ArrayList<RoomObject> roomarray;
        roomarray = new ArrayList<>();
        roomarray = dbhandler.UpDataAvail();
        
        int totalrooms = 0, totalhalls = 0, totallabs = 0, reservedhalls = 0, reservedlabs = 0;
        String stotalrooms, stotalhalls, stotallabs, sreservedhalls, sreservedlabs;
        
        for (int i = 0; i < roomarray.size(); i++) {
            totalrooms++;
            if (roomarray.get(i).getRoomType() == 1) {
                totallabs++;
                if (roomarray.get(i).getAvail() == 1) {
                    reservedlabs++;
                }
            } else {
                totalhalls++;
                if (roomarray.get(i).getAvail() == 1) {
                    reservedhalls++;
                }
            }            
        }
        
        stotalrooms = Integer.toString(totalrooms);
        stotalhalls = Integer.toString(totalhalls);
        stotallabs = Integer.toString(totallabs);
        sreservedhalls = Integer.toString(reservedhalls);
        sreservedlabs = Integer.toString(reservedlabs);
        DBDataObject dbdo = new DBDataObject(stotalrooms, stotalhalls, stotallabs, sreservedhalls, sreservedlabs);
        outToAdmin.writeObject(dbdo);
        outToAdmin.flush();
    }
    
    public void acceptedreservationsconnection(ObjectInputStream ois, ObjectOutputStream outToAdmin) throws IOException, ClassNotFoundException {
 
        DBHandler db = new DBHandler ();
        ArrayList<ReservationObject> ro = new ArrayList<>();
        ro = db.FromDataBaseRestoArray();
        AcceptedReservationsObject aro = new AcceptedReservationsObject();
        aro.setro(ro);
        ConnectionResultObject cro = new ConnectionResultObject("AcceptedReservations Result");
        outToAdmin.writeObject(cro);
        outToAdmin.writeObject(aro); 
    }
    
    public void allroomconnection(ObjectInputStream ois, ObjectOutputStream outToAdmin) throws IOException, ClassNotFoundException {
 
        DBHandler db = new DBHandler ();
        ArrayList<RoomObject> ro = new ArrayList<>();
        ro = db.FromDataBaseRotoArray();
        AllRoomsObject aro = new AllRoomsObject();
        aro.setro(ro);
        ConnectionResultObject cro = new ConnectionResultObject("AllRooms Result");
        outToAdmin.writeObject(cro);
        outToAdmin.writeObject(aro); 
    }
    
    public void addroomconnection(ObjectInputStream ois, ObjectOutputStream outToAdmin) throws IOException, ClassNotFoundException {
        DBHandler db = new DBHandler ();
        ConnectionResultObject cro = new ConnectionResultObject("AddRooms Result");
        outToAdmin.writeObject(cro);
        RoomObject ro = new RoomObject();
        ro = (RoomObject) ois.readObject();
        db.insert(ro.getRoomID(), ro.getRoomType(), ro.getCapacity(), ro.getAvail());
    }
    
    public void editroomconnection(ObjectInputStream ois, ObjectOutputStream outToAdmin) throws IOException, ClassNotFoundException {
        DBHandler db = new DBHandler ();
        ConnectionResultObject cro = new ConnectionResultObject("EditRooms Result");
        outToAdmin.writeObject(cro);
        RoomObject ro = new RoomObject();
        ro = (RoomObject) ois.readObject();
        db.update(ro.getRoomID(), ro.getRoomType(), ro.getCapacity(), ro.getAvail());
    }
    
    public void deleteroomconnection(ObjectInputStream ois, ObjectOutputStream outToAdmin) throws IOException, ClassNotFoundException {
        DBHandler db = new DBHandler ();
        ConnectionResultObject cro = new ConnectionResultObject("DeleteRooms Result");
        outToAdmin.writeObject(cro);
        RoomObject ro = new RoomObject();
        ro = (RoomObject) ois.readObject();
        db.delete(ro.getRoomID());
    } 
    
    public void androidlogincheck(ObjectInputStream ois, ObjectOutputStream outToAdmin) throws IOException, ClassNotFoundException {
        DBHandler db = new DBHandler ();
        //ConnectionResultObject cro = new ConnectionResultObject("AndroidLoginCheck Result");
        String type = "AndroidLoginCheck Result";
        outToAdmin.writeObject(type);   
    } 
}
