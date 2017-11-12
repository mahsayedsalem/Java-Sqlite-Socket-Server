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
public class ReservationObject implements Serializable{
    private int Req_ID;
    private String RoomID;
    private String Time;
    private String Date;
    private String User;
    private String Duration;
    private static final long serialVersionUID = 45L;
    
    public ReservationObject(int Req_ID, String RoomID, String Date, String Time, String Duration, String User)
    {
        this.Req_ID=Req_ID;
        this.RoomID=RoomID;
        this.Time=Time;
        this.Date = Date;
        this.Duration=Duration;
        this.User=User;
    }
    
    public ReservationObject()
    {}
    
    
    public int getReq_ID()
    {
        return Req_ID;
    }
    
    public String getDate()
    {
        return Date;
    }
    
    public String getUser()
    {
        return User;
    }
    
    public String getRoomID()
    {
        return RoomID;
    }
    
    public String getTime()
    {
        return Time;
    }
    
    public String getDuration()
    {
        return Duration;
    }
    
    public void setReq_ID(int newReqID)
    {
        Req_ID = newReqID;
    }
    
    public void setRoomID(String newRoomID)
    {
        RoomID = newRoomID;
    }
    
    public void setTime(String newTime)
    {
        Time = newTime;
    }
    
    public void setDate(String newDate)
    {
        Date = newDate;
    }
    
    public void setUser(String newUser)
    {
        User = newUser;
    }
    
    public void setDuration(String newDuration)
    {
        Duration = newDuration;
    }
}
