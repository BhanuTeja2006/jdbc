import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update_example {
    public static void main(String[] args) throws Exception {
        Connection con = dbconnection.getConn();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter emp id to update:");
        String empid = sc.nextLine();

        System.out.print("Enter new Salary:");
        double newSalary = sc.nextDouble();

        String sql = "UPDATE emp SET salary = ? WHERE empid = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setDouble(1, newSalary);
        pstmt.setString(2, empid);

        int rowAffected = pstmt.executeUpdate();

        if (rowAffected > 0) {
            System.out.println("Record Updated Successfully");
        } else {
            System.out.println("Employee not found. Update Failed");
        }

        pstmt.close();
        sc.close();
        con.close();
    }
}
