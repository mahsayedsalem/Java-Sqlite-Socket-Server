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
public class AcceptedReservationsObject implements Serializable {
    
    private static final long serialVersionUID = 8L;
    ArrayList<ReservationObject> ro = new ArrayList<>();
    
    
    
    public AcceptedReservationsObject()
    {
        
    }
    
    public ArrayList<ReservationObject> getro()
    {  
        return ro;
    }
    
    public void setro(ArrayList<ReservationObject> newro)
  {
      ro = newro;
  }
}
