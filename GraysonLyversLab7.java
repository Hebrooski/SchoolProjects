package labs;

import java.util.Scanner;

//course: 	CSC 191
//project: 	Lab 6
//date: 	10/4/23
//author:	Grayson Lyvers
//purpose: To create methods that recursively convert decimal and binary numbers

public class GraysonLyversLab7 {

	public static String DtoB(int n) {
		if (n > 0) {
			return "" + DtoB(n / 2) + n % 2;
		} else// base case
			return n % 2 + "";

	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			while (true) {
				System.out.println("Menu:\nDecimal to binary (d):\nBinary to decimal (b):\nExit (e):");
				try {
					char key = scan.next().charAt(0);
					if (key =='d') {// check that the key is positive
						System.out.println("Please enter a decimal number:");
						int n = scan.nextInt();
						System.out.println(DtoB(n));
					}
					else if(key == 'b') {
						System.out.println("Please enter a binary number:");
						String b = scan.next();
						System.out.println(BtoD(b));
					}else
						break;
				} catch (Exception e) {
					scan.nextLine();
					System.out.println("Invalid! Must be a number!");
				}
			}
			System.out.println("Goodbye!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Please try again:");
		}
	}

	public static int BtoD(String b) {
		
		return BtoDHelper(b,b.length()-1,0);
	}
	private static int BtoDHelper(String b, int i,int p) {
		if(i == -1)
			return 0;
		else //if the bit = 1 add its value to the total
			// since the input is a string we must parse the bit into an int
			return (((int)(Math.pow(2, p))*(b.charAt(i)-'0') + BtoDHelper(b,i-1,p+1)));
	}

}
