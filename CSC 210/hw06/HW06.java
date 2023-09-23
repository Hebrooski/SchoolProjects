package hw06;

import java.util.Scanner;

//course: CSC210

//project: HW06

//date: 2/18/2022

//author: Grayson Lyvers

//purpose: To use recursion while working with strings

public class HW06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the string you would like reversed and substrings of: ");
		String input = scan.next();
		scan.close();
		System.out.print("Reversed: ");reverseS(input);
		System.out.print("Substrings 1: ");printSub1(input);System.out.println();
		System.out.print("Substrings 2: ");printSub2(input);
	}

	public static void reverseS(String str) {
		if (str.length() > 0) {
			System.out.print(str.charAt(str.length() - 1));
			reverseS(str.substring(0, str.length() - 1));
		}
		else
			System.out.println();
	}

	public static void printSub1(String str) {
		
			if (str.length() == 1) {
	            System.out.print(str+" ");
	            return;
	        }else{
	            System.out.print(str+" ");
	            printSub1(str.substring(0, str.length()-1)); 
	            printSub1(str.substring(1, str.length())); 
	        }
		

	}

	public static void printSub2(String str) {
		if (str.length() > 0) {
			for (int i = 0; i < str.length(); i++) 
				System.out.print(str.substring(0, i + 1)+" ");
			printSub2(str.substring(1, str.length()));
		}
		else
			System.out.println();
	}

}
