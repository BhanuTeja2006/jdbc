import java.sql.*;
import java.util.Scanner;


public class JdbcDemo {

	public static void main(String[] args)throws SQLException {
		Scanner sc = new Scanner(System.in);
		  System.out.print("Enter empid: ");
		  String empid = sc.nextLine();
		  System.out.print("Enter empname: ");
		  String empname = sc.nextLine();
		  System.out.print("Enter department: ");
		  String department = sc.nextLine();
		  System.out.print("Enter salary: ");
		  double salary = sc.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");
		    PreparedStatement st=con.prepareStatement("insert into emp values('"+ empid +"', '"+ empname + "', '" + department + "', "+ salary + ");");
		    st.executeUpdate();
		    System.out.println("successfull");
		    st.close();
		    con.close();
		    sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
