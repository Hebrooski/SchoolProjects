package hw.account;

import java.time.Instant;
import java.util.Date;

public class Account {
	private int id;
	private double balance;
	private static double annualIntrestRate; 
	private Date dateCreated;
	
	Account(){
		super();
		dateCreated = Date.from(Instant.now());
	}
	
	Account(int idIn, double balanceIn){
		this();
		id = idIn;
		balance = balanceIn;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static double getAnnualIntrestRate() {
		return annualIntrestRate;
	}

	public static void setAnnualIntrestRate(double annualIntrestRate) {
		Account.annualIntrestRate = annualIntrestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterestRate() {
		return annualIntrestRate/12;
	}
	
	public double getMonthlyInterest() {
		return balance*getMonthlyInterestRate();
	}
	
	public boolean withdraw(double amountToWithdraw){
		if(amountToWithdraw <= balance) {
			balance -= amountToWithdraw;
			return true;
		}else{
			return false;
		}
	}
	public void deposit(double amountToDepsoit) {
		balance += amountToDepsoit;
	}
}
