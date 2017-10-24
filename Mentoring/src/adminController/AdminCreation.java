package adminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import java.io.PrintWriter;

/**
 * Servlet implementation class AdminCreation
 */
@WebServlet("/AdminCreation")
public class AdminCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Boolean Status=false;
		PrintWriter out=response.getWriter();
		String name=request.getParameter("Name");
		String password=request.getParameter("Password");
		String gender=request.getParameter("Gender");
		String phoneNumber=request.getParameter("PhoneNumber");
		String email=request.getParameter("email");
		String city=request.getParameter("At");
		String state=request.getParameter("State");
		Status=AdminDao.AdminCreation(name, password, gender, phoneNumber, email, city, state);
		if(Status==true) {
			out.println("Admin Creation sucessful.");
		}
		else
			out.println("There is an error");
		doGet(request, response);
	}

}
