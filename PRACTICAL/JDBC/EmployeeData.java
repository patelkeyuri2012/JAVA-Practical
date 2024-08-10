import java.sql.*;
import java.util.Scanner;

class EmployeeData {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        try {
			//fetch driver class of jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");		
			//connect database (path_of_database, user_name, password)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "root", "");		

            Scanner sc = new Scanner(System.in);

			//fetch all details from user to insert into employee_detail table
            System.out.print("Enter Employee No : ");
            int emp_no = sc.nextInt();
            System.out.print("Enter Employee Name : ");
            String emp_name = sc.next();
            System.out.print("Enter Employee Date of Birth (yyyy-mm-dd) : ");
            String emp_dob = sc.next();
            System.out.print("Enter Employee JOB : ");
            String emp_job = sc.next();
            System.out.print("Enter Employee Contact No : ");
            String emp_cno = sc.next();

			//query to insert data
            st = con.createStatement();
            int c = st.executeUpdate("INSERT INTO employee_detail (employee_no, employee_name, employee_dob, employee_job, employee_cno) " + "VALUES (" + emp_no + ", '" + emp_name + "', '" + emp_dob + "', '" + emp_job + "', '" + emp_cno + "')");

            if (c <= 0) {
                System.out.println("Insertion Failed");
            } else {
                System.out.println("Insertion successfully");
            }
			
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class Not Found : " + cnfe.getMessage());
        } catch (SQLException se) {
            System.out.println("SQL Exception : " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();		//close Statement
                }
                if (con != null) {
                    con.close();		//close Connection
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception : " + e.getMessage());
            }
        }
    }
}
