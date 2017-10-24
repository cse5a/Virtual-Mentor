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
import dao.AdminDao;

//import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("Password");
		UserBean bean = AdminDao.login(id,password);
		if (bean != null ) {
			HttpSession session = request.getSession();
			session.setAttribute("USERAUTH", bean);
			
			RequestDispatcher rd = request.getRequestDispatcher("SessionController");
			rd.forward(request, response);
		} else {
			response.sendRedirect("Login.jsp");
			response.getWriter().println("<h4 style=\"color:red;\">Wrong password</h4>");
		}
	}

}
