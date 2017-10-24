package facultyController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubjectMarkingCategory
 */
@WebServlet("/SubjectMarkingCategory")
public class SubjectMarkingCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			session.setAttribute("SubCode", request.getParameter("SCode"));
			session.setAttribute("SubName", request.getParameter("SName"));
			session.setAttribute("Department", request.getParameter("Department"));
			session.setAttribute("Semester", request.getParameter("Semester"));
			session.setAttribute("Year", request.getParameter("Year"));
			
			RequestDispatcher rsd = request.getRequestDispatcher("facultyPanel/SubjectMarkingCategory.jsp");
			rsd.forward(request, response);
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
