

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDao;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		
		Cookie c[] = request.getCookies();
		if(c!=null)
		{

			String mail = c[0].getValue();

			
			if(!mail.equals("")|| mail!=null)
			{
		String mail1=request.getParameter("email");
	    
		try {
			int a=new UserDao().delete(mail1);
			if(a>0)
			{
				System.out.print("user delete");
			     response.sendRedirect("user");
			}
			else
				out.print("user not delete");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
