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
public class NumberOfAcceptedReservations implements Serializable {
    
    private static final long serialVersionUID = 10L;
    private int count;
    
    
    
    public NumberOfAcceptedReservations()
    {
        
    }
    
    public int getcount()
    {  
        return count;
    }
    
    public void setcount(int newcount)
  {
    count = newcount;   
  }
}
