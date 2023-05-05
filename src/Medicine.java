

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/medicine")
public class Medicine extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html lang='en'>");
		out.print("<head>");
		    out.print("<meta charset='UTF-8'>");
		    out.print("<title>Profile</title>");
		    out.print("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap' rel='stylesheet'>");
		    out.print("<link rel='stylesheet' href='css/style1.css'>"); 
		    //out.print("<style>");
		    //out.print("a.button3{ display:inline-block; padding:0.3em 1.2em; margin:0 0.3em 0.3em 0; border-radius:2em; box-sizing: border-box; text-decoration:none; font-family:'Roboto',sans-serif; font-weight:300; color:#FFFFFF; background-color:#4eb5f1; text-align:center; transition: all 0.2s;}");
		    //out.print("a.button3:hover{ background-color:#4095c6;}");
		    //out.print("@media all and (max-width:30em){a.button3{  display:block;  margin:0.2em auto; }}");
		    out.print("</head>");
		out.print("<body>");
		    out.print("<header>");
		    out.print("<div class='wrapper'>");
		        
		out.print("<ul class='nav-area'>");
		out.print("<li><a href='user'>View</a></li>");
		out.print("<li><a href='#'>Medicine</a></li>");
		out.print("<li><a href='#'>Services</a></li>");
		out.print("<li><a href='#'>Portfolio</a></li>");
		out.print("<li><a href='logout'>LogOut</a></li>");
		out.print("</ul>");
		out.print("</div>");
		out.print("<div class='welcome-text'>");
		out.print("<a href='addmedicine' class='button'>Button</a>");
		        out.print("<h3>");
		out.print("Hello Admin</h3>");
		    out.print("</div>");
		out.print("</header>");

		out.print("</body>");
		out.print("</html>");

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
