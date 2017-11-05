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
import bean.RemarkBean;
import bean.UserBean;
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
		UserBean user =(UserBean)session.getAttribute("USERAUTH");
		if(user != null)
		{	
			int mentorId = user.getS_id();
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			String semester = request.getParameter("semester");
			String option = request.getParameter("option");
			StringBuilder performance = new StringBuilder("");
			
			if(option.equals("internalMarks") || option.equals("internalPerformance"))
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
				performance.append(gson.toJson(internalSubjectMarks));
				
			}
			
			else if(option.equals("semesterMarks")) {
				List<MentorBean> semesterMarks = MentorDao.getSemesterMarks(studentId, semester);
				List<MentorBean> semesterSubjectMarks = new ArrayList<MentorBean>();
				for(MentorBean bean : semesterMarks) {
					String subjectName = MentorDao.getSubNameByCode(bean.getSubjectCode());
					bean.getSemesterMark();
					bean.setSubjectName(subjectName);
					semesterSubjectMarks.add(bean);
				}
				Gson gson = new Gson();
				performance.append(gson.toJson(semesterSubjectMarks));
			}
			else if(option.equals("attendance")) {
				List<MentorBean> attendance = MentorDao.getAttendance(studentId, semester);
				List<MentorBean> updatedAttendance = new ArrayList<MentorBean>();
				for(MentorBean bean : attendance) {
					int totalClasses,totalAttendedClasses,attendanceInPercentage;
					String subjectName = MentorDao.getSubNameByCode(bean.getSubjectCode());
					totalClasses = bean.getFirstMonthTotalClass() + bean.getSecondMonthTotalClass() + bean.getThirdMonthTotalClass();
					totalAttendedClasses = bean.getFirstMonthTotalAttended() + bean.getSecondMonthTotalAttended() + bean.getThirdMonthTotalAttended();
					if(totalClasses == 0 || totalAttendedClasses == 0) {
						attendanceInPercentage = 0;
					}
					else
						attendanceInPercentage = (int) (((float)totalAttendedClasses / totalClasses) * 100);
					if(attendanceInPercentage >= 75)
						bean.setColor("#008000");
					else if(attendanceInPercentage < 75 && attendanceInPercentage >= 40)
						bean.setColor("#FFA500");
					else if(attendanceInPercentage < 40)
						bean.setColor("#FF0000");
					bean.setAttendanceInPercentage(attendanceInPercentage);
					bean.setSubjectName(subjectName);
					updatedAttendance.add(bean);
				}
				Gson gson = new Gson();
				performance.append(gson.toJson(updatedAttendance));
				
			}
			else if(option.equals("fetchRemarks")) {
				System.out.println("hello");
				List<RemarkBean> fetchRemarks = MentorDao.fetchRemark(studentId, mentorId, semester); 
				Gson gson = new Gson();
				System.out.println(fetchRemarks);
				performance.append(gson.toJson(fetchRemarks));
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
