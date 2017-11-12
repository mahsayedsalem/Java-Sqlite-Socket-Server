/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Mahmoud S. Ahmed
 */
public class AllRoomsObject implements Serializable {
    
    private static final long serialVersionUID = 56L;
    ArrayList<RoomObject> ro = new ArrayList<>();
    
    
    
    public AllRoomsObject()
    {
        
    }
    
    public ArrayList<RoomObject> getro()
    {  
        return ro;
    }
    
    public void setro(ArrayList<RoomObject> newro)
  {
      ro = newro;
  }
}
