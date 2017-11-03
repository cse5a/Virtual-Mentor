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
 * Servlet implementation class FacultyAssign
 */
@WebServlet("/FacultyAssign")
public class FacultyAssign extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			
			String subjectCode,department,semester,year;
			int facultyId;
			boolean Status = false;
			facultyId = Integer.parseInt(request.getParameter("facultyId"));
			subjectCode = request.getParameter("subjectCode");
			department = request.getParameter("department");
			semester = request.getParameter("semester");
			year = request.getParameter("year");
			Status = AdminDao.facultyAssign(subjectCode, facultyId,department, semester, year);
			if(Status == true)
				response.sendRedirect("FacultyAssignInitiation");
			else
				response.sendRedirect("FacultyAssignInitiation");
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
