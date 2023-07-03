import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

@WebServlet("/user")
public class ViewServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		Cookie c[] = request.getCookies();
		if(c!=null)
		{

			String mail = c[0].getValue();

			
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
				    out.print("<link rel='stylesheet' href='css/table.css'>");    
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
			    out.print("</div>");
			    out.print("</div>");
			    List<User> le=null;
				try {
					
					
					le=new UserDao().getAllData();
					out.print("<table class='table table-striped'>");
					out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Number</th><th>Password</th><th>Action</th></tr>");
					for(User e:le)
					{
					out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td> "+e.getNumber()+"</td><td> "+e.getPass()+
							
							"<td><a href='edit?id="+e.getId()+"' class='btn btn-primary'>Edit</a><span>    <span><a href='delete?id="+e.getId()+"' class='btn btn-danger'>Delete</a></td></tr>");
					}
					
					out.print("</table>");
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}out.print("</header>");

				out.print("</body>");
				out.print("</html>");

			}}	else{
				request.getRequestDispatcher("index.html").forward(request, response);

			}
			}
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
