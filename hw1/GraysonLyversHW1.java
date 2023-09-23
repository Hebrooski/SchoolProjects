package assignments.hw1;

public class GraysonLyversHW1 {
	
	// course: CSC 191
		// project: HW 1
		// date: 8/29/2023
		// author: Grayson Lyvers
		// purpose: To create an example of inheritance using an employee(super) and
		// sales person(sub)
	
	public static void main(String[] args) {
		double[][] empTimesheet = {{8.5},{7.9},{5.2},{11.8},{6.4},{8.2},{0}};
		Employee emp = new Employee("Garry Fitzgerald", 111, 17.25, empTimesheet, 
				"gfitzgerald@company.com");
		double[][] salesTimesheet = {{5.4},{9.2},{6.9},{1,1,1,1,1,1,1,0.2},{5.2},{6.1},{1.2}};
		Salesperson sales = new Salesperson("Lester Franklin", 57, 15.5, salesTimesheet, 
				"lfranklin@sales.company.com", 0.23);
		
		System.out.println(emp);
		System.out.println();
		System.out.println(sales);
		System.out.println();
		emp.printTimesheet();
		System.out.println();
		sales.printTimesheet();
		System.out.println();
		
		sales.setEmail("lesterf@sales.company.com");
		System.out.println(sales.getName()+" : "+sales.getEmail());
		System.out.println();
		
		sales.setCommissionRate(sales.getCommissionRate()+0.05);
		System.out.println(sales);
		System.out.println();
		
		System.out.printf("%s's(Employee) total pay = $%.2f",emp.getName(),emp.calculatePay());
		System.out.println();
		double totalSales = 23;
		System.out.printf("%s's(Sales) total pay = $%.2f",sales.getName(),sales.calculatePay(totalSales));
		
	}

}
