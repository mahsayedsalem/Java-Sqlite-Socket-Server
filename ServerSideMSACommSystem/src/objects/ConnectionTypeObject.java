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
public class ConnectionTypeObject implements Serializable{
    private static final long serialVersionUID = 2L;
    String connectionType;
    
    public ConnectionTypeObject()
    {
    }
    
    public ConnectionTypeObject(String connectionType)
    {
        this.connectionType = connectionType;
    }
    
    public String getconnectionType()
   {
       return connectionType;
   }
    
    public void setconnectionType(String newconnectionType)
  {
      connectionType = newconnectionType;
  }
    
}
