package mentorController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MentorDao;

/**
 * Servlet implementation class ProvideSolution
 */
@WebServlet("/ProvideSolution")
public class ProvideSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("USERAUTH") != null) {
			String solution;
			int problemId;
			boolean status = false;
			problemId = Integer.parseInt(request.getParameter("problemId"));
			System.out.println(problemId);
			solution = request.getParameter("solution");
			status = MentorDao.giveSolutionByProblemId(problemId, solution);
			if(status == true) {
				response.sendRedirect("mentorPanel/ViewStudentProblems.jsp");
			}
			else {
				RequestDispatcher rsd=request.getRequestDispatcher("");
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
