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
public class ConnectionResultObject implements Serializable{
    private static final long serialVersionUID = 3L;
    String connectionResult;
    
    
    public ConnectionResultObject()
    {
    
    }
    
    public ConnectionResultObject(String connectionResult)
    {
        this.connectionResult = connectionResult;
    }
    
    public String getconnectionResult()
   {
       return connectionResult;
   }
    
    public void setconnectionResult(String newconnectionResult)
  {
      connectionResult = newconnectionResult;
  }
    
}
