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
public class CloseTheConnectionObject implements Serializable {
    
    private static final long serialVersionUID = 9L;
    
    private int CTC = 1;
    
    public CloseTheConnectionObject()
    {
        
    }
    
    public int getCTC()
    {
        return CTC;
    }
    
}
