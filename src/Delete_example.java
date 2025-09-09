import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete_example {
    public static void main(String[] args) throws Exception {
        Connection con = dbconnection.getConn();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter emp id to delete: ");
        String empid = sc.nextLine();

        String sql = "DELETE FROM emp WHERE empid = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, empid);

        int rowAffected = pstmt.executeUpdate();

        if (rowAffected > 0) {
            System.out.println("Record Deleted Successfully");
        } else {
            System.out.println("Employee not found. Deletion Failed");
        }

        pstmt.close();
        sc.close();
        con.close();
    }
}
