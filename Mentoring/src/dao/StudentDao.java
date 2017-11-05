package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.StudentBean;


public class StudentDao {
	public static Connection getConnection(){
		Connection con=null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mentor?autoReconnect=true&useSSL=false","root","root");
			}catch(Exception e) {e.printStackTrace();}
			return con;
		}
	public static boolean submitProblem(int studentId,int mentorId,String title,String description,String semester,String date) {
		boolean status = false;
		Connection con;
		PreparedStatement pst;
		String sql = "INSERT INTO `Mentor`.`StudentProblems` (`Id`, `Student_Id`, `Mentor_Id`,`Title`, `Description`, `Semester`, `Date`) VALUES (null, ?,?, ?, ?, ?, ?)";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, studentId);
			pst.setInt(2, mentorId);
			pst.setString(3, title);
			pst.setString(4, description);
			pst.setString(5, semester);
			pst.setString(6, date);
			pst.executeUpdate();
			status = true;
			con.close();
			pst.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	public static List<StudentBean> viewProblems(int studentId,int mentorId){
		List<StudentBean> problems = new ArrayList<StudentBean>();
		Connection con;
		PreparedStatement pst;
		String sql = "SELECT Id,Title FROM Mentor.StudentProblems where Student_Id = ? and Mentor_Id = ?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, studentId);
			pst.setInt(2, mentorId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setProblemId(rs.getInt("Id"));
				bean.setTitle(rs.getString("Title"));
				problems.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return problems;
	}
	public static StudentBean problemDetailById(int problemId) {
		StudentBean bean = new StudentBean();
		Connection con;
		PreparedStatement pst;
		String sql = "SELECT * FROM Mentor.StudentProblems where Id = ?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, problemId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				bean.setProblemId(rs.getInt("Id"));
				bean.setTitle(rs.getString("Title"));
				bean.setStudentId(rs.getInt("Student_Id"));
				bean.setDescription(rs.getString("Description"));
				bean.setSolution(rs.getString("Mentor_Solution"));
				bean.setSemester(rs.getString("Semester"));
				bean.setDate(rs.getString("Date"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	public static String studentNameById(int studentId) {
		String studentName = null;
		Connection con;
		PreparedStatement pst;
		String sql = "SELECT Name FROM Mentor.Student where SId = ?";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, studentId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				studentName = rs.getString("Name");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return studentName;
		
	}
	
}
