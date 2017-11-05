package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.FacultyBean;
import bean.UserBean;

public class FacultyDao {
	public static Connection getConnection(){
		Connection con=null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mentor?autoReconnect=true&useSSL=false","root","root");				
			}catch(Exception e) {e.printStackTrace();}
			return con;
		}
	public static List<UserBean> getSubjectCodeByFacultyId(int fId){
		List<UserBean> subCodeList = new ArrayList<UserBean>();
		Connection con;
		PreparedStatement pst = null ;
		String sql = "SELECT SCode,Department,Semester,AcademicYear FROM Mentor.SubjectAssign where FId=?";
		try {
			
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1,fId);
			ResultSet rs =pst.executeQuery();
			while(rs.next()) {
				UserBean bean = new UserBean();
				bean.setSubjectCode(rs.getString("SCode"));
				bean.setDepartment(rs.getString("Department"));
				bean.setSemester(rs.getString("Semester"));
				bean.setYear(rs.getString("AcademicYear"));
				subCodeList.add(bean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return subCodeList;
	}
	public static UserBean getSubNameByCode(String subCode) {
		UserBean subName = new UserBean();
		Connection con;
		PreparedStatement pst;
		String sql="SELECT SName,SCode FROM Mentor.Subject where SCode=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1,subCode);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				subName.setSubjectName(rs.getString("SName"));
				subName.setSubjectCode(rs.getString("SCode"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return subName;
	}
	public static List<FacultyBean> findStudentList(String Department,String Semester,String AcademicYear) {
		List<FacultyBean> studentList = new ArrayList<FacultyBean>();
		Connection con;
		PreparedStatement pst;
		String sql="SELECT StudentId FROM Mentor.SemesterCategorization where (Department=?) and (Semester=?) and (Year=?)";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, Department);
			pst.setString(2, Semester);
			pst.setString(3, AcademicYear);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				FacultyBean bean = new FacultyBean();
				bean.setStudentId(rs.getInt("StudentId"));
				studentList.add(bean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}
	public static boolean firstInternalMarkAssign(int[] StudentId,String SubjectCode,int InternalFullMark,int[] InternalSecuredMark,String Department,String Semester,String Year) {
		Connection con;
		PreparedStatement pst;
		boolean Status = false;
		String sql="INSERT INTO `Mentor`.`SubjectMark` (`Id`, `StudentId`, `SubjectCode`, `InternaFullMark`, `FirstInternalSecuredMark`, `Department`, `Semester`, `AcademicYear`) VALUES (null,?,?,?,?,?,?,?)";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(2, SubjectCode);
			pst.setInt(3, InternalFullMark);
			pst.setString(5,Department);
			pst.setString(6, Semester);
			pst.setString(7, Year);
			con.setAutoCommit(false);
			for(int i=0;i<StudentId.length;i++) {
				pst.setInt(1, StudentId[i]);
				pst.setInt(4, InternalSecuredMark[i]);
				pst.executeUpdate();
			}
			con.commit();
			Status = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static boolean secondInternalMarkAssign(int[] Ids,int[] SecondInternalMarks) {
		boolean Status = false;
		PreparedStatement pst;
		Connection con;
		String sql="update Mentor.SubjectMark set SecondInternalSecuredMark=? where Id=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			con.setAutoCommit(false);
			for(int i=0; i < SecondInternalMarks.length; i++) {
				pst.setInt(1, SecondInternalMarks[i]);
				pst.setInt(2, Ids[i]);
				pst.executeUpdate();
			}
			con.commit();
			Status = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static boolean thirdInternalMarkAssign(int[] Ids,int[] ThirdInternalMarks) {
		boolean Status = false;
		PreparedStatement pst;
		Connection con;
		String sql="update Mentor.SubjectMark set ThirdInternalSecuredMark=? where Id=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			con.setAutoCommit(false);
			for(int i=0; i < ThirdInternalMarks.length; i++) {
				pst.setInt(1, ThirdInternalMarks[i]);
				pst.setInt(2, Ids[i]);
				pst.executeUpdate();
			}
			con.commit();
			Status = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static boolean semesterMarkAssign(int[] Ids,int[] SemesterSecuredMarks,int SemesterFullMark) {
		boolean Status = false;
		PreparedStatement pst;
		Connection con;
		String sql="update Mentor.SubjectMark set SemesterFullMark=?,SemesterSecuredMark=? where Id=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			con.setAutoCommit(false);
			pst.setInt(1, SemesterFullMark);
			for(int i=0; i < SemesterSecuredMarks.length; i++) {
				pst.setInt(2, SemesterSecuredMarks[i]);
				pst.setInt(3, Ids[i]);
				pst.executeUpdate();
			}
			con.commit();
			Status = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static List<FacultyBean> getIdFromMarkingTable(int[] StudentId,String SubjectCode,String Department,String Semester,String Year) {
		List<FacultyBean> IdList = new ArrayList<FacultyBean>();
		PreparedStatement pst;
		Connection con;
		String sql="SELECT Id,StudentId FROM Mentor.SubjectMark where StudentId=? and SubjectCode=? and Department=? and Semester=? and AcademicYear=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(2, SubjectCode);
			pst.setString(3,Department);
			pst.setString(4, Semester);
			pst.setString(5, Year);
			for(int i=0;i<StudentId.length;i++) {
				pst.setInt(1, StudentId[i]);
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					FacultyBean bean = new FacultyBean();
					bean.setId(rs.getInt(1));
					bean.setStudentId(2);
					IdList.add(bean);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return IdList;
	}
	public static List<FacultyBean> getIdFromAttendanceTable(int[] StudentId,String SubjectCode,String Department,String Semester,String Year) {
		List<FacultyBean> IdList = new ArrayList<FacultyBean>();
		PreparedStatement pst;
		Connection con;
		String sql="SELECT Id FROM Mentor.ClassAttendance where StudentId=? and SubjectCode=? and Department=? and Semester=? and AcademicYear=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(2, SubjectCode);
			pst.setString(3,Department);
			pst.setString(4, Semester);
			pst.setString(5, Year);
			for(int i=0;i<StudentId.length;i++) {
				pst.setInt(1, StudentId[i]);
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					FacultyBean bean = new FacultyBean();
					bean.setId(rs.getInt(1));
					IdList.add(bean);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return IdList;
	}
	public static boolean firstMonthAttendanceSubmission(int[] StudentId,String SubjectCode,int totalClasses,int[] StudentAttendance,String Department,String Semester,String Year) {
		Connection con;
		PreparedStatement pst;
		boolean Status = false;
		String sql="INSERT INTO `Mentor`.`ClassAttendance` (`Id`, `StudentId`, `SubjectCode`, `FirstMonthTotalClass`, `FirstMonthTotalAttend`, `Department`, `Semester`, `AcademicYear`) VALUES (null,?,?,?,?,?,?,?)";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(2, SubjectCode);
			pst.setInt(3, totalClasses);
			pst.setString(5,Department);
			pst.setString(6, Semester);
			pst.setString(7, Year);
			con.setAutoCommit(false);
			for(int i=0;i<StudentId.length;i++) {
				pst.setInt(1, StudentId[i]);
				pst.setInt(4, StudentAttendance[i]);
				pst.executeUpdate();
			}
			con.commit();
			Status = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static boolean secondMonthAttendanceSubmission(int[] Ids,int[] StudentAttendance,int totalClasses) {
		boolean Status = false;
		PreparedStatement pst;
		Connection con;
		String sql="update Mentor.ClassAttendance set SecondMonthTotalClass=?,SecondMonthTotalAttend=? where Id=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			con.setAutoCommit(false);
			pst.setInt(1, totalClasses);
			for(int i=0; i < StudentAttendance.length; i++) {
				pst.setInt(2, StudentAttendance[i]);
				pst.setInt(3, Ids[i]);
				pst.executeUpdate();
			}
			con.commit();
			Status = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static boolean thirdMonthAttendanceSubmission(int[] Ids,int[] StudentAttendance,int totalClasses) {
		boolean Status = false;
		PreparedStatement pst;
		Connection con;
		String sql="update Mentor.ClassAttendance set ThirdMonthTotalClass=?,ThirdMonthTotalAttend=? where Id=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			con.setAutoCommit(false);
			pst.setInt(1, totalClasses);
			for(int i=0; i < StudentAttendance.length; i++) {
				pst.setInt(2, StudentAttendance[i]);
				pst.setInt(3, Ids[i]);
				pst.executeUpdate();
			}
			con.commit();
			Status = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static boolean assignFirstMonthDisciplinaryReport(int[] StudentId,String SubjectCode,String[] DisciplinaryStatus,int[] DisciplinaryRating,String Department,String Semester,String Year) {
		boolean Status = false;
		Connection con;
		PreparedStatement pst;
		String sql;
		try {
			con = getConnection();
			sql="INSERT INTO `Mentor`.`DisciplinaryStatus` (`Id`, `StudentId`, `SubjectCode`, `FirstInternalStatus`, `FirstInternalRating`, `Department`, `Semester`, `Year`) VALUES (null,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(2, SubjectCode);
			pst.setString(5,Department);
			pst.setString(6, Semester);
			pst.setString(7, Year);
			con.setAutoCommit(false);
			for(int i=0;i<StudentId.length;i++) {
				pst.setInt(1, StudentId[i]);
				pst.setString(3, DisciplinaryStatus[i]);
				pst.setInt(4, DisciplinaryRating[i]);
				pst.executeUpdate();
			}
			con.commit();
			Status = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static boolean assignSecondMonthDisciplinaryReport(int[] Ids,String[] DisciplinaryStatus,int[] DisciplinaryRating) {
		boolean Status = false;
		PreparedStatement pst;
		Connection con;
		String sql="update Mentor.DisciplinaryStatus set SecondInternalStatus=?,SecondInternalRating=? where Id=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			con.setAutoCommit(false);
			for(int i=0; i < DisciplinaryStatus.length; i++) {
				pst.setString(1, DisciplinaryStatus[i]);
				pst.setInt(2, DisciplinaryRating[i]);
				pst.setInt(3, Ids[i]);
				pst.executeUpdate();
			}
			con.commit();
			Status = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static boolean assignThirdMonthDisciplinaryReport(int[] Ids,String[] DisciplinaryStatus,int[] DisciplinaryRating) {
		boolean Status = false;
		PreparedStatement pst;
		Connection con;
		String sql="update Mentor.DisciplinaryStatus set ThirdInternalStatus=?,ThirdInternalRating=? where Id=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			con.setAutoCommit(false);
			for(int i=0; i < DisciplinaryStatus.length; i++) {
				pst.setString(1, DisciplinaryStatus[i]);
				pst.setInt(2, DisciplinaryRating[i]);
				pst.setInt(3, Ids[i]);
				pst.executeUpdate();
			}
			con.commit();
			Status = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static List<FacultyBean> getIdFromDisciplinaryStatusTable(int[] StudentId,String SubjectCode,String Department,String Semester,String Year) {
		List<FacultyBean> IdList = new ArrayList<FacultyBean>();
		PreparedStatement pst;
		Connection con;
		String sql="SELECT Id FROM Mentor.DisciplinaryStatus where StudentId=? and SubjectCode=? and Department=? and Semester=? and Year=?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(2, SubjectCode);
			pst.setString(3,Department);
			pst.setString(4, Semester);
			pst.setString(5, Year);
			for(int i=0;i<StudentId.length;i++) {
				pst.setInt(1, StudentId[i]);
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					FacultyBean bean = new FacultyBean();
					bean.setId(rs.getInt(1));
					IdList.add(bean);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return IdList;
	}
}



















