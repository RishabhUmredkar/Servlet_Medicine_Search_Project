package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
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


	public int insert(User u) throws ClassNotFoundException, SQLException {
		String sql = "insert into tb1(name,email, number,pass) values (?,?,?,?)";
		con = getconnect();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getName());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getNumber());
		ps.setString(4, u.getPass());
		
		int a =ps.executeUpdate();
		con.close();
		return a;
	}
	public boolean checkUser(User u) throws ClassNotFoundException, SQLException {
		String select = "SELECT * FROM tb1 WHERE email=? and pass =?;";
		con = getconnect();
		//PreparedStatement ps = con.prepareStatement(select);
		//PreparedStatement ps = con.prepareStatement(sql);
		// PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		 PreparedStatement ps = con.prepareStatement(select, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ps.setString(1, u.getEmail());
		ps.setString(2, u.getPass());
		
		ResultSet rs = ps.executeQuery();
		boolean a= rs.absolute(1);
		//System.out.println("Value of a ="+rs.getString(2));
		
	    /*while(rs.next())
	    {
	    	if(u.getEmail().equals(rs.getString(2))&&u.getPass().equals(rs.getString(4)))
	    	{
	    		return true;
	    	}
	    }*/
		
		return a;

}
	
	public List<User> getAllData() throws ClassNotFoundException, SQLException {

		String sql="SELECT * FROM tb1";
		con = getconnect();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		List<User> le=new ArrayList<User>();
		
		
		while(rs.next())
		{
			User e=new User(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4));
			
			le.add(e);
		}
		
		
		return le;
	}


	public int delete(String mail) throws ClassNotFoundException, SQLException {
		Connection con=getconnect();
    	PreparedStatement ps=con.prepareStatement("delete from tb1 where email=?");
		ps.setString(1,mail);
	
		int a=ps.executeUpdate();
		con.close();
		return  a;
	}




	public User getOneUser(String mail) throws ClassNotFoundException, SQLException {
		String sql = "select * from tb1 where email=?";
		con = getconnect();
		//PreparedStatement ps = con.prepareStatement(sql);
		// PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		 PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		 ps.setString(1,mail);
		
		ResultSet rs = ps.executeQuery();
		rs.absolute(1);
		System.out.println("Value of a ="+rs.getString(2));

		User U = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		return U;
	}
	
	public int update(User u) throws ClassNotFoundException, SQLException {
		Connection con=getconnect();
    	PreparedStatement ps=con.prepareStatement("update tb1 set name=?,number=?,pass=? where email=?");
		ps.setString(1, u.getName());
		ps.setString(2, u.getNumber());
		ps.setString(3, u.getPass());
		ps.setString(4, u.getEmail());
			
		int a=ps.executeUpdate();
		con.close();
		return  a;
	}
	
}
