package adminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;

/**
 * Servlet implementation class AssignSemester
 */
@WebServlet("/AssignSemester")
public class AssignSemester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignSemester() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("USERAUTH") != null) {
			String department,semester,year;
			int firstStudentId,lastStudentId,i=0;
			boolean status = false;
			firstStudentId = Integer.parseInt(request.getParameter("FirstStudentId"));
			lastStudentId = Integer.parseInt(request.getParameter("LastStudentId"));
			department = request.getParameter("Department");
			semester = request.getParameter("Semester");
			year = request.getParameter("AcademicYear");
			for(i =firstStudentId;i<=lastStudentId ; ) {
				status = AdminDao.assignSemester(i, department, semester, year);
				if(status == true)
					i++;
				else
					break;
			}
			 if(i >= lastStudentId) {
				 RequestDispatcher rsd = request.getRequestDispatcher("adminPanel/AssignSemester.jsp");
				 rsd.forward(request, response);
			 }
			 else {
				 RequestDispatcher rsd = request.getRequestDispatcher("adminPanel/AssignSemester.jsp");
				 rsd.forward(request, response);
			 }
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
