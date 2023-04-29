

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class LogoutServ extends HttpServlet {
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Cookie c = new Cookie("email", "");
		c.setMaxAge(0);
		response.addCookie(c);

		
		out.print("<!DOCTYPE html>");
		out.print("<html lang='en'>");
		out.print("<head>");
		    out.print("<meta charset='UTF-8'>");
		    out.print("<title>Profile</title>");
		    out.print("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap' rel='stylesheet'>");
		    out.print("<link rel='stylesheet' href='css/style1.css'>");    
		out.print("</head>");
		out.print("<body>");
		    out.print("<header>");
		    out.print("<div class='wrapper'>");
		        
		out.print("<ul class='nav-area'>");
		out.print("<li><a href='login.html'>Login</a></li>");
		out.print("<li><a href='admin.html'>Admin</a></li>");
		out.print("<li><a href='adminprofile'>Profile</a></li>");
		out.print("<li><a href='#'>Services</a></li>");
		out.print("<li><a href='#'>Portfolio</a></li>");
		out.print("<li><a href='logout'>LogOut</a></li>");
		out.print("</ul>");
		out.print("</div>");
		out.print("<div class='welcome-text'>");
		        out.print("<h3>");
				out.print("you are successfully Log out.</h3>");
		    out.print("</div>");
		out.print("</header>");

		out.print("</body>");
		out.print("</html>");


}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
