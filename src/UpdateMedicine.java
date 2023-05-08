

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Medicine;
import model.MedicineDao;


@WebServlet("/updatemedicine")
public class UpdateMedicine extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String MedicineName = request.getParameter("medicineName");
		String CompanyName = request.getParameter("companyName");
		String Number = request.getParameter("quantity");
		
		Medicine m =new Medicine(id, MedicineName, CompanyName, Number);
		System.out.println(id+Number);

		
		try {
			int a= new MedicineDao().update(m);
			if(a>0){
				out.print("Updated!");	
				response.sendRedirect("medicine");
			}
			else{
				out.print("Not Updated!");
				request.getRequestDispatcher("user").include(request, response);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
