package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import bean.MentorBean;
import bean.RemarkBean;
import bean.StudentBean;
import bean.UserInfo;

public class MentorDao {
	public static Connection getConnection(){
		Connection con=null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mentor?autoReconnect=true&useSSL=false","root","root");
				
				
			}catch(Exception e) {e.printStackTrace();}
			return con;
		}
	public static List<StudentBean> viewStudentProblems(int mentorId,String semester){
		List<StudentBean> problems = new ArrayList<StudentBean>();
		Connection con;
		PreparedStatement pst;
		String sql = "SELECT Id,Title,Student_Id,Mentor_Solution FROM Mentor.StudentProblems where Mentor_Id = ? and Semester=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, mentorId);
			pst.setString(2, semester);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setProblemId(rs.getInt("Id"));
				bean.setTitle(rs.getString("Title"));
				bean.setStudentId(rs.getInt("Student_Id"));
				rs.getString("Mentor_Solution");
				if(rs.wasNull()) {
					bean.setSolution("UNSOLVED");
					bean.setColor("red");
				}
					
				else {
					bean.setSolution("SOLVED");
					bean.setColor("green");
				}
				problems.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return problems;
	}
	public static boolean isMentor(int mentorId) {
		boolean isMentor = false;
		Connection con;
		PreparedStatement pst;
		String sql="SELECT FId FROM Mentor.Mentor where FId = ?";
		try{
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, mentorId);
			pst.executeQuery();
			isMentor = true;
			con.close();
			pst.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isMentor;
	}
	public static boolean giveSolutionByProblemId(int problemId,String solution) {
		boolean status = false;
		Connection con;
		PreparedStatement pst;
		String sql = "UPDATE `Mentor`.`StudentProblems` SET `Mentor_Solution`= ? WHERE `Id`=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, solution);
			pst.setInt(2, problemId);
			pst.executeUpdate();
			status = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static List<UserInfo> getStudentListByMentorId(int mentorId){
		List<UserInfo> studentList = new ArrayList<UserInfo>();
		Connection con =null;
		PreparedStatement pst = null;
		String sql="SELECT SId,Name FROM Mentor.Student where MentorId = ?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, mentorId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				UserInfo bean = new UserInfo();
				bean.setId(rs.getInt("SId"));
				bean.setName(rs.getString("Name"));
				studentList.add(bean);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studentList;
	}
	public static List<MentorBean> getInternalMarks(int studentId,String semester){
		List<MentorBean> markList = new ArrayList<MentorBean>();
		Connection con=null;
		PreparedStatement pst = null;
		String sql= "SELECT SubjectCode,FirstInternalSecuredMark,SecondInternalSecuredMark,ThirdInternalSecuredMark from Mentor.SubjectMark where StudentId =? and Semester = ?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, studentId);
			pst.setString(2, semester);
			ResultSet rst =pst.executeQuery();
			while(rst.next()) {
				MentorBean bean = new MentorBean();
				rst.getInt("FirstInternalSecuredMark");
				if (rst.wasNull())
					bean.setFirstInternalMark(0);
				else
				{
					bean.setSubjectCode(rst.getString(1));
					bean.setFirstInternalMark(rst.getInt(2));
				}
				rst.getInt("SecondInternalSecuredMark");
				if (rst.wasNull()) {
					bean.setSecondInternalMark(0);
				}
				else
					bean.setSecondInternalMark(rst.getInt(3));
				rst.getInt("ThirdInternalSecuredMark");
				if (rst.wasNull()) {
					bean.setThirdInternalMark(0);
				}
				else
					bean.setThirdInternalMark(rst.getInt(4));
				markList.add(bean);	
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return markList;
	}
	public static List<MentorBean> getSemesterMarks(int studentId,String semester){
		List<MentorBean> semesterMarks = new ArrayList<MentorBean>();
		Connection con=null;
		PreparedStatement pst = null;
		String sql= "SELECT SubjectCode,SemesterSecuredMark from Mentor.SubjectMark where StudentId =? and Semester = ?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, studentId);
			pst.setString(2, semester);
			ResultSet rst =pst.executeQuery();
			while(rst.next()) {
				MentorBean bean = new MentorBean();
				rst.getInt("SemesterSecuredMark");
				if (rst.wasNull())
					bean.setSemesterMark(0);
				else
					bean.setSemesterMark(rst.getInt(2));
					bean.setSubjectCode(rst.getString(1));
				semesterMarks.add(bean);	
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return semesterMarks;
	}
	public static List<MentorBean> getAttendance(int studentId,String semester){
		List<MentorBean> attendance = new ArrayList<MentorBean>();
		Connection con=null;
		PreparedStatement pst = null;
		String sql = "SELECT SubjectCode,FirstMonthTotalClass,FirstMonthTotalAttend,SecondMonthTotalClass,SecondMonthTotalAttend,ThirdMonthTotalClass,ThirdMonthTotalAttend FROM Mentor.ClassAttendance where StudentId = ? and Semester = ?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, studentId);
			pst.setString(2,semester);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				MentorBean bean = new MentorBean();
				bean.setSubjectCode(rst.getString("SubjectCode"));
				rst.getInt("FirstMonthTotalClass");
				if (rst.wasNull())
				{
					bean.setFirstMonthTotalAttended(0);
					bean.setFirstMonthTotalClass(0);
				}
				else
				{
					rst.getInt("FirstMonthTotalAttend");
					if(rst.wasNull())
						bean.setFirstMonthTotalAttended(0);
					else {
						bean.setFirstMonthTotalAttended(rst.getInt("FirstMonthTotalAttend"));
						bean.setFirstMonthTotalClass(rst.getInt("FirstMonthTotalClass"));
					}
				}
				rst.getInt("SecondMonthTotalClass");
				if (rst.wasNull())
				{
					bean.setSecondMonthTotalAttended(0);
					bean.setSecondMonthTotalClass(0);
				}
				else
				{
					rst.getInt("SecondMonthTotalAttend");
					if(rst.wasNull())
						bean.setSecondMonthTotalAttended(0);
					else {
						bean.setSecondMonthTotalAttended(rst.getInt("SecondMonthTotalAttend"));
						bean.setSecondMonthTotalClass(rst.getInt("SecondMonthTotalClass"));
					}
				}
				rst.getInt("ThirdMonthTotalClass");
				if (rst.wasNull())
				{
					bean.setThirdMonthTotalAttended(0);
					bean.setThirdMonthTotalClass(0);
				}
				else
				{
					rst.getInt("ThirdMonthTotalAttend");
					if(rst.wasNull())
						bean.setThirdMonthTotalAttended(0);
					else {
						bean.setThirdMonthTotalAttended(rst.getInt("ThirdMonthTotalAttend"));
						bean.setThirdMonthTotalClass(rst.getInt("ThirdMonthTotalClass"));
					}
				}
				attendance.add(bean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return attendance;
	}
	public static String getSubNameByCode(String subCode) {
		String subName = "";
		Connection con;
		PreparedStatement pst;
		String sql="SELECT SName FROM Mentor.Subject where SCode=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1,subCode);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				subName=rs.getString("SName");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return subName;
	}
	public static UserInfo getParentDetails(int studentId) {
		UserInfo parentDetails = new UserInfo();
		Connection con;
		PreparedStatement pst;
		String sql="SELECT Name,PhoneNumber,Email,Sex,FatherName,FNumber,FEmail,MotherName,MNumber,MEmail,District FROM Mentor.Student where SId = ?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, studentId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				parentDetails.setName(rs.getString(1));
				parentDetails.setNumber(rs.getString(2));
				parentDetails.setEmail(rs.getString(3));
				parentDetails.setSex(rs.getString(4));
				parentDetails.setF_name(rs.getString(5));
				parentDetails.setF_number(rs.getString(6));
				parentDetails.setF_email(rs.getString(7));
				parentDetails.setM_name(rs.getString(8));
				parentDetails.setM_number(rs.getString(9));
				parentDetails.setM_email(rs.getString(10));
				parentDetails.setCity(rs.getString(11));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return parentDetails;
	}
	
	public static boolean recordRemarks(int studentId,int mentorId,String guardian, String mentorRemark,String parentRemark,String semester,String date) {
		boolean status = false;
		Connection con;
		PreparedStatement pst;
		String sql="INSERT INTO `Mentor`.`Remarks` VALUES (null,?, ?,?, ?, ?, ?,?)";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, mentorId);
			pst.setInt(2, studentId);
			pst.setString(3, guardian);
			pst.setString(4, parentRemark);
			pst.setString(5, mentorRemark);
			pst.setString(6, semester);
			pst.setString(7, date);
			pst.executeUpdate();
			status = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
	}
	public static List<RemarkBean> fetchRemark(int studentId,int mentorId,String semester){
		List<RemarkBean> fetchRemarks = new ArrayList<RemarkBean>();
		Connection con;
		PreparedStatement pst;
		String sql = "SELECT Guardian,ParentRemark,MentorRemark,Date FROM Mentor.Remarks where MentorId = ? and StudentId = ? and Semester = ?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, mentorId);
			pst.setInt(2, studentId);
			pst.setString(3, semester);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				RemarkBean remark = new RemarkBean();
				remark.setGuardian(rs.getString(1));
				remark.setParentRemark(rs.getString(2));
				remark.setMentorRemark(rs.getString(3));
				remark.setDate(rs.getString(4));
				fetchRemarks.add(remark);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return fetchRemarks;
	}

}
