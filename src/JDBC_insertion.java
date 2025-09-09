//import java.sql.Statement
//import java.sql.Connection
import java.sql.*;
import java.util.*;

public class JDBC_insertion {
 public static void main(String[] args) throws Exception {
  Connection conn = dbconnection.getConn();
  Statement stmt = conn.createStatement();
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter empid: ");
  String empid = sc.nextLine();
  System.out.print("Enter empname: ");
  String empname = sc.nextLine();
  System.out.print("Enter department: ");
  String department = sc.nextLine();
  System.out.print("Enter salary: ");
  double salary = sc.nextDouble();
  int i = stmt.executeUpdate("Insert Into emp(empid, empname, department, salary) Values('"+ empid +"', '"+ empname + "', '" + department + "', "+ salary + ")");
  if(i == 1) {
   System.out.println("Record inserted successfully");
  } else {
   System.out.println("Insertion failed");
  }
  stmt.close();
  conn.close();
  sc.close();
 }
}