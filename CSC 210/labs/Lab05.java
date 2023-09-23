package labs;

import java.util.Scanner;

//course: CSC210

	//project: Lab04

	//date: 3/4/2022

	//author: Grayson Lyvers

	//purpose: to use recursion to to print all the permutations of a string

public class Lab05 {
	
	public static void main(String[] args) {
		System.out.println("Please enter a string to see all of it's permutations: ");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		displayPermutation(str);
		scan.close();
	}
	
	public static void displayPermutation(String str) { 
	    displayPermutation("", str); 
	}

	private static void displayPermutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            displayPermutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

}
