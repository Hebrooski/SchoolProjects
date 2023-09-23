package hw03;

public class Student extends Person{
	
	 final int FRESHMAN = 1;
	 final int SOPHOMORE = 2;
	 final int JUNIOR = 3;
	 final int SENIOR = 4;
	 int year;
	
	Student(){}
	Student(String name,String address,String phoneNum,String emailAdd,int year){
		super(name,address,phoneNum,emailAdd);
		this.year = year;
	}
	
	public String toString() {
		String classification = null;
		switch(year) {
			case FRESHMAN:
				classification = "Freshman";
				break;
			case SOPHOMORE:
				classification = "Sophomore";
				break;
			case JUNIOR:
				classification = "Junior";
				break;
			case SENIOR:
				classification = "Senior";
		}
		return String.format("Student: %s (%s)", name,classification);
	}

}
