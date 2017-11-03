package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import bean.UserBean;
import bean.UserInfo;

public class AdminDao {
	public static Connection getConnection(){
		Connection con=null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mentor?autoReconnect=true&useSSL=false","root","root");
				
				
			}catch(Exception e) {e.printStackTrace();}
			return con;
		}
	public static UserBean login(int id, String pass) {
		UserBean bean= null;
		try {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("SELECT * FROM Mentor.MasterTable where uid=? and password=MD5(?)");
			pst.setInt(1, id);
			pst.setString(2, pass);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				bean = new UserBean();
				bean.setMid(rs.getInt("MID"));
				bean.setS_id(rs.getInt("UID"));
			}
		}catch(Exception e) {e.printStackTrace();}
		
		return bean;
	}
	public static int changePassword(int userId,String oldPassword, String newPassword) {
		Connection con = null;
		PreparedStatement pst = null;
		int flag = 0;
		String sql = "update Mentor.MasterTable set Password=md5(?) where UId =? and Password=md5(?)";
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, newPassword);
			pst.setInt(2, userId);
			pst.setString(3, oldPassword);
			flag = pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean AdminCreation(String name,String password,String gender,String phoneNumber,String email,String city,String state) {
			boolean Status=false;
			//Admin creation code
			CallableStatement callst=null;
			Connection con=getConnection();
			try {
				
				String sql="call AdminCreation(?,?,?,?,?,?,?)";
				callst=con.prepareCall(sql);
				callst.setString(1, name);
				callst.setString(2, phoneNumber);
				callst.setString(3, email);
				callst.setString(4, gender);
				callst.setString(5, city);
				callst.setString(6, state);
				callst.setString(7, password);
				
				callst.execute();
				Status=true;
			}catch (Exception e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
			finally{
				try {
					if(callst != null)
						callst.close();
					if(con !=null)
						con.close();
				}catch(Exception e) {e.printStackTrace();}
			
			}
			return Status;
		}
		
		public static boolean FacultyCreation(String name,String phoneNumber,String email,String department,String at,String post,String dist,String pin,String state,String password,String gender) {
			boolean status=false;
			CallableStatement callst=null;
			Connection con=getConnection();
			try {
				
				String sql="{call facultyCreation(?,?,?,?,?,?,?,?,?,?,?)}";
				callst=con.prepareCall(sql);
				callst.setString(1, name);
				callst.setString(2, phoneNumber);
				callst.setString(3, email);
				callst.setString(4, gender);
				callst.setString(5, department);
				callst.setString(6, at);
				callst.setString(7, post);
				callst.setString(8, dist);
				callst.setString(9, pin);
				callst.setString(10, state);
				callst.setString(11, password);
				callst.execute();
				status=true;
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				try {
					if(callst != null)
						callst.close();
					if(con !=null)
						con.close();
				}catch(Exception e) {e.printStackTrace();}
			
			}

			return status;
		}
		
		public static UserInfo getAdminInfoById(int id) {
			UserInfo bean= null;
			try {
				Connection con=getConnection();
				
				PreparedStatement pst=con.prepareStatement("SELECT * FROM Mentor.admin where id = ?");
				pst.setInt(1, id);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next()) {
					bean = new UserInfo();
					bean.setId(id);
					bean.setName(rs.getString("Name"));
					bean.setNumber(rs.getString("PhoneNumber"));
					bean.setEmail(rs.getString("Email"));
					bean.setSex(rs.getString("Sex"));
					bean.setCity(rs.getString("City"));
					bean.setState(rs.getString("State"));
				}
			}catch(Exception e) {e.printStackTrace();}
			
			return bean;
		}
	
	public static List<UserInfo> facultyList(){
		List<UserInfo> list=new ArrayList<UserInfo>();
		Connection con;
		PreparedStatement pst;
		String sql="select * from Mentor.Faculty";
		try {
			con=getConnection();
			pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				UserInfo u_info=new UserInfo();
				u_info.setId(rs.getInt("FId"));
				u_info.setName(rs.getString("FName"));
				list.add(u_info);
			}
			}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		}
	public static List<UserInfo> studentList(){
		List<UserInfo> list=new ArrayList<UserInfo>();
		Connection con;
		PreparedStatement pst;
		String sql="select * from Mentor.Student";
		try {
			con=getConnection();
			pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				UserInfo u_info=new UserInfo();
				u_info.setId(rs.getInt("SId"));
				u_info.setName(rs.getString("Name"));
				list.add(u_info);
			}
			}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		}
	public static UserInfo facultyProfile(int uid) {
		UserInfo f_bean = new UserInfo();
		Connection con;
		PreparedStatement pst;
		try {
			con=getConnection();
			String sql="select * from Mentor.Faculty where FId=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, uid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				f_bean.setId(rs.getInt(1));
				f_bean.setName(rs.getString(2));
				f_bean.setSex(rs.getString(3));
				f_bean.setDob(rs.getString(4));
				f_bean.setNumber(rs.getString(5));
				f_bean.setEmail(rs.getString(6));
				
				f_bean.setAt(rs.getString(7));
				f_bean.setPost(rs.getString(8));
				f_bean.setDistrict(rs.getString(9));
				f_bean.setState(rs.getString(10));
				f_bean.setPin(rs.getString(11));
				f_bean.setDepartment(rs.getString(12));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f_bean;
	}
	public static UserInfo getStudentById(int id) {
		UserInfo bean= null;
		try {
			Connection con=getConnection();
			
			PreparedStatement pst=con.prepareStatement("SELECT * FROM Mentor.Student where SId = ?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				bean = new UserInfo();
				bean.setId(id);
				bean.setName(rs.getString("Name"));
				bean.setSex(rs.getString("Sex"));
				bean.setDob(rs.getString("DOB"));
				bean.setNumber(rs.getString("PhoneNumber"));
				bean.setEmail(rs.getString("Email"));
				bean.setDepartment(rs.getString("Department"));
				bean.setF_name(rs.getString("FatherName"));
				bean.setF_number(rs.getString("FNumber"));
				bean.setF_email(rs.getString("FEmail"));
				bean.setM_name(rs.getString("MotherName"));
				bean.setM_number(rs.getString("MNumber"));
				bean.setM_email(rs.getString("MEmail"));
				bean.setAt(rs.getString("At"));
				bean.setPost(rs.getString("Post"));
				bean.setDistrict(rs.getString("District"));
				bean.setState(rs.getString("State"));
				bean.setPin(rs.getString("Pincode"));
				bean.setMentorId(rs.getInt("MentorId"));
			}
		}catch(Exception e) {e.printStackTrace();}
		
		return bean;
	}
	public static List<UserBean> getDepartment() {
		List<UserBean> dept=new ArrayList<UserBean>();
		Connection con;
		PreparedStatement pst;
		String sql;
		try {
			con = getConnection();
			sql="SELECT DCode FROM Mentor.Department;";
			pst = con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				UserBean bean= new UserBean();
				bean.setDepartment(rs.getString("DCode"));
				dept.add(bean);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dept;
	}
	
	public static boolean StudentCreation(String name,String phoneNumber,String email,String gender,String dob,String department,String father_name,String father_phoneNumber,String father_email,String mother_name,String mother_phoneNumber,String mother_email,String at,String post,String dist,String pin,String state,String password) {
		boolean status=false;
		CallableStatement callst=null;
		Connection con=getConnection();
		try {
			
			String sql="{call studentCreation(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callst=con.prepareCall(sql);
			callst.setString(1, name);
			callst.setString(2, phoneNumber);
			callst.setString(3, email);
			callst.setString(4, gender);
			callst.setString(5, dob);
			callst.setString(6, department);
			callst.setString(7, father_name);
			callst.setString(8, father_phoneNumber);
			callst.setString(9, father_email);
			callst.setString(10, mother_name);
			callst.setString(11, mother_phoneNumber);
			callst.setString(12, mother_email);
			callst.setString(13, at);
			callst.setString(14, post);
			callst.setString(15, dist);
			callst.setString(16, pin);
			callst.setString(17, state);
			callst.setString(18, password);
			callst.execute();
			status=true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				if(callst != null)
					callst.close();
				if(con !=null)
					con.close();
			}catch(Exception e) {e.printStackTrace();}
		
		}

		return status;
	}
	public static boolean mentorCreation(int mentorId,int firstId,int lastId) {
		boolean Status=false;
		Connection con;
		PreparedStatement pst;
		String sql;
		try {
			con=getConnection();
			con.setAutoCommit(false);
			sql="insert into Mentor.Mentor values(null,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setInt(1, mentorId);
			pst.setInt(2, firstId);
			pst.setInt(3, lastId);
			pst.executeUpdate();
			con.commit();
			Status=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	
	public static boolean mentorAssign(int studentId,int mentorId) {
		boolean Status=false;
		Connection con;
		PreparedStatement pst;
		String sql;
		try {
			con=getConnection();
			con.setAutoCommit(false);
			sql="update Mentor.Student set MentorId=? where SId=?;";
			pst=con.prepareStatement(sql);
			pst.setInt(1, mentorId);
			pst.setInt(2, studentId);
			
			pst.executeUpdate();
			con.commit();
			Status=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	public static boolean subjectRegistration(String department,String topic1,String topic2,String topic3,String topic4,String topic5, String topic6,String topic7,String semester,String year) {
		Connection con;
		PreparedStatement pst;
		String sql;
		boolean Status=false;
		try {
			con=getConnection();
			con.setAutoCommit(false);
			sql="insert into Mentor.SubjectRegistration values(null,?,?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, department);
			pst.setString(2, topic1);
			pst.setString(3, topic2);
			pst.setString(4, topic3);
			pst.setString(5, topic4);
			pst.setString(6, topic5);
			pst.setString(7, topic6);
			pst.setString(8, topic7);
			pst.setString(9, semester);
			pst.setString(10, year);
			pst.executeUpdate();
			con.commit();
			Status=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	
	public static List<UserBean> getSubjectList(){
		List<UserBean> subjectList;
		Connection con;
		PreparedStatement pst;
		String sql;
		subjectList=new ArrayList<UserBean>();
		try {
			
			con=getConnection();
			sql="select SCode,SName from Mentor.Subject";
			pst=con.prepareStatement(sql);
			con.setAutoCommit(false);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				UserBean bean = new UserBean();
				bean.setSubjectCode(rs.getString(1));
				bean.setSubjectName(rs.getString(2));
				subjectList.add(bean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}
	
	public static boolean facultyAssign(String subjectCode,int facultyId,String department,String semester,String year) {
		Connection con;
		PreparedStatement pst;
		String sql;
		boolean Status = false;
		try {
			con = getConnection();
			sql = "insert into Mentor.SubjectAssign values(null,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, subjectCode);
			pst.setInt(2, facultyId);
			pst.setString(3, department);
			pst.setString(4, semester);
			pst.setString(5, year);
			con.setAutoCommit(false);
			pst.executeUpdate();
			con.commit();
			Status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	
	public static boolean assignSemester(int StudentId,String Department,String Semester,String Year) {
		boolean Status = false;
		Connection con;
		PreparedStatement pst;
		String sql;
		try {
			con = getConnection();
			sql="INSERT INTO `Mentor`.`SemesterCategorization` (`Id`, `StudentId`, `Department`, `Semester`, `Year`) VALUES (null,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, StudentId);
			pst.setString(2, Department);
			pst.setString(3, Semester);
			pst.setString(4, Year);
			con.setAutoCommit(false);
			pst.executeUpdate();
			con.commit();
			Status = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Status;
	}
	}