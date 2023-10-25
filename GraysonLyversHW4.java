package assignments.hw4;

import java.util.Scanner;

public class GraysonLyversHW4 {

	// course: CSC 191
	// project: HW 4
	// date: 10/17/2023
	// author: Grayson Lyvers
	// purpose: To use recursion to find combinations of substrings

	public static void main(String[] args) {
		startMenu();//put the menu in a method to keep main method "clean"
		System.out.println("Goodbye!");
		
	}


	private static void startMenu() {//run the menu in a method so the return keyword can be utilized
		Scanner scan = new Scanner(System.in);
		String str = getUserStr(scan);
		while (true) {
			System.out.println("Menu:\n1. printSub1\n2. printSub2\n3. printSub3\n4. printSub4\ns. input new string\ne. exit");
			try {
				String input = scan.next();
				switch(input.charAt(0)){
				case '1':
					System.out.println();
					printSub1(str,0,1);
					break;
				case '2':
					System.out.println();
					printSub2(str,str.length(),str.length()-1);
					break;
				case '3':
					System.out.println();
					printSub3(str, 0, 1,2);
					break;
				case '4':
					System.out.println();
					printSub4(str, 0,str.length(),str.length()-1);
					break;
				case 's':
					str = getUserStr(scan);
					break;
				case 'e':
					return;
				}
				System.out.println("\n");
			}catch(Exception e) {
				System.out.println("Invalid input!");
			}
		}
	}


	private static String getUserStr(Scanner scan) {// get the string from the user
		while (true) {
			try {
				System.out.println("Please enter a string: ");
				return scan.next();

			} catch (Exception e) {
				System.out.println("Invalid input!");
				scan.nextLine();
			}
		}
	}
	//if str = abcd output is (a,ab,abc,abcd,b,bc,bcd,c,cd,d)
	public static void printSub1(String str, int j, int i) {
		if (j == str.length() - 1)
			System.out.print(str.substring(j));
		else if (i == str.length()) {
			System.out.print(str.substring(j) + ", ");
			printSub1(str, j + 1, j + 2);
		} else {
			System.out.print(str.substring(j, i) + ", ");
			printSub1(str, j, i + 1);
		}
	}
	//if str = abcd output is (d, cd, bcd, abcd, c, bc, abc, b, ab, a)
	public static void printSub2(String str, int j, int i) {
		if (j == 1)
			System.out.print(str.substring(j - 1, j));
		else if (i == 0) {
			System.out.print(str.substring(i, j) + ", ");
			printSub2(str, j - 1, j - 2);
		} else {
			System.out.print(str.substring(i, j) + ", ");
			printSub2(str, j, i - 1);
		}
	}
	//if str = abcd output is (a, b, c, d, ab, bc, cd, abc, bcd, abcd)
	public static void printSub3(String str, int i, int j, int step) {
		if (j == str.length()) {
			if (step <= str.length()) {
				System.out.print(str.substring(i, j) + ", ");
				printSub3(str, 0, step, step + 1);
			} else
				System.out.print(str.substring(0, j));
		} else {
			System.out.print(str.substring(i, j) + ", ");
			printSub3(str, i + 1, j + 1, step);
		}
	}
	//if str = abcd output is (abcd, bcd, abc, cd, bc, ab, d, c, b, a)
	public static void printSub4(String str, int i, int j, int step) {
		if (i == 0) {
			System.out.print(str.substring(i, j));
			if (step >= 1) {
				System.out.print(", ");
				printSub4(str, str.length() - step, str.length(), step - 1);
			} else
				System.out.print(str.substring(0, step) + " ");
		} else {
			System.out.print(str.substring(i, j) + ", ");
			printSub4(str, i - 1, j - 1, step);
		}

	}

}
