

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

@WebServlet("/edit")
public class EditServ extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out=response.getWriter();

			
			String mail = request.getParameter("email");
			System.out.println(mail);
			User u = null;
			int a=0;
			try {
				u = new UserDao().getOneUser(mail);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(u!=null){
				 
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
					out.print("<li><a href='adminprofile'>medicine</a></li>");
					out.print("<li><a href='addmedicine'>Services</a></li>");
					out.print("<li><a href='#'>Portfolio</a></li>");
					out.print("<li><a href='logout'>LogOut</a></li>");
					out.print("</ul>");
					out.print("</div>");
					out.print("<div class='welcome-text'>");
				    
					
					
					
					out.print("    <form action='update' method='post'>\n");
					out.print("      <div class='imgcontainer'>\n");
					out.print("        <img src='https://www.w3schools.com/howto/img_avatar2.png' alt='Avatar' class='avatar'>\n");
					out.print("      </div>\n");
					out.print("      \n");
					out.print("      <div class='container'>\n");
					out.print("        <label><b>Username</b></label>\n");
					out.print("<input type='text' name = 'name' placeholder='Enter your name'value='"+u.getName()+"' required>");
					out.print("\n");
					out.print("        <label><b>Email</b></label>\n");
		               out.print("<input type='email' name='email' placeholder='Enter your email' value='"+u.getEmail()+"'>");
					out.print("        \n");

					out.print("        <label ><b>Phone Number</b></label>\n");
		               out.print("<input type='text' name = 'number' placeholder='Enter ddsds Phone Number 'value='"+u.getNumber()+"' required>");
					out.print("\n");
					out.print("        <label><b>Password</b></label>\n");
		               out.print("<input type='password' name='pass' placeholder='Enter your  dfdfdspassword' 'value='"+u.getPass()+"' required>");
					out.print("\n");
					out.print("        <button type='submit'>Login</button>\n");
					out.print("        <label>\n");
					out.print("          <input type='checkbox' checked='checked' name='pass'> Remember me\n");
					out.print("        </label>\n");
					out.print("      </div>\n");
					out.print("\n");
					out.print("      <div class='container' style='background-color:#f1f1f1'>\n");
					out.print("        <button type='button' class='cancelbtn'>Cancel</button>\n");
					out.print("        <span class='psw'>Forgot <a href='#'>password?</a></span>\n");
					out.print("      </div>\n");
					out.print("    </form>\n");

					
			/*		
					
			        out.print("<form for='flip' action='update'>");
					out.print("<input type='text' name = 'name' placeholder='Enter your name'value='"+u.getName()+"' required>");
		         
		             out.print("<div class='input-box'>");
		               out.print("<i class='fas fa-envelope'></i>");
		               out.print("<input type='email' name='email' placeholder='Enter your email' value='"+u.getEmail()+"'>");
		             out.print("</div>");
		             out.print("<div class='input-box'>");
		               out.print("<i class='fas fa-phone'></i>");
		               out.print("<input type='text' name = 'number' placeholder='Enter ddsds Phone Number' required>");
		             out.print("</div>");
		             out.print("<div class='input-box'>");
		               out.print("<i class='fas fa-lock'></i>");
		               out.print("<input type='password' name='pass' placeholder='Enter your  dfdfdspassword' required>");
		             out.print("</div>");
		             out.print("<div class='button input-box'>");
		               out.print("<input type='submit' value='Sumbit'>");
		               out.print("</div>");
		             out.print("</div>");
				    out.print("</div>");
				    out.print("</div>");
		*/
			 }else{
				 out.print("there is  error");
			 }
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
