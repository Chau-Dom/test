package demau.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AllStudents {
	private String id;
	private String fullName;
	private Date doB;
	private String sex;
	private String phoneNumber;
	private String universityName;
	private String gradeLevel;
	private double gpa;
	private String bestRewardName;
	private double englishScore;
	private double entryTestScore;

	public AllStudents() {

	}

	public AllStudents(String id, String fullName, Date doB, String sex, String phoneNumber, String universityName,
			String gradeLevel, double gpa, String bestRewardName, double englishScore, double entryTestScore) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.doB = doB;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.universityName = universityName;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.bestRewardName = bestRewardName;
		this.englishScore = englishScore;
		this.entryTestScore = entryTestScore;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getBestRewardName() {
		return bestRewardName;
	}

	public void setBestRewardName(String bestRewardName) {
		this.bestRewardName = bestRewardName;
	}

	public double getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(double englishScore) {
		this.englishScore = englishScore;
	}

	public double getEntryTestScore() {
		return entryTestScore;
	}

	public void setEntryTestScore(double entryTestScore) {
		this.entryTestScore = entryTestScore;
	}

	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return "[ID: " + this.getId() + ",Name: " + this.getFullName() + ",DoB: " + df.format(this.getDoB()) + ",GT: "
				+ this.getSex() + ",Phone " + this.getPhoneNumber() + ",Univer: " + this.getUniversityName()
				+ ",Grade: " + this.getGradeLevel() + ",GPA: " + this.getGpa() + ",Reward: " + this.getBestRewardName()
				+ ",EngScore: " + this.getEnglishScore() + ",EntryScore: " + this.getEntryTestScore() + "]";
	}
}
