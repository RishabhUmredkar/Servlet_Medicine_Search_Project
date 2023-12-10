

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MedicineDao;
import model.UserDao;


@WebServlet("/deletemedicine")
public class DeleteMedicine extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		
		Cookie c[] = request.getCookies();
		if(c!=null)
		{

			String mail = c[0].getValue();

			
			if(!mail.equals("")|| mail!=null)
			{
		int id=Integer.parseInt(request.getParameter("id"));
	    
		try {
			int a=new MedicineDao().delete(id);
			if(a>0)
			{
				System.out.print("Medicine delete");
			     response.sendRedirect("medicine");
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
