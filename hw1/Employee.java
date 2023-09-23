package assignments.hw1;

public class Employee {
	private String name;
	private int empNum;
	private double hourPayRate;
	private double[][] timesheet;
	private String email;
	public Employee(String name, int empNum, double hourPayRate, double[][] timesheet, String email) {
		super();// call to super Object, the call to super is implicit but can be explicit 
		this.name = name;
		this.empNum = empNum;
		this.hourPayRate = hourPayRate;
		this.timesheet = timesheet;
		this.email = email;
	}
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public double getHourPayRate() {
		return hourPayRate;
	}
	public void setHourPayRate(double hourPayRate) {
		this.hourPayRate = hourPayRate;
	}
	public double[][] getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(double[][] timesheet) {
		this.timesheet = timesheet;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}// end of getters and setters
	
	@Override //toString excluding timesheet
	public String toString() {
		return "Employee [name=" + name + ", empNum=" + empNum + ", hourPayRate=" + hourPayRate + ", email=" + email
				+ "]";
	}
	
	public void printTimesheet() {
		//create an array that contains the days
		System.out.println(name+"'s timesheet for this week:");
		String[] days = {"Mon: ","Tue: ","Wed: ","Thu: ","Fri: ","Sat: ","Sun: "};
		for (int i = 0; i < timesheet.length; i++) {
			//indent days for easier reading
			System.out.print("\t"+days[i]);
			for (int j = 0; j < timesheet[i].length-1; j++) {
				//print hours recorded if there are multiple clock ins and outs
				System.out.print(timesheet[i][j]+", ");
			}
			//print the hour(s) without a comma after
			System.out.println(timesheet[i][timesheet[i].length-1]);
		}
	}
	
	public double calculatePay() {
		//create a var to hold total of hours
		double totalHours = 0;
		double totalPay = 0;
		for (int i = 0; i < timesheet.length; i++) {
			for (int j = 0; j < timesheet[i].length; j++) {
				totalHours += timesheet[i][j];
			}
		}
		
		//check if the total hours is over 40 to calc overtime pay
		if(totalHours > 40) {
			int forty = 40;
			totalHours -= 40;
			//calc pay for initial forty hours 
			totalPay += forty*hourPayRate;
			totalPay += totalHours*(hourPayRate*1.5);
		}
		else {
			totalPay += totalHours*hourPayRate;
		}
		//return total pay with taxes deducted
		return totalPay-(totalPay*0.35);
	}
}
