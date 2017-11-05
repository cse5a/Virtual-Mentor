package bean;

public class MentorBean {
	private int firstInternalMark,secondInternalMark,thirdInternalMark,semesterMark;
	private String subjectCode,subjectName;
	// variable to store the attendance
	private int firstMonthTotalClass,secondMonthTotalClass,thirdMonthTotalClass,
	firstMonthTotalAttended,secondMonthTotalAttended,thirdMonthTotalAttended,
	attendanceInPercentage;
	private String color;

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getFirstInternalMark() {
		return firstInternalMark;
	}

	public void setFirstInternalMark(int firstInternalMark) 
	{
		this.firstInternalMark = firstInternalMark;
	}

	public int getSecondInternalMark() {
		return secondInternalMark;
	}

	public void setSecondInternalMark(int secondInternalMark) {
		this.secondInternalMark = secondInternalMark;
	}

	public int getThirdInternalMark() {
		return thirdInternalMark;
	}

	public void setThirdInternalMark(int thirdInternalMark) {
		this.thirdInternalMark = thirdInternalMark;
	}

	public int getSemesterMark() {
		return semesterMark;
	}

	public void setSemesterMark(int semesterMark) {
		this.semesterMark = semesterMark;
	}

	public int getFirstMonthTotalClass() {
		return firstMonthTotalClass;
	}

	public void setFirstMonthTotalClass(int firstMonthTotalClass) {
		this.firstMonthTotalClass = firstMonthTotalClass;
	}

	public int getSecondMonthTotalClass() {
		return secondMonthTotalClass;
	}

	public void setSecondMonthTotalClass(int secondMonthTotalClass) {
		this.secondMonthTotalClass = secondMonthTotalClass;
	}

	public int getThirdMonthTotalClass() {
		return thirdMonthTotalClass;
	}

	public void setThirdMonthTotalClass(int thirdMonthTotalClass) {
		this.thirdMonthTotalClass = thirdMonthTotalClass;
	}

	public int getFirstMonthTotalAttended() {
		return firstMonthTotalAttended;
	}

	public void setFirstMonthTotalAttended(int firstMonthTotalAttended) {
		this.firstMonthTotalAttended = firstMonthTotalAttended;
	}

	public int getSecondMonthTotalAttended() {
		return secondMonthTotalAttended;
	}

	public void setSecondMonthTotalAttended(int secondMonthTotalAttended) {
		this.secondMonthTotalAttended = secondMonthTotalAttended;
	}

	public int getThirdMonthTotalAttended() {
		return thirdMonthTotalAttended;
	}

	public void setThirdMonthTotalAttended(int thirdMonthTotalAttended) {
		this.thirdMonthTotalAttended = thirdMonthTotalAttended;
	}

	public int getAttendanceInPercentage() {
		return attendanceInPercentage;
	}

	public void setAttendanceInPercentage(int attendanceInPercentage) {
		this.attendanceInPercentage = attendanceInPercentage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	
	
}
