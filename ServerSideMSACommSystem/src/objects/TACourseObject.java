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
public class TACourseObject implements Serializable {
    private static final long serialVersionUID = 101L;
    private String CourseID;
    private String CourseName;
    
    public TACourseObject()
    {
        CourseID=null;
        CourseName=null;
    }
    
    public TACourseObject(String CourseID, String CourseName)
    {
        this.CourseID = CourseID;
        this.CourseName = CourseName;
    }
    
    public String getCourseID() {
        return CourseID;
    }
    
    public String getCourseName() {
        return CourseName;
    }

    public void setCourseID(String newCourseID) {
        CourseID = newCourseID;
    }
    
    public void setCourseName(String newCourseName) {
        CourseName = newCourseName;
    }
}
