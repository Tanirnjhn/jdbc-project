package jdbcproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testDemo {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE"
					,"system","Capgemini123");
			st=con.createStatement();
      ResultSet rs=st.executeQuery("SELECT * FROM emp1");
		System.out.println("ID\t\t NAME\t\t SALARY\t\t DOJ");
      while(rs.next())
      {
    	  System.out.println(rs.getInt("emp_id")+"\t\t"+ rs.getString("emp_name")+
    			  "\t\t"+ rs.getInt("emp_sal")+"\t\t"+ rs.getDate("emp_doj"));
      }
      
      
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
