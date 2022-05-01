package demau.test;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NormalStudent extends Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private double englishScore;
	private double entryTestScore;

	public NormalStudent() {

	}

	public NormalStudent(String id, String fullName, Date doB, String sex, String phoneNumber, String universityName,
			String gradeLevel, double englishScore, double entryTestScore) {
		super(id, fullName, doB, sex, phoneNumber, universityName, gradeLevel);
		this.englishScore = englishScore;
		this.entryTestScore = entryTestScore;
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
		return "[ID: " + this.getID() + ",Name: " + this.getFullName() + ",DoB: " + df.format(this.getDoB()) + ",GT: "
				+ this.getSex() + ",Phone: " + this.getPhoneNumber() + ",Univer: " + this.getUniversityName()
				+ ",Grade: " + this.getGradeLevel() + ",EScore: " + this.getEnglishScore() + ",EntryScore: "
				+ this.getEntryTestScore() + "]";
	}

	@Override
	public String convertString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return this.getID() + "," + this.getFullName() + "," + df.format(this.getDoB()) + "," + this.getSex() + ","
				+ this.getPhoneNumber() + "," + this.getUniversityName() + "," + this.getGradeLevel() + ","
				+ this.getEnglishScore() + "," + this.getEntryTestScore();
	}

}
