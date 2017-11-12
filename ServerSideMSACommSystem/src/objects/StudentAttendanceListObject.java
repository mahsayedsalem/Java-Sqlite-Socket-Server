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
public class StudentAttendanceListObject implements Serializable {

    private static final long serialVersionUID = 104L;
    ArrayList<StudentAttendanceObject> ro = new ArrayList<>();

    public StudentAttendanceListObject() {

    }

    public ArrayList<StudentAttendanceObject> getro() {
        return ro;
    }

    public void setro(ArrayList<StudentAttendanceObject> newro) {
        ro = newro;
    }
}
