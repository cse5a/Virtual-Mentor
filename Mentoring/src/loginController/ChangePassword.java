package loginController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.UserInfo;
import dao.AdminDao;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("USERAUTH") != null) {
			String oldPassword,newPassword,confirmPassword;
			oldPassword = request.getParameter("oldPassword");
			newPassword = request.getParameter("newPassword");
			confirmPassword = request.getParameter("confirmPassword");
			int status = 0;
			if(newPassword.equals(confirmPassword)) {
				UserInfo userInfo = (UserInfo)request.getSession().getAttribute("USERINFO");
				int userId = userInfo.getId();
				status = AdminDao.changePassword(userId, oldPassword, newPassword);
			}
			
			if(status == 1) {
				RequestDispatcher rsd=request.getRequestDispatcher("ChangePassword.jsp?error=1");
				rsd.forward(request, response);
			}
			else {
				RequestDispatcher rsd=request.getRequestDispatcher("ChangePassword.jsp?error=0");
				rsd.forward(request, response);
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
