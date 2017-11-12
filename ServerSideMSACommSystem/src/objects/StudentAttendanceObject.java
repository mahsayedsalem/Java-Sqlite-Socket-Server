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
public class StudentAttendanceObject implements Serializable {
    private static final long serialVersionUID = 103L;
    private String StudentID;
    private String StudentName;
    
    public StudentAttendanceObject()
    {
        StudentID=null;
        StudentName=null;
    }
    
    public StudentAttendanceObject(String StudentID, String StudentName)
    {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
    }
    
    public String getStudentID() {
        return StudentID;
    }
    
    public String getStudentName() {
        return StudentName;
    }

    public void setStudentID(String newStudentID) {
        StudentID = newStudentID;
    }
    
    public void setStudentName(String newStudentName) {
        StudentName = newStudentName;
    }  
}
