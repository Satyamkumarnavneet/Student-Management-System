package StudentManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StoreStudnet {
    public static boolean insertStudnetToDB(Student s1){
        boolean flag = false;
        try {
            Connection con = ConnectToDatabase.createConnection();
            String query = "insert into students(sname,sphone,scity) values(?,?,?)";
            // Prepared statement
            PreparedStatement pstmt = con.prepareStatement(query);
            // Set the values of parameters
            pstmt.setString(1,s1.getStudentName());
            pstmt.setString(2,s1.getStudentPhone());
            pstmt.setString(3,s1.getStudentCity());

            // Execute..
            pstmt.executeUpdate();
            flag = true;


        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
    public static boolean deleteStudent(int userId) {
        boolean flag = false;
        try {
            Connection con = ConnectToDatabase.createConnection();
            String query = "delete from students where sid = ?";
            // Prepared statement
            PreparedStatement pstmt = con.prepareStatement(query);
            // Set the values of parameters
            pstmt.setInt(1,userId);


            // Execute..
            pstmt.executeUpdate();
            flag = true;


        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;


    }

    public static boolean displayAllStudent() {
        boolean flag = false;
        try {
            Connection con = ConnectToDatabase.createConnection();
            String query = "select * from students";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            while (set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString("scity"); // We can pass column lable
                System.out.println("ID: "+id);
                System.out.println("Name: "+ name);
                System.out.println("Phone: "+ phone);
                System.out.println("City: "+ city);
                System.out.println("----------------------------------------");


            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;


    }
}
