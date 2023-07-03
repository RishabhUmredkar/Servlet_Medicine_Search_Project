package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicineDao {

	public class getOneUser extends User {

	}


	String url = "jdbc:mysql://localhost:3306/MedicineSearch";
	String uname = "root";
	String upass = "abc123";
	String driver = "com.mysql.cj.jdbc.Driver";
	
	Connection con;
	
	private Connection getconnect() throws ClassNotFoundException, SQLException
	{
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uname,upass);
		return con;
		
	}


	public int insert(Medicine m) throws ClassNotFoundException, SQLException {
		String sql = "insert into tb2(medicineName,companyName, quantity) values (?,?,?)";
		con = getconnect();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, m.getMedicineName());
		ps.setString(2, m.getCompanyName());
		ps.setString(3, m.getNumber());
		
		int m1 =ps.executeUpdate();
		con.close();
		return m1;
	}
	

	public List<Medicine> getAllData() throws ClassNotFoundException, SQLException {

		String sql="SELECT * FROM tb2";
		con = getconnect();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		List<Medicine> le=new ArrayList<Medicine>();
		
		
		while(rs.next())
		{
			Medicine e=new Medicine(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4));
			
			le.add(e);
		}
		
		
		return le;
	}


	public Medicine getOneUser(int id) throws ClassNotFoundException, SQLException {
		String sql = "select * from tb2 where id=?";
		con = getconnect();
		//PreparedStatement ps = con.prepareStatement(sql);
		// PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		 PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		 ps.setInt(1,id);
		
		ResultSet rs = ps.executeQuery();
		rs.absolute(1);
		System.out.println("Value of a ="+rs.getString(4));

		Medicine m = new Medicine(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		
		return m;

	}

	public int update(Medicine m) throws ClassNotFoundException, SQLException {
		Connection con=getconnect();
    	PreparedStatement ps=con.prepareStatement("update tb2 set medicineName=?,companyName=?,quantity=? where id=?");
		ps.setString(1, m.getMedicineName());
		ps.setString(2, m.getCompanyName());
		ps.setString(3, m.getNumber());
		ps.setInt(4, m.getId());
			
		int a=ps.executeUpdate();
		con.close();
		return  a;		
	}


	public int delete(int id) throws SQLException, ClassNotFoundException {
		Connection con=getconnect();
    	PreparedStatement ps=con.prepareStatement("delete from tb2 where id=?");
		ps.setInt(1,id);
	
		int a=ps.executeUpdate();
		con.close();
		return  a;
	}

	

}
