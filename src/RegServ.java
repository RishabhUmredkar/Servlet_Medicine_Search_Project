

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

@WebServlet("/reg")
public class RegServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		String mail = request.getParameter("email");
		String number = request.getParameter("number");
		String pass = request.getParameter("pass");

		User u =new User(name,mail,number,pass);
		
		
		int a =0;
		
		try {
			a =new UserDao().insert(u);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a>0){
			out.print("user Register !");
			request.getRequestDispatcher("userprofile").include(request, response);
			Cookie c = new Cookie("email", mail);
			response.addCookie(c);


		}
		else{
			out.print("Internal error!");
			request.getRequestDispatcher("index.html").include(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
