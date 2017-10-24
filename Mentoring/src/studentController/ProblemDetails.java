package studentController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StudentBean;
import bean.UserInfo;
import dao.StudentDao;

/**
 * Servlet implementation class ProblemDetails
 */
@WebServlet("/ProblemDetails")
public class ProblemDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			int userId,problemId;
			problemId = Integer.parseInt(request.getParameter("Id"));
			UserInfo userInfo = (UserInfo)session.getAttribute("USERINFO");
			userId = userInfo.getId();
			StudentBean problemDetail = StudentDao.problemDetailById(problemId);
			RequestDispatcher rsd = null;
			if (userId >= 1000 && userId < 10000) {
				problemDetail.setStudentName(StudentDao.studentNameById(problemDetail.getStudentId()));
				rsd = request.getRequestDispatcher("mentorPanel/StudentProblemDetails.jsp");
			} else {
				rsd =request.getRequestDispatcher("studentPanel/ProblemDetails.jsp");
			}
			request.setAttribute("problemDetail", problemDetail);
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
