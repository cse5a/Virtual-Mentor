package facultyController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.FacultyBean;
import dao.FacultyDao;

/**
 * Servlet implementation class InitiationAttendanceSubmission
 */
@WebServlet("/InitiationAttendanceSubmission")
public class InitiationAttendanceSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			String Department,Semester,Year,Link;
			Department = (String) session.getAttribute("Department");
			Semester = (String) session.getAttribute("Semester");
			Year = (String) session.getAttribute("Year");
			Link = request.getParameter("link");
			
			List<FacultyBean> StudentList = FacultyDao.findStudentList(Department, Semester, Year);
			if(StudentList != null) {
				session.setAttribute("StudentList", StudentList);
				RequestDispatcher rsd = request.getRequestDispatcher("facultyPanel/"+Link);
				rsd.forward(request, response);
			}
			
		}else
			response.sendRedirect("../Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
