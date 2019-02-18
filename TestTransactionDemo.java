package jdbcproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.ems.util.DButil;

public class TestTransactionDemo {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con=DButil.getCon();
			con.setAutoCommit(false);
			String update1="Update emp1 set emp_name='VaishaliS' "+
					"WHERE emp_id=111";
			String update2="Update emp1 set emp_sal=3000" +
					" WHERE emp_id=222 ";
			Statement st=con.createStatement();
			st.addBatch(update1);
			st.addBatch(update2);
			int arr[]=st.executeBatch();
			con.commit();
			System.out.println("Update Successfully");
			
			
		} catch (SQLException | IOException e) {
	try {
		
	
			con.rollback();
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
			e.printStackTrace();
		}
		
		

	}

}
