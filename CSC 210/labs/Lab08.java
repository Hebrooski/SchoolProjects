package labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

//course: CSC210

//project: Lab08

//date: 4/1/2022

//author: Grayson Lyvers

//purpose: To count the amount of times a letter appears in a string.

public class Lab08 {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter \"exit\" to stop the program or enter a line to count the occurance of letters:");
			try {
				String line = reader.readLine();
				if (line.equals("exit") || line.length() == 0)
					break;
				else
					formattedPrinter(occuranceCounter(line));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("System exit. Goodbye!");
	}

	private static void formattedPrinter(HashMap<String, Integer> occur) {
		Set<String> letters = occur.keySet();
		StringBuilder formattedLetters = new StringBuilder();
		int highestCount = 0;
		for (String letter : letters) {
			int count = occur.get(letter).intValue();
			if (count > highestCount)
				highestCount = count;
		}
		for (String letter : letters) {
			if (occur.get(letter) == highestCount) {
				if (formattedLetters.length() == 0)
					formattedLetters.append(letter);
				else
					formattedLetters.append(", " + letter);

			}
		}

		if (formattedLetters.length() > 1)
			System.out.printf("The letters [%s] appeared %d times in your string!%n", formattedLetters.toString(),highestCount);
		else
			System.out.printf("The letter [%s] appeared %d times in your string!%n", formattedLetters.toString(),highestCount);
	}

	private static HashMap<String, Integer> occuranceCounter(String line) {
		HashMap<String, Integer> occur = new HashMap<>();
		for (int i = 0; i < line.length(); i++) {
			String letter = (line.charAt(i) + "").matches("[a-zA-Z]") ? (line.charAt(i) + "").toLowerCase() : null;
			if (letter != null && occur.containsKey(letter)) {
				int count = occur.get(letter);
				occur.put(letter, ++count);
			} else {
				if (letter != null)
					occur.put(letter, 1);
			}
		}
		return occur;
	}

}
