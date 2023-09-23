package labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//course: CSC210

//project: Lab09

//date: 4/15/2022

//author: Grayson Lyvers

//purpose: To get the longest increasing substring and consecutive amount of letters from a string.

public class Lab09 {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Please enter a string:");
			String line = reader.readLine();
			if (line.length() > 0) {
				System.out.printf("Maximum consecutive substring : %s%n", maxSortedSubstring(line));
				System.out.printf("Maximum increasing order of letters : %s%n", maxSortedSubSeq(line));
			} else
				System.out.println("Please enter a valid string.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
//n^2
	private static Object maxSortedSubSeq(String line) {
		String result = "";
		for (int j = 0; j < line.length(); j++) {
			String temp = line.charAt(j) + "";
			for (int i = j; i < line.length(); i++) {
				if (temp.charAt(temp.length() - 1) < line.charAt(i)) {
					temp += line.charAt(i);
				}
			}
			if (temp.length() > result.length()) {
				result = temp;
			}
		}
		return result;
	}
//n
	private static String maxSortedSubstring(String line) {
		String result = "";
		String temp = line.charAt(0) + "";
		for (int i = 1; i < line.length(); i++) {
			if (temp.charAt(temp.length() - 1) < line.charAt(i)) {
				temp += line.charAt(i);
			} else if (temp.length() > result.length()) {
				result = temp;
				temp = line.charAt(i) + "";
			}
		}

		return result;
	}

}
