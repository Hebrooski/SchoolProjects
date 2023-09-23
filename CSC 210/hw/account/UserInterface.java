package hw.account;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Account> accounts = new ArrayList<>();
		//A for loop to create accounts
		for(int i = 0;i<10;i++) {
			accounts.add(new Account(i,100));
		}
		Account.setAnnualIntrestRate(4.5);
		System.out.println("Hello and welcome! Please enter an id number to begin: ");
		int idNum = scan.nextInt();
		Account currentAcc = findAccNum(idNum, accounts);
		if(currentAcc == null) {
			while(true) {
				System.out.println("We are sorry, but that account id number was invalid.\nPlease enter a vaild id number:");
				idNum = scan.nextInt();
				currentAcc = findAccNum(idNum, accounts);
				if(currentAcc != null)
					break;
			}
		}
		
		OptionLoop:while(true) {
			System.out.println("Main Menu\n1: Check Account Balance\n2: Withdraw\n3: Deposit\n4: Print Account Summary\n5: Exit\nPlease enter a vaild option:");
			int optionChosen = scan.nextInt();
			switch(optionChosen) {
			    case 1:
			    	System.out.printf("The available account balance is: %f%n",currentAcc.getBalance());
			    	break;
			    case 2:
			    	System.out.println("Please enter an ammount to withdraw:");
			    	double withdrawAmount = scan.nextDouble();
			    	if(currentAcc.withdraw(withdrawAmount))
			    		System.out.printf("%.2f successfuly withdrawn.%n",withdrawAmount);
			    	else
			    		System.out.println("Denied. Insuficent funds for withdraw request.");
			    	break;
			    case 3:
			    	System.out.println("Please enter an ammount to deposit:");
			    	double depositAmount = scan.nextDouble();
			    	if(depositAmount < 0)
			    		System.out.println("Denied. Cannot enter a negative number.");
			    	else {
			    		currentAcc.deposit(depositAmount);
			    		System.out.printf("%.2f successfuly deposited.%n",depositAmount);
			    	}
			    	break;
			    case 4: 
			    	System.out.println("Account id is: " + currentAcc.getId());
			    	System.out.println("Balance: " + currentAcc.getBalance());
			    	System.out.println("Monthly intrest is: " + currentAcc.getMonthlyInterest());
			    	System.out.println("The account was created: " + currentAcc.getDateCreated());
			    	break;
				case 5:
					break OptionLoop;
				default:
					System.out.println("Invalid option, please try again. Example option: 1");
			}
		}
		System.out.println("Thank you for choosing to bank with \"This Is Not a Bank\" Bank");	
	}
	//Method to find the correct account, and reduce redudentcy
	static Account findAccNum(int accNum,ArrayList<Account> accs) {
		for (Account account : accs) {
			if(account.getId() == accNum)
				return account;
		}
		return null;
	}

}
