package adminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import bean.UserInfo;
import dao.AdminDao;

/**
 * Servlet implementation class FacultyAssignInitiation
 */
@WebServlet("/FacultyAssignInitiation")
public class FacultyAssignInitiation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rsd;
		if(session.getAttribute("USERAUTH") != null) {
			List<UserInfo> facultyList = AdminDao.facultyList();
			List<UserBean> subjectList = AdminDao.getSubjectList();
			request.setAttribute("facultyList", facultyList);
			request.setAttribute("subjectList", subjectList);
			rsd = request.getRequestDispatcher("FacultyAssign.jsp");
			rsd.forward(request, response);
			
		}else
			response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
