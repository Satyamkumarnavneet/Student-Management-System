package StudentManage;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectToDatabase {

    static Connection con;

    public static Connection createConnection(){
        try {
            // Load the drivers
            Class.forName("com.mysql.jdbc.Driver");

            // Create the connection
            String user = "root";
            String password = "Enter your Mysql password";
            String url = "jdbc:mysql://localhost:3306/studentmanagement";
            con = DriverManager.getConnection(url,user,password);


        } catch (Exception e){
            e.printStackTrace();
        }
        return con;

    }
    public static void main(String[] args) {

    }
}
