

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

@WebServlet("/addmedicine")
public class AddMedicine extends HttpServlet {
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out=response.getWriter();


		Cookie c[] = request.getCookies();
		if(c!=null)
		{

			String mail = c[0].getValue();

			System.out.println(mail);
			if(!mail.equals("")|| mail!=null)
			{
			 out.print("  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");

				out.print("<!DOCTYPE html>");
				out.print("<html lang='en'>");
				out.print("<head>");
				    out.print("<meta charset='UTF-8'>");
				    out.print("<title>Profile</title>");
				    out.print("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap' rel='stylesheet'>");
				    out.print("<link rel='stylesheet' href='css/style1.css'>"); 
				    out.print("<link rel='stylesheet' href='css/editTable.css'>");    
				out.print("</head>");
				out.print("<body>");
				    out.print("<header>");
				    out.print("<div class='wrapper'>");
				        
				out.print("<ul class='nav-area'>");
				out.print("<li><a href='user'>View</a></li>");
				out.print("<li><a href='medicine'>medicine</a></li>");
				out.print("<li><a href='addmedicine'>Add Medicine</a></li>");
				out.print("<li><a href='#'>Portfolio</a></li>");
				out.print("<li><a href='logout'>LogOut</a></li>");
				out.print("</ul>");
				out.print("</div>");
				out.print("<div class='welcome-text'>");
			    
				
				
				
				out.print("    <form action='medicineform' method='post'>\n");
				out.print("      <div class='imgcontainer'>\n");
				out.print("        <img src='https://cdn.xxl.thumbs.canstockphoto.com/multicolored-medicine-pills-on-the-white-background-stock-image_csp8013966.jpg' alt='Avatar' class='avatar'>\n");
				out.print("      </div>\n");
				out.print("      \n");
				out.print("      <div class='container'>\n");

				out.print("        <label><b> Medicine name</b></label>\n");
				out.print("<input type='text' name = 'medicineName' placeholder='Enter Medicine name 'value='' required>");
				out.print("\n");

				out.print("        <label><b> Company name '</b></label>\n");
				out.print("<input type='text' name = 'companyName' placeholder='Enter Company name 'value='' required>");
				out.print("\n");

				out.print("        <label><b>Medicine Quantity </b></label>\n");
				out.print("<input type='text' name = 'quantity' placeholder='Enter Quantity Number'value='' required>");
				out.print("\n");
				out.print("        <button type='submit'>Login</button>\n");
				out.print("        <label>\n");
				out.print("      </div>\n");
				out.print("\n");
				out.print("      </div>\n");
				out.print("    </form>\n");
		 }
		
		}
		else{
			request.getRequestDispatcher("index.html").forward(request, response);

		}}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
