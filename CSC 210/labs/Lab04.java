package labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lab04 {
	
	//course: CSC210

	//project: Lab04

	//date: 2/18/2022

	//author: Grayson Lyvers

	//purpose: To read from a file and count characters, words, and lines

	
	public static void main(String[] args) {
		if(args.length > 0) {
			String testFile = args[0];
			try {
				System.out.println(stringCounter(fileReader(testFile),testFile));
			} catch (FileNotFoundException e) {
				System.out.printf("Source file %s does not exist.",testFile);
			}
		}
		else {
			System.out.println("Usage: java Lab04 fileName");
		}
	}
	
	public static String fileReader(String fileName) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
		StringBuilder sb = new StringBuilder();		
		while(true) {
			String line = "";
			try {
				line = reader.readLine();
				if(line == null)
					break;
				sb.append(line).append('\n');
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	public static String stringCounter(String text, String fileName) {
		int chars = text.length();
		int words = 0;
		int lines = 0;
		for (int i = 0; i < text.length(); i++) {
			if(i>0)
				if(((text.charAt(i-1) != ' ' && text.charAt(i)== ' ') || 
					(text.charAt(i-1) != '\n' && text.charAt(i)== '\n')) && 
					(text.charAt(i-1) != ' ' && text.charAt(i-1) != '\n'))
					words += 1;
			if(text.charAt(i) == '\n')
				lines += 1;
		}
		return String.format("File %s has%n%d characters%n%d words%n%d lines",fileName,chars-1,words,lines);
	}

}
