
package objects;

import java.io.Serializable;

/**
 *
 * @author Mahmoud S. Ahmed
 */
public class AndroidLoginResult implements Serializable{
    private static final long serialVersionUID = 74L;
    String LoginResult;


    public AndroidLoginResult()
    {

    }

    public AndroidLoginResult(String LoginResult)
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
