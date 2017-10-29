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
			StringBuilder performance = new StringBuilder("");
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
				performance.append(gson.toJson(internalSubjectMarks));
				
			}
			else if(option.equals("internalPerformance")) {
				List<MentorBean> internalMarks = MentorDao.getInternalMarks(studentId, semester);
				
				String firstInternalMarks = "",secondInternalMarks ="",thirdInternalMarks ="",subjectNames ="";
				for(MentorBean bean : internalMarks) {
					if(subjectNames.equals(""))
						subjectNames = "\""+ MentorDao.getSubNameByCode(bean.getSubjectCode()) +"\"";
					else
						subjectNames = subjectNames +",\""+ MentorDao.getSubNameByCode(bean.getSubjectCode()) +"\"";
					if(firstInternalMarks.equals(""))
						firstInternalMarks = "\""+ bean.getFirstInternalMark() +"\"";
					else
						firstInternalMarks = firstInternalMarks +",\""+ bean.getFirstInternalMark() +"\"";
					if(secondInternalMarks.equals(""))
						secondInternalMarks = "\""+ bean.getSecondInternalMark()+"\"";
					else
						secondInternalMarks = secondInternalMarks +",\""+ bean.getSecondInternalMark();
					if(thirdInternalMarks.equals(""))
						thirdInternalMarks = "\""+ bean.getThirdInternalMark() +"\"";
					else
						thirdInternalMarks = thirdInternalMarks +",\""+ bean.getThirdInternalMark()+"\"";
				}
				MentorBean jsonBean = new MentorBean();
				jsonBean.setJsonfirstInternalMark(firstInternalMarks);
				jsonBean.setJsonsecondInternalMark(secondInternalMarks);
				jsonBean.setJsonthirdInternalMark(thirdInternalMarks);
				jsonBean.setJsonSubjectNames(subjectNames);
				Gson gson = new Gson();
				performance.append(gson.toJson(jsonBean));
				
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
					System.out.println(totalClasses +" "+totalAttendedClasses +" "+attendanceInPercentage);
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
