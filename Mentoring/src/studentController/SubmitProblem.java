package studentController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfo;
import dao.StudentDao;

/**
 * Servlet implementation class SubmitProblem
 */
@WebServlet("/SubmitProblem")
public class SubmitProblem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("USERAUTH") != null) {
			UserInfo student = (UserInfo)session.getAttribute("USERINFO");
			int studentId,mentorId;
			String title,description,semester,date;
			boolean status = false;
			studentId = student.getId();
			mentorId = student.getMentorId();
			title = request.getParameter("title");
			description = request.getParameter("description");
			semester = request.getParameter("semester");
			date = request.getParameter("date");
			status = StudentDao.submitProblem(studentId, mentorId,title, description, semester, date);
			if(status == true) {
				RequestDispatcher rsd=request.getRequestDispatcher("studentPanel/ShareProblems.jsp");
				rsd.forward(request, response);
			}
			else {
				response.sendRedirect("studentPanel/ShareProblems.jsp");
			}
			
		}
		else
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
