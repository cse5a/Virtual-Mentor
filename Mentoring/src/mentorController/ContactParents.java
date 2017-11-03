package mentorController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfo;
import dao.MentorDao;

/**
 * Servlet implementation class ContactParents
 */
@WebServlet("/ContactParents")
public class ContactParents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("USERAUTH") != null) {
			String error = request.getParameter("error");
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			UserInfo studentParentInfo = MentorDao.getParentDetails(studentId);
			studentParentInfo.setId(studentId);
			request.setAttribute("studentParentInfo", studentParentInfo);
			RequestDispatcher rsd = request.getRequestDispatcher("mentorPanel/ContactParents.jsp?error="+error);
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
