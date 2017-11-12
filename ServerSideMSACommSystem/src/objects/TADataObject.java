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
public class TADataObject implements Serializable {

    private static final long serialVersionUID = 100L;
    private String TA_ID;
    private String TA_Name;
    private String TA_Image;

    public TADataObject() {
    }

    public TADataObject(String TA_ID, String TA_Name, String TA_Image) {
        this.TA_ID = TA_ID;
        this.TA_Name = TA_Name;
        this.TA_Image = TA_Image;
    }

    public String getTA_ID() {
        return TA_ID;
    }

    public String getTA_Image() {
        return TA_Image;
    }

    public String getTA_Name() {
        return TA_Name;
    }

    public void setTA_ID(String newTA_ID) {
        TA_ID = newTA_ID;
    }

    public void setTA_Name(String newTA_Name) {
        TA_Name = newTA_Name;
    }

    public void setTA_Image(String newTA_Image) {
        TA_Image = newTA_Image;
    }

}
