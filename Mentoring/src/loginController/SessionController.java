package loginController;

import java.io.IOException;

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
 * Servlet implementation class SessionController
 */
@WebServlet("/SessionController")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		RequestDispatcher rd = null;
		if (session.getAttribute("USERAUTH") != null) {
			UserBean bean = (UserBean) session.getAttribute("USERAUTH");
			int uId = bean.getS_id();
			UserInfo user;
			
			if (uId >= 100 && uId < 1000) {
				user = AdminDao.getAdminInfoById(uId);
				session.setAttribute("USERINFO", user);
				rd = request.getRequestDispatcher("adminPanel/AdminDashboard.jsp");
			} else if (uId >= 1000 && uId < 10000) {
				user = AdminDao.facultyProfile(uId);
				session.setAttribute("USERINFO", user);
				rd = request.getRequestDispatcher("facultyPanel/FacultyDashboard.jsp");
			} else {
				user = AdminDao.getStudentById(uId);
				session.setAttribute("USERINFO", user);
				rd = request.getRequestDispatcher("studentPanel/StudentDashboard.jsp");
			}
			
		} else
			rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
