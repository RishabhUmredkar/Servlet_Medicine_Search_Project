

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
	        out.print("<form for='flip' action='update'>");
			out.print("<input type='text' name = 'name'placeholder='Enter your name' required>");
             out.print("</div>");
             out.print("<div class='input-box'>");
               out.print("<i class='fas fa-envelope'></i>");
               out.print("<input type='email' name='email' placeholder='Enter your email' >"+u.getEmail());
             out.print("</div>");
             out.print("<div class='input-box'>");
               out.print("<i class='fas fa-phone'></i>");
               out.print("<input type='text' name = 'number' placeholder='Enter Phone Number' required>");
             out.print("</div>");
             out.print("<div class='input-box'>");
               out.print("<i class='fas fa-lock'></i>");
               out.print("<input type='password' name='pass' placeholder='Enter your password' required>");
             out.print("</div>");
             out.print("<div class='button input-box'>");
               out.print("<input type='submit' value='Sumbit'>");
             out.print("</div>");
			 }else{
				 out.print("there is  error");
			 }
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
