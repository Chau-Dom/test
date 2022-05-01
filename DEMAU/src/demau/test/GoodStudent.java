package demau.test;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodStudent extends Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double gpa;
	private String bestRewardName;

	public GoodStudent() {

	}

	public GoodStudent(String id, double gpa, String bestRewardName) {
		super(id);
		this.gpa = gpa;
		this.bestRewardName = bestRewardName;
	}

	public GoodStudent(String id, String fullName, Date doB, String sex, String phoneNumber, String universityName,
			String gradeLevel, double gpa, String bestRewardName) {
		super(id, fullName, doB, sex, phoneNumber, universityName, gradeLevel);
		this.gpa = gpa;
		this.bestRewardName = bestRewardName;
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

	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return "[ID: " + this.getID() + ",Name: " + this.getFullName() + ",DoB: " + df.format(this.getDoB()) + ",GT: "
				+ this.getSex() + ",Phone " + this.getPhoneNumber() + ",Univer: " + this.getUniversityName()
				+ ",Grade: " + this.getGradeLevel() + ",GPA: " + this.getGpa() + ",Reward: " + this.getBestRewardName()
				+ "]";
	}

	@Override
	public String convertString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return this.getID() + "," + this.getFullName() + "," + df.format(this.getDoB()) + "," + this.getSex() + ","
				+ this.getPhoneNumber() + "," + this.getUniversityName() + "," + this.getGradeLevel() + ","
				+ this.getGpa() + "," + this.getBestRewardName();
	}

}
