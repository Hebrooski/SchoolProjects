package labs;

import java.util.Scanner;

public class Lab01 {

	public static void main(String[] args) {
	// Scanner to take input from user
		Scanner input = new Scanner(System.in);
	// collecting the credit numbers here, as a long
		boolean runLoop = true;
		boolean firstRun = true;
		// creating an event loop. Program only has to run once to be tested multiple times
		while(runLoop) {
			if(firstRun) {
				System.out.println("Please enter a credit card number:\n");
				firstRun = false;
			}	
			else
				System.out.println("To exit program enter exit.\n Otherwise, please enter another credit card number:\n");
			//collecting the string for possible exit command
			String takenInput = input.nextLine();
			if(takenInput.toLowerCase().equals("exit")) {
				runLoop = false;
				break;
			}
			else {
				long creditNum = 0;
				try {
					creditNum = Long.parseLong(takenInput);
				}
				catch(Exception e) {
					System.out.println("INVALID INPUT");
					continue;
				}
				printIsValid(creditNum,isValid(creditNum));
			}
		
		}
		
		System.out.println("Thank you for validating your credit cards!");
	
		
	}
	
	//to reduce redundancy, creating a custom print method
	static void printIsValid(long creditNum, boolean isValid) {
		if(isValid) 
			System.out.printf("%d is valid!%n%n",creditNum);
		else
			System.out.printf("%d is invalid.%n%n",creditNum);
	}
	
	static boolean isValid(long number) {
		//convert credit number to a string for proper testing.
		String cNum = number+"";
		//the valid length of a card number is 13-16
		if(cNum.length() < 13 || cNum.length()>16)
			return false;
		else if(((sumOfDoubleEvenPlace(number)+sumOfOddPlace(number))%10)== 0 &&preFixMatched(number))
			return true;
		
		return false;
	}
	
	static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		//convert card number to string for proper testing
		String cNum = number+"";
		//starting from the right side of the string and working to the left
		for (int i = cNum.length()-2; i >= 0; i-= 2) {
			int currentNumDoubled = Integer.parseInt(cNum.charAt(i)+"")*2;
			sum += getDigit(currentNumDoubled);
		}
		return sum;
	}
	
	static int getDigit(int number) {
		int sum = 0;
		if(number > 9) {
			String doubleDigits = number+"";
			int miniSum = 0;
			for (int j = 0; j < doubleDigits.length(); j++) {
				miniSum += Integer.parseInt(doubleDigits.charAt(j)+"");
			}
			sum += miniSum;
		}
		else
			sum += number;
		return sum;
		
	}
	static int sumOfOddPlace(long number) {
		int sum = 0;
		//convert card number to string for proper testing
		String cNum = number+"";
		//starting from the right side of the string and working to the left
		for (int i = cNum.length()-1; i >= 0; i-= 2) {
			int currentNumDoubled = Integer.parseInt(cNum.charAt(i)+"");
			sum += currentNumDoubled;
		}
		
		return sum;
	}
	
	static boolean preFixMatched(long number) {
		//to work with strings convert to string
		String cNum = number+"";
		//Visa check
		if(cNum.charAt(0) == '4')
			return true;
		//MasterCard Check
		else if(cNum.charAt(0) == '5')
			return true;
		//Discover check
		else if(cNum.charAt(0) == '6')
			return true;
		//American Express check
		else if(cNum.substring(0, 2).equals("37"))
			return true;
		else
			return false;
		
	}
	
}
