package hw04;

public class StudentRecord {
	private String name;
	private int earnedCH; 
	private int qualPts;
	private double gpa; 

	public StudentRecord() {}

	public StudentRecord(String name, int earnedCH, int qPts) {
		this.name = name;
		this.earnedCH = earnedCH;
		qualPts = qPts;
		gpa = (double)qualPts/earnedCH;
	}

	public String getName() {
		return name;
	}

	public int getEarnedCh() {
		return earnedCH;
	}

	public int getQualPts() {
		return qualPts;
	}

	public double getGPA() {
		return gpa;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEarnedCh(int eCreditHours) {
		earnedCH = eCreditHours;
		gpa = qualPts/earnedCH;
	}

	public void setQualPts(int qPts) {
		qualPts = qPts;
		gpa = qualPts/earnedCH;
	}
	
	public String toString() {
		return String.format("%s, %d, %d, %.2f%n",name,earnedCH,qualPts,gpa);
	}
}
