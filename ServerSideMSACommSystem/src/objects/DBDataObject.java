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
public class DBDataObject implements Serializable{
    private static final long serialVersionUID = 5L;
    private String totalrooms, totalhalls, totallabs, reservedhalls, reservedlabs;
    
    
    public DBDataObject()
    {
    
    }
    
    public DBDataObject(String totalrooms, String totalhalls, String totallabs, String reservedhalls, String reservedlabs)
    {
        this.totalrooms=totalrooms;
        this.totalhalls=totalhalls;
        this.totallabs=totallabs;
        this.reservedhalls=reservedhalls;
        this.reservedlabs=reservedlabs;
    }
    
    public String gettotalrooms()
   {
       return totalrooms;
   }
    
    public String gettotalhalls()
   {
       return totalhalls;
   }
    
    public String gettotallabs()
   {
       return totallabs;
   }
    
    public String getreservedhalls()
   {
       return reservedhalls;
   }
    
    public String getreservedlabs()
   {
       return reservedlabs;
   }
    
    public void settotalrooms(String newtotalrooms)
  {
      totalrooms = newtotalrooms;
  }  
    
    public void settotalhalls(String newtotalhalls)
  {
      totalhalls = newtotalhalls;
  }  
    
    public void settotallabs(String newtotallabs)
  {
      totallabs = newtotallabs;
  }  
    
    public void setreservedhalls(String newreservedhalls)
  {
      reservedhalls = newreservedhalls;
  }  
    
    public void setreservedlabs(String newreservedlabs)
  {
      reservedlabs = newreservedlabs;
  } 
}
