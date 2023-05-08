

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Medicine;
import model.MedicineDao;
import model.UserDao;


@WebServlet("/medicineform")
public class MedicineForm extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String MedicineName = request.getParameter("medicineName");
		String CompanyName = request.getParameter("companyName");
		String Quantity = request.getParameter("quantity");

		out.print(MedicineName);
		System.out.println(Quantity);


		Medicine m =new Medicine(MedicineName,CompanyName,Quantity);


		int m1 =0;

		try {
			m1 =new MedicineDao().insert(m);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(m1>0){
			out.print("user Register !");
			request.getRequestDispatcher("medicine").include(request, response);
			

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
