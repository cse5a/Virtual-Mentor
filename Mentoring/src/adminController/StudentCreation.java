package adminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;


/**
 * Servlet implementation class StudentCreation
 */
@WebServlet("/StudentCreation")
public class StudentCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			Boolean Status=false;
			String name=request.getParameter("Name");
			String phoneNumber=request.getParameter("PhoneNumber");
			String email=request.getParameter("email");
			String gender=request.getParameter("Gender");
			String dob=request.getParameter("DOB");
			String department=request.getParameter("Department");
			String f_name=request.getParameter("Father_Name");
			String f_phoneNumber=request.getParameter("Father_PhoneNumber");
			String f_email=request.getParameter("Father_email");
			String m_name=request.getParameter("Mother_Name");
			String m_phoneNumber=request.getParameter("Mother_PhoneNumber");
			String m_email=request.getParameter("Mother_email");
			String at=request.getParameter("At");
			String post=request.getParameter("Post");
			String dist=request.getParameter("Dist");
			String pin=request.getParameter("Pin");
			String state=request.getParameter("State");
			String password=request.getParameter("Password");
			
			PrintWriter out=response.getWriter();
			Status = AdminDao.StudentCreation(name, phoneNumber, email,gender,dob, department,f_name,f_phoneNumber,f_email,m_name,m_phoneNumber,m_email, at, post, dist, pin, state, password);
			if(Status==true)
			{
				out.print("Registration successfull.");
				try {
					TimeUnit.SECONDS.sleep(6);
					//response.sendRedirect("AdminHome.jsp");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {
				// If error occurs during registration
				out.println("Registration fails");
				try {
					TimeUnit.SECONDS.sleep(6);
					//response.sendRedirect("AdminHome.jsp");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
