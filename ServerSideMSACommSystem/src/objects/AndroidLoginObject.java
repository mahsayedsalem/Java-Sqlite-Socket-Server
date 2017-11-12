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
public class AndroidLoginObject implements Serializable {

    private String UserName;
    private String Password;
    private static final long serialVersionUID = 87L;

    public AndroidLoginObject ()
    {}

    public AndroidLoginObject(String UserName, String Password)
    {
        this.UserName = UserName;
        this.Password = Password;
    }

    public String getUserName()
    {
        return UserName;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setUserName(String newUserName)
    {
        UserName = newUserName;
    }

    public void setPassword(String newPassword)
    {
        Password = newPassword;
    }

}
