package assignments.hw;

import java.util.Scanner;

//course: CSC 191
	// project: HW 5
	// date: 10/26/2023
	// author: Grayson Lyvers
	// purpose: To use recursion to on strings

public class GraysonLyversHW5 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = getUserString(scan);
		String str2 = getUserString(scan);
		while(true) {
			System.out.println("Menu:\n1) Change string1\n2) Change string2\nr) Print strings with duplicate characters removed\nu) Print union between strings\ni) Print intersection between strings\nd) Print difference between strings\ne) exit");
			char rep = scan.next().toLowerCase().charAt(0);
			switch(rep) {
				case '1':
					str1=getUserString(scan);
					break;
				case '2':
					str2=getUserString(scan);
					break;
				case 'r':
					System.out.println(str1+" : "+removeDups(str1));
					System.out.println(str2+" : "+removeDups(str2));
					break;
				case 'u':
					System.out.println(str1+" U "+str2+" = "+union(removeDups(str1), removeDups(str2)));
					break;
				case 'i':
					System.out.println(str1+" I "+str2+" = "+intersection(removeDups(str1), removeDups(str2)));
					break;
				case 'd':
					System.out.println(str1+" D "+str2+" = "+difference(removeDups(str1), removeDups(str2)));
					break;
				default:
					System.out.println("Goodbye");
					return;
			}
		}
	}

	private static String getUserString(Scanner scan) {
		while(true) {
			System.out.println("Please enter a string:");
			try {
				String str = scan.next();
				return str;
			}catch(Exception e) {
				System.out.println("Error! Please try again.");
			}
		}
	}

	public static String union(String str1, String str2) {
		if(str1.length()==0)
			return str2;
		else if(str2.length() == 0)
			return str1;
		String letter = str1.charAt(0)+"";
		return letter+ union(str1.replace(letter, ""),str2.replace(letter, ""));
	}

	public static String intersection(String str1, String str2) {
		if(str1.length()==0)
			return str2;
		else if(str2.length() == 0)
			return str1;
		String letter = str1.charAt(0)+"";
		if(str2.contains(letter))
			return letter + intersection(str1.replace(letter,""), str2.replace(letter, ""));
		else
			return intersection(str1.replace(letter,""), str2.replace(letter, ""));
	}
	
	public static String difference(String str1, String str2) {
		if(str1.length()==0)
			return str2;
		else if(str2.length() == 0)
			return str1;
		String letter = str1.charAt(0)+"";
		if(!str2.contains(letter))
			return letter + difference(str1.replace(letter,""), str2.replace(letter, ""));
		else
			return difference(str1.replace(letter,""), str2.replace(letter, ""));
	}


	public static String removeDups(String str) {
		if(str.length()==0)
			return "";
		String letter = str.charAt(0)+"";
		return letter + removeDups(str.replace(letter, ""));
	}
}
