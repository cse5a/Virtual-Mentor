package mentorController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StudentBean;
import bean.UserInfo;
import dao.MentorDao;

/**
 * Servlet implementation class ViewStudentProblems
 */
@WebServlet("/ViewStudentProblems")
public class ViewStudentProblems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("USERAUTH") != null) {
			UserInfo faculty = (UserInfo)session.getAttribute("USERINFO");
			int mentorId;
			mentorId = faculty.getId();
			List<StudentBean> problems = MentorDao.viewStudentProblems(mentorId);
			request.setAttribute("problems", problems);
			RequestDispatcher rsd=request.getRequestDispatcher("mentorPanel/ViewStudentProblems.jsp");
			rsd.forward(request, response);
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
