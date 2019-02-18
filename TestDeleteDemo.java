package jdbcproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.ems.util.DButil;

public class TestDeleteDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter empId:");
		int eid= sc.nextInt();
		System.out.println("enter empName:");
	       sc.nextLine();
			String enm= sc.nextLine();
			System.out.println("enter salary:");
		float esal=sc.nextFloat();
		try
		{
			Connection con= DButil.getCon();
			String insertQry= "UPDATE emp1 SET emp_name =?, emp_sal=? WHERE emp_id=?";
			
			PreparedStatement pst=con.prepareStatement(insertQry);
			pst.setInt(3, eid);
			pst.setString(1, enm); 
			pst.setFloat(2, esal);
			int data=pst.executeUpdate();
		    
		    System.out.println("Data is updated"+data);
		}
		catch (SQLException e) {
			
			e.printStackTrace();
			
			}
			catch (IOException e) {
				
				e.printStackTrace();
			}

	}

}
