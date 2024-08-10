import java.sql.*;

class StudentData {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null; 

        try {
			//fetch driver class of jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");
			//connect database (path_of_database, user_name, password)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "root", "");

			//query to select data
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM student_detail");

            while (rs.next()) {
				
				//to get student data from database
                int std_no = rs.getInt("student_no");
                String std_name = rs.getString("student_name");
                String std_dob = rs.getString("student_dob");
				String std_cno = rs.getString("student_cno");

				//to print student data from database
                System.out.println("Student No : " + std_no);
				System.out.println("Student Name : " + std_name);
				System.out.println("Student Date of Birth : "+ std_dob);
				System.out.println("Student Contact No : "+ std_cno);
				System.out.println();
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class Not Found : " + cnfe.getMessage());
        } catch (SQLException se) {
            System.out.println("SQL Exception : " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();		//close ResultSet
                }
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
