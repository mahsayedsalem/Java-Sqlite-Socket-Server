/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

/**
 *
 * @author Mahmoud S. Ahmed
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import objects.ReservationObject;
import objects.RoomObject;
import objects.StudentAttendanceListObject;
import objects.StudentAttendanceObject;
import objects.TACourseObject;
import objects.TACoursesListObject;
import objects.TADataObject;

public class DBHandler {
    
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:MSACOMM.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public ArrayList <RoomObject> FromDataBaseRotoArray() {
        String sql = "SELECT ROOMID, ROOMTYPE, Capacity, Availability FROM roominfo";
        
        String RoomID;
        int RoomType;
        String Capacity;
        int Avail;
        
        ArrayList<RoomObject> roomarray;
        roomarray = new ArrayList<>();
        

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            

            // loop through the result set
            while (rs.next()) {
                RoomID = rs.getString("ROOMID");
                RoomType = rs.getInt("ROOMTYPE");
                Capacity = rs.getString("Capacity");
                Avail = rs.getInt("Availability");
                RoomObject roomobject = new RoomObject(RoomID, RoomType, Capacity, Avail);
                roomarray.add(roomobject);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return roomarray;
    }
    
    public ArrayList <ReservationObject> FromDataBaseRestoArray() {
        String sql = "SELECT REQID, ROOMID, DATE, TIME, DURATION, USERID FROM resinfo";
        
        int Req_ID;
        String RoomID;
        String Time;
        String Duration;
        String Date;
        String User;
        
        ArrayList<ReservationObject> reservationarray;
        reservationarray = new ArrayList<>();
        

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            

            // loop through the result set
            while (rs.next()) {
                Req_ID = rs.getInt("REQID");
                RoomID = rs.getString("ROOMID");
                Date = rs.getString("DATE");
                Time = rs.getString("TIME");
                Duration = rs.getString("DURATION");
                User = rs.getString("USERID");
                
                ReservationObject reservationobject = new ReservationObject(Req_ID, RoomID, Date, Time, Duration, User);
                reservationarray.add(reservationobject);       
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reservationarray;
    }
    
    public int login(String UserName, String Password) {
        String sql = "SELECT username, password FROM login";
        int flag=0;
        
        
        

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            

            // loop through the result set
            while (rs.next()) {
                if(UserName.equals(rs.getString("username")) && Password.equals(rs.getString("password")))
                {
                    flag=1;
                    break;
                }
                
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return flag;
    }
    
    public void insert(String RoomID, int RoomType, String Capacity, int Avail) {
        String sql = "INSERT INTO roominfo(ROOMID,ROOMTYPE,Capacity,Availability) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, RoomID);
                pstmt.setInt(2, RoomType);
                pstmt.setString(3, Capacity);
                pstmt.setInt(4, Avail);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(String RoomID, int RoomType, String Capacity, int Avail) {
        String sql = "UPDATE roominfo SET ROOMTYPE = ? , "
                + "Capacity = ? ,"
                + "Availability = ? "
                + "WHERE ROOMID = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, RoomType);
            pstmt.setString(2, Capacity);
            pstmt.setInt(3, Avail);
            pstmt.setString(4, RoomID);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(String RoomID) {
        String sql = "DELETE FROM roominfo WHERE ROOMID = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, RoomID);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<RoomObject> UpDataAvail ()
    {
        DBHandler dbhandler = new DBHandler();
        ArrayList<RoomObject> roomarray;
        roomarray = new ArrayList<>();
        roomarray = dbhandler.FromDataBaseRotoArray();
        ArrayList<ReservationObject> resarray;
        resarray = new ArrayList<>();
        resarray = dbhandler.FromDataBaseRestoArray();
        
        
        for (int i=0; i<roomarray.size(); i++)
        {
            for (int j=0; j<resarray.size(); j++)
            {
                if (roomarray.get(i).getRoomID().equals(resarray.get(j).getRoomID()))
                        {
                            roomarray.get(i).setAvail(1);
                            break;
                        }
                else
                    roomarray.get(i).setAvail(0); 
            }
        }
        return roomarray;
    }
    
    public int androidusers (String UserName, String Password)
    {
        String sql = "SELECT * FROM AndroidLogin";
        int flag=0;
        
        
        

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            

            // loop through the result set
            while (rs.next()) {
                if(UserName.equals(rs.getString("UserID")) && Password.equals(rs.getString("Password")))
                {
                    if (rs.getString("UserType").equals("1"))
                    {
                        flag=1; //TeacherAssistantFlag
                        break;
                    }
                    else
                    {
                        flag=2; //StudentFlag
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
    
    public TADataObject TADataNavigation(String TA_ID)
    {
        TADataObject tadataobject = new TADataObject();
        String sql = "SELECT * FROM TeachingAssistant";
        String TA_Name = null;
        String TA_Image = null;
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            

            // loop through the result set
            while (rs.next()) {
                if(TA_ID.equals(rs.getString("TA_ID")))
                {
                    TA_Name = rs.getString("TA_Name");
                    TA_Image = rs.getString("TA_Image");
                    break;
                }  
            }  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
   
       tadataobject.setTA_ID(TA_ID);
       tadataobject.setTA_Image(TA_Image);
       tadataobject.setTA_Name(TA_Name);
       return tadataobject;
    }
    
    public TACoursesListObject TACourseList (String TA_ID)
    {
        String sql = "SELECT TA_ID, CourseID, CourseName FROM TeachingAssistant natural join Courses";
        String Course_ID = null;
        String Course_Name = null;
        TACourseObject co = new TACourseObject();
        ArrayList<TACourseObject> ro = new ArrayList<>();
        TACoursesListObject tacourseslistobject = new TACoursesListObject();
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // loop through the result set
            while (rs.next()) {
                if(TA_ID.equals(rs.getString("TA_ID")))
                {
                    Course_ID = rs.getString("CourseID");
                    Course_Name = rs.getString("CourseName");
                    co.setCourseID(Course_ID);
                    co.setCourseName(Course_Name);
                    ro.add(co);
                }  
            }  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        tacourseslistobject.setro(ro);
        return tacourseslistobject;
    }
    
    public StudentAttendanceListObject StudentAttendanceList(String Course_ID)
    {
        StudentAttendanceListObject listobject = new StudentAttendanceListObject();
        ArrayList<StudentAttendanceObject> list = new ArrayList<>();
        String sql = "SELECT StudentID,StudentName,CourseID FROM EnrollStudents natural join Students";
        String Student_Name;
        String Student_ID;
      
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // loop through the result set
            while (rs.next()) {
                if(Course_ID.equals(rs.getString("CourseID")))
                {
                    Student_Name = rs.getString("StudentName");
                    Student_ID = rs.getString("StudentID");
                    StudentAttendanceObject object = new StudentAttendanceObject(Student_Name, Student_ID);
                    list.add(object);
                }  
            }  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        listobject.setro(list);
        return listobject;
    }
}
