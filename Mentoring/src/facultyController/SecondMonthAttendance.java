package facultyController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.FacultyBean;
import dao.FacultyDao;

/**
 * Servlet implementation class SecondMonthAttendance
 */
@WebServlet("/SecondMonthAttendance")
public class SecondMonthAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			int count=0,totalClasses,size;
			boolean Status = false;
			size = Integer.parseInt(request.getParameter("size"));
			int[] StudentIds = new int[size];
			int[] StudentAttendance = new int[size];
			int[] DatabaseIds = new int[size];
			totalClasses = Integer.parseInt(request.getParameter("totalClasses"));
			List<FacultyBean> StudentList = (List<FacultyBean>)session.getAttribute("StudentList");
			String Department,Semester,Year,SubjectCode;
			SubjectCode = (String)session.getAttribute("SubCode");
			Department = (String) session.getAttribute("Department");
			Semester = (String) session.getAttribute("Semester");
			Year = (String) session.getAttribute("Year");
			try {
			for(FacultyBean bean : StudentList) {
				StudentIds[count] = bean.getStudentId();
				String parameter = Integer.toString(bean.getStudentId());
				StudentAttendance[count] = Integer.parseInt(request.getParameter(parameter));
				count++;
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			List<FacultyBean> IdList = FacultyDao.getIdFromAttendanceTable(StudentIds, SubjectCode, Department, Semester, Year);
			count=0;
			for(FacultyBean bean:IdList) {
				System.out.println(count);
				DatabaseIds[count++] = bean.getId();
			}
			Status = FacultyDao.secondMonthAttendanceSubmission(DatabaseIds, StudentAttendance, totalClasses);
			if(Status == true)
				response.getWriter().println("Successful");
			else
				response.getWriter().println("Unsuccessful");
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
