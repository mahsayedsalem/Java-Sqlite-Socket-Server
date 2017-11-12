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
public class LoginDataObject implements Serializable{
    private static final long serialVersionUID = 4L;
    private String LoginResult;
    
    
    public LoginDataObject()
    {
    
    }
    
    public LoginDataObject(String LoginResult)
    {
        this.LoginResult = LoginResult;
    }
    
    public String getconnectionResult()
   {
       return LoginResult;
   }
    
    public void setLoginResult(String newLoginResult)
  {
      LoginResult = newLoginResult;
  }  
}
