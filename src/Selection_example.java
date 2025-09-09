import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Selection_example {
    public static void main(String[] args) throws Exception {
        Connection con = dbconnection.getConn();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter emp id to view details: ");
        String empid = sc.nextLine();

        String sql = "SELECT empid, empname, department, salary FROM emp WHERE empid = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, empid);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("Employee ID : " + rs.getString("empid"));
            System.out.println("Name        : " + rs.getString("empname"));
            System.out.println("Department  : " + rs.getString("department"));
            System.out.println("Salary      : " + rs.getDouble("salary"));
        } else {
            System.out.println("Employee not found.");
        }

        rs.close();
        pstmt.close();
        sc.close();
        con.close();
    }
}
