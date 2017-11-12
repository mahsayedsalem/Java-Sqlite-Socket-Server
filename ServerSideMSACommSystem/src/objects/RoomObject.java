/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;

/**
 *
 * @author Mahmoud S. Ahmed
 */
public class RoomObject implements Serializable{
   
   private String RoomID;
   private int RoomType;
   private String Capacity;
   private int Avail;
   private static final long serialVersionUID = 54L;

   
   public RoomObject(String RoomID, int RoomType, String Capacity, int Avail)
   {
       this.RoomID = RoomID;
       this.RoomType = RoomType;
       this.Capacity = Capacity;
       this.Avail = Avail;
   }
   
   public RoomObject()
   {}
   public String getRoomID ()
   {
       return RoomID;
   }
   
   public int getRoomType()
   {
       return RoomType;
   }
   
   public String getCapacity()
   {
       return Capacity;      
   }
   
   public int getAvail()
   {
       return Avail;
   }
   
   

  public void setRoomID (String newRoomID)
  {
      RoomID = newRoomID;
  }

   public void setRoomType( int newRoomType) {
      RoomType = newRoomType;
   }

   public void setCapacity(String newCapacity) {
      Capacity = newCapacity;
   }
   
   public void setAvail( int newAvail) {
      Avail = newAvail;
   }

   

}
