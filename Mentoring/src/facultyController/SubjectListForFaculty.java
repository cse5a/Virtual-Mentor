package facultyController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.FacultyDao;

/**
 * Servlet implementation class SubjectListForFaculty
 */
@WebServlet("/SubjectListForFaculty")
public class SubjectListForFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectListForFaculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			int option = Integer.parseInt(request.getParameter("option"));
			List<UserBean> subNameList = new ArrayList<UserBean>() ;
			UserBean user = (UserBean)session.getAttribute("USERAUTH");
			List<UserBean> subCodeList = FacultyDao.getSubjectCodeByFacultyId(user.getS_id());
			try {
			for(UserBean bean : subCodeList) {
				String subCode = bean.getSubjectCode();
				UserBean subName = FacultyDao.getSubNameByCode(subCode);
				subName.setDepartment(bean.getDepartment());
				subName.setSemester(bean.getSemester());
				subName.setYear(bean.getYear());
				subName.setSubjectCode(subCode);
				subNameList.add(subName);
			}
			
			request.setAttribute("subNameList", subNameList);
			RequestDispatcher rsd = request.getRequestDispatcher("facultyPanel/SubjectList.jsp?option="+option+"");
			rsd.forward(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
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
