package jdbcproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.ems.util.DButil;

public class TestInsertDemos {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter empId:");
		int eid= sc.nextInt();
		System.out.println("enter empName:");
       sc.nextLine();
		String enm= sc.nextLine();
		System.out.println("enter salary:");
	float esal=sc.nextFloat();
	try {
		Connection con=DButil.getCon();
		String insertQry="INSERT INTO emp1" 
		+ "(emp_id,emp_name,emp_sal)" 
				+ "VALUES(?,?,?)";
		PreparedStatement pst=con.prepareStatement(insertQry);
		pst.setInt(1, eid); //  1 is ? index
		pst.setString(2, enm); 
		pst.setFloat(3, esal);
	    int data=pst.executeUpdate();
	    
	    System.out.println("Data is inserted"+data);
	} catch (SQLException e) {
		
	e.printStackTrace();
	
	}
	catch (IOException e) {
		
		e.printStackTrace();
	}
	}

}
