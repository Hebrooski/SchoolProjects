package assignments.hw1;

public class Salesperson extends Employee{
	
	private double commissionRate;

	public Salesperson(String name, int empNum, double hourPayRate, double[][] timesheet, String email,double commissionRate) {
		super(name, empNum, hourPayRate, timesheet, email); //call to super to pass the instance variables
		this.commissionRate=commissionRate;
	}
	//getters and setters
	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}//end getters and setters
	@Override
	public String toString() {
		return "Salesperson [name=" + getName() + ", empNum="
				+ getEmpNum() + ", hourPayRate=" + getHourPayRate() + ", email=" + getEmail() + ", commissionRate=" + commissionRate+ "]";
	}
	public double calculatePay(double weeklySales) {
		//calculate hourly pay with taxes removed
		double hourlyIncome = super.calculatePay();
		//calculate sales bonus income
		double salesPay = weeklySales*commissionRate;
		//remove taxes from sales income
		salesPay = salesPay-(salesPay*0.35);
		//return the sum of the incomes
		return hourlyIncome+salesPay;
	}
	
	
	
	

}
