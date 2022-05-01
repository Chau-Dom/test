package demau.test;

import java.util.Date;

public abstract class Student {
	private String id;
	private String fullName;
	private Date doB;
	private String sex;
	private String phoneNumber;
	private String universityName;
	private String gradeLevel;

	public Student() {

	}

	public Student(String id) {
		super();
		this.id = id;
	}

	public Student(String id, String fullName, Date doB, String sex, String phoneNumber, String universityName,
			String gradeLevel) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.doB = doB;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.universityName = universityName;
		this.gradeLevel = gradeLevel;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDoB() {
		return doB;
	}

	public void setDoB(Date doB) {
		this.doB = doB;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public abstract String toString();

	public abstract String convertString();

}
