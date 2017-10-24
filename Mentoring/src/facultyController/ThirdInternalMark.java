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
 * Servlet implementation class ThirdInternalMark
 */
@WebServlet("/ThirdInternalMark")
public class ThirdInternalMark extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			
			int count=0,size;
			String Department,Semester,Year,SubjectCode;
			boolean Status = false;
			size = Integer.parseInt(request.getParameter("size"));//size of the array
			int[] StudentIds = new int[size];//array holding student Ids
			int[] StudentMarks = new int[size];//array holding student marks
			int[] DatabaseIds = new int[size];	
			SubjectCode = (String)session.getAttribute("SubCode");
			Department = (String) session.getAttribute("Department");
			Semester = (String) session.getAttribute("Semester");
			Year = (String) session.getAttribute("Year");
			
			List<FacultyBean> StudentList = (List<FacultyBean>)session.getAttribute("StudentList");
			try {
			for(FacultyBean bean : StudentList) {
				StudentIds[count] = bean.getStudentId();
				String parameter = Integer.toString(bean.getStudentId());
				StudentMarks[count] = Integer.parseInt(request.getParameter(parameter));
				count++;
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			List<FacultyBean> IdList = FacultyDao.getIdFromMarkingTable(StudentIds, SubjectCode, Department, Semester, Year);
			count=0;
			for(FacultyBean bean:IdList) {
				DatabaseIds[count] = bean.getId();
				count++;
			}
			Status = FacultyDao.thirdInternalMarkAssign(DatabaseIds, StudentMarks);
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
