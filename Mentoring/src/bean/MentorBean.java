package bean;

public class MentorBean {
	private int firstInternalMark,secondInternalMark,thirdInternalMark,semesterMark;
	private String subjectCode,subjectName;
	// below json named variable are storing a string of multiple values for graph
	private String jsonSubjectNames,jsonfirstInternalMark,jsonsecondInternalMark,jsonthirdInternalMark;
	

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

	public String getJsonSubjectNames() {
		return jsonSubjectNames;
	}

	public void setJsonSubjectNames(String jsonSubjectNames) {
		this.jsonSubjectNames = jsonSubjectNames;
	}

	public String getJsonfirstInternalMark() {
		return jsonfirstInternalMark;
	}

	public void setJsonfirstInternalMark(String jsonfirstInternalMark) {
		this.jsonfirstInternalMark = jsonfirstInternalMark;
	}

	public String getJsonsecondInternalMark() {
		return jsonsecondInternalMark;
	}

	public void setJsonsecondInternalMark(String jsonsecondInternalMark) {
		this.jsonsecondInternalMark = jsonsecondInternalMark;
	}

	public String getJsonthirdInternalMark() {
		return jsonthirdInternalMark;
	}

	public void setJsonthirdInternalMark(String jsonthirdInternalMark) {
		this.jsonthirdInternalMark = jsonthirdInternalMark;
	}
	
}
