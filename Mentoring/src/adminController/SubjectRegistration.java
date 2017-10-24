package adminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;

/**
 * Servlet implementation class SubjectRegistration
 */
@WebServlet("/SubjectRegistration")
public class SubjectRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			String department,topic1,topic2,topic3,topic4,topic5,topic6,topic7,semester, year;
			boolean Status=false;
			department=request.getParameter("department");
			topic1=request.getParameter("topic1");
			topic2=request.getParameter("topic2");
			topic3=request.getParameter("topic3");
			topic4=request.getParameter("topic4");
			topic5=request.getParameter("topic5");
			topic6=request.getParameter("topic6");
			topic7=request.getParameter("topic7");
			semester=request.getParameter("semester");
			year=request.getParameter("year");
			Status=AdminDao.subjectRegistration(department, topic1, topic2, topic3, topic4, topic5, topic6, topic7, semester, year);
			if(Status == true)
				response.sendRedirect("adminPanel/SubjectRegistration.jsp");
			else
				response.sendRedirect("adminPanel/SubjectRegistration.jsp");
		}else
			response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
