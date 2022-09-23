import StudentManage.StoreStudnet;
import StudentManage.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException  {
        System.out.println("Welcome to Student Management System!!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("Press 1 to Add Studnet");
            System.out.println("Press 2 to Delete Student");
            System.out.println("Press 3 to Display Studnet");
            System.out.println("Press 4 to Exit");
            System.out.println("****************************");
            System.out.print("Please Enter your input: ");
            int c = Integer.parseInt(br.readLine());

            if (c == 1){
                // add studnet
                System.out.print("Enter User name: ");
                String name = br.readLine();
                System.out.print("Enter User Phone: ");
                String phoneNumber = br.readLine();
                System.out.print("Enter User City: ");
                String city = br.readLine();

                // Create student object to store student
                Student s1 = new Student(name,phoneNumber,city);
                boolean ans = StoreStudnet.insertStudnetToDB(s1);
                System.out.println(s1);
                if (ans){
                    System.out.println("Studnet is added Succesfully...");
                } else {
                    System.out.println("Something went wrong...Try again");
                }
            } else if(c == 2){
                // delete student
                System.out.print("Enter student id to delete: ");
                int userId = Integer.parseInt(br.readLine());
                boolean ans = StoreStudnet.deleteStudent(userId);
                if (ans){
                    System.out.println("Deleted...");
                } else {
                    System.out.println("Something went wrong");
                }

            } else if (c == 3){
                // Display student
                StoreStudnet.displayAllStudent();


            } else if (c == 4){
                //
                break;
            }else {

            }
        }
        System.out.println("Thank You For Using My Application...");
        System.out.println("See you soon!!");
    }
}