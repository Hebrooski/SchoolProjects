package labs.lab06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

//course: CSC210

//project: Lab06

//date: 3/11/2022

//author: Grayson Lyvers

//purpose: to read from a java file and check symbol pairings

public class Lab06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the filepath to the .java file you would like to read: ");
		String filePath = scan.next();
		scan.close();
		readFile(filePath);
	}

	static void readFile(String filePath) {
		Stack<Character> stack = new Stack<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
			String line = "";
			while (line != null) {
				for (int i = 0; i < line.length(); i++) {
					char current = line.charAt(i);
					switch (current) {
					case '(':
					case '{':
					case '[':
						stack.push(current);
						break;
					case ')':
					case '}':
					case ']':
						char previous = stack.peek();
						if (current == '}' && previous == '{')
							stack.pop();
						else if (current == ')' && previous == '(')
							stack.pop();
						else if (current == ']' && previous == '[')
							stack.pop();

					}
				}
				line = reader.readLine();
			}
			if (stack.isEmpty()) {
				System.out.println("The file is valid!");
			} else {
				System.out.println("This file is invalid!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
