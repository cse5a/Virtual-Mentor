package adminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import dao.AdminDao;

/**
 * Servlet implementation class FacultyCreation
 */
@WebServlet("/FacultyCreation")
public class FacultyCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyCreation() {
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
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			Boolean Status=false;
			String name=request.getParameter("Name");
			String phoneNumber=request.getParameter("PhoneNumber");
			String email=request.getParameter("email");
			String department=request.getParameter("Department");
			String at=request.getParameter("At");
			String post=request.getParameter("Post");
			String dist=request.getParameter("Dist");
			String pin=request.getParameter("Pin");
			String state=request.getParameter("State");
			String password=request.getParameter("Password");
			String gender=request.getParameter("Gender");
			PrintWriter out=response.getWriter();
			Status = AdminDao.FacultyCreation(name, phoneNumber, email, department, at, post, dist, pin, state, password, gender);
			if(Status==true)
			{
				out.print("Registration successfull.");
				
			}
			else {
				// Here i need to write the code
				out.println("Registration fails");
			}
		}
		
		doGet(request, response);
	}

}
