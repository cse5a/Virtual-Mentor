package mentorController;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.MentorDao;

/**
 * Servlet implementation class RecordRemark
 */
@WebServlet("/RecordRemark")
public class RecordRemark extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("USERAUTH") != null) {
			String semester,mentorRemark,parentRemark,date,guardian;
			boolean status;
			int mentorId = Integer.parseInt(request.getParameter("mentorId"));
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			semester = request.getParameter("semester");
			mentorRemark = request.getParameter("mentorRemark");
			parentRemark = request.getParameter("parentRemark");
			guardian = request.getParameter("Guardian");
			Date time = new Date();
			final DateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = timeFormat.format(time);// current date
			// end
			status = MentorDao.recordRemarks(studentId, mentorId,guardian, mentorRemark, parentRemark, semester,date);
			if(status == true) {
				RequestDispatcher rsd = request.getRequestDispatcher("ContactParents?studentId="+studentId+"&error=1");
				rsd.forward(request, response);
			}
			else {
				RequestDispatcher rsd = request.getRequestDispatcher("ContactParents?studentId="+studentId+"&error=0");
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
