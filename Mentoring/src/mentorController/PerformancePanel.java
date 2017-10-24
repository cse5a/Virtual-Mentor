package mentorController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MentorBean;
import dao.MentorDao;
import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class PerformancePanel
 */
@WebServlet("/PerformancePanel")
public class PerformancePanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null)
		{
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			String semester = request.getParameter("semester");
			String option = request.getParameter("option");
			String performance = null;
			//System.out.println(""+semester+""+option+""+studentId+"");
			if(option.equals("internalMarks") )
			{
				
				List<MentorBean> internalMarks = MentorDao.getInternalMarks(studentId, semester);
				List<MentorBean> internalSubjectMarks = new ArrayList<MentorBean>();
				for(MentorBean bean : internalMarks) {
					String subjectName = MentorDao.getSubNameByCode(bean.getSubjectCode());
					bean.getFirstInternalMark();
					bean.getSecondInternalMark();
					bean.getThirdInternalMark();
					bean.setSubjectName(subjectName);
					internalSubjectMarks.add(bean);
				}
				Gson gson = new Gson();
				performance = gson.toJson(internalSubjectMarks);
			}
			else if(option.equals("internalPerformance")) {
				List<MentorBean> internalMarks = MentorDao.getInternalMarks(studentId, semester);
				
				String firstInternalMarks = "",secondInternalMarks ="",thirdInternalMarks ="",subjectNames ="";
				for(MentorBean bean : internalMarks) {
					subjectNames = subjectNames +","+ MentorDao.getSubNameByCode(bean.getSubjectCode());
					firstInternalMarks = firstInternalMarks +","+ bean.getFirstInternalMark();
					secondInternalMarks = secondInternalMarks +","+ bean.getSecondInternalMark();
					thirdInternalMarks = thirdInternalMarks +","+ bean.getThirdInternalMark();
				}
				MentorBean jsonBean = new MentorBean();
				jsonBean.setJsonfirstInternalMark(firstInternalMarks);
				jsonBean.setJsonsecondInternalMark(secondInternalMarks);
				jsonBean.setJsonthirdInternalMark(thirdInternalMarks);
				jsonBean.setJsonSubjectNames(subjectNames);
				Gson gson = new Gson();
				performance = gson.toJson(jsonBean);
			}
			else if(option.equals("semesterMarks")) {
				List<MentorBean> semesterMarks = MentorDao.getInternalMarks(studentId, semester);
				List<MentorBean> semesterSubjectMarks = new ArrayList<MentorBean>();
				for(MentorBean bean : semesterMarks) {
					String subjectName = MentorDao.getSubNameByCode(bean.getSubjectCode());
					bean.getSemesterMark();
					bean.setSubjectName(subjectName);
					semesterSubjectMarks.add(bean);
				}
				Gson gson = new Gson();
				performance = gson.toJson(semesterSubjectMarks);
			}
			else if(option.equals("semesterPerformance")) {
				
			}
			else if(option.equals("attendance")) {
				
			}
			response.getWriter().append(performance);
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