package assignments.hw2;

import java.util.Random;
import java.util.Scanner;

public class GraysonLyversHW3 {

	// course: CSC 191
	// project: HW 3
	// date: 9/14/2023
	// author: Grayson Lyvers
	// purpose: To identify 4 consecutive numbers in a randomized 2D array

	/*
	 * This program is designed to build a 2D array with bounds specified by the
	 * user. It then fills each index with a random number. After that it will check
	 * if there are four consecutive numbers anywhere in the array. If the first
	 * attempt does not produce a true matrix the user will be asked if they would
	 * like for the program to generate matrixes with the current bounds until a
	 * true one is found. After that the user is asked if they would like to set new
	 * bounds for the array and the process repeats until the user says they are
	 * done.
	 */
	private static int[][] numbers;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Please enter rows and columns of a 2D array:");
			int rows = 0;
			int columns = 0;
			while (true) {
				try {
					System.out.println("Number of rows:");
					rows = scan.nextInt();
					if (rows > 3)
						break;
					else
						System.out.println("Please choose a number greater than 3!");
				} catch (Exception e) {
					System.out.println("Error! Please try again.");
				}
			}
			while (true) {
				try {
					System.out.println("Number of columns:");
					columns = scan.nextInt();
					if (columns > 3)
						break;
					else
						System.out.println("Please choose a number greater than 3!");
				} catch (Exception e) {
					System.out.println("Error! Please try again.");
				}
			}
			numbers = new int[rows][columns];
			randomizeNumbers();
			System.out.println("\n");
			printNumbers();
			System.out.println();
			if (checkNumbers())
				System.out.println("Matrix contains four consecutive numbers of the same value!");
			else {// if matrix is does not contain a set of four, offer to run until a matrix with
					// a set of four
					// is found. Hopefully this makes it easier to grade and to test.
				System.out.println("Matrix does not contain four consecutive numbers.");
				System.out.println("Would you like to run until a consecutive matrix at current size is found? y/n:");
				char reply = scan.next().charAt(0);
				if (reply == 'y') {
					int runs = 0;
					do {// generate new matrixes until a consecutive match is found.
						randomizeNumbers();
						System.out.println("\n");
						printNumbers();
						runs++;
					} while (!checkNumbers());
					System.out.println("\nMatrix contains four consecutive numbers of the same value!");
					System.out.println("It took " + runs + " attempts to find a true matrix.");
				}
			}
			System.out.println("\nWould you like to run again with a new matrix? y/n:");
			char reply = scan.next().charAt(0);
			if (!(reply == 'y'))
				break;
		}
		System.out.println("Goodbye");
		scan.close();
	}

	private static boolean checkNumbers() {
		/*
		 * To maximize efficiency there is one loop which searches 4x4 blocks looking
		 * for matching patterns of numbers
		 */
		for (int r = 0; r < numbers.length; r++) {
			for (int c = 3; c < numbers[r].length; c++) {// start at 3 to check for four at the same time
				// check horizontal
				if (numbers[r][c - 3] == numbers[r][c - 2] && numbers[r][c - 2] == numbers[r][c - 1]
						&& numbers[r][c - 3] == numbers[r][c]) {
					return true;
				}

				if (r + 3 < numbers.length) {// check diagonals
					if (numbers[r][c - 3] == numbers[r + 1][c - 2] && numbers[r + 1][c - 2] == numbers[r + 2][c - 1]
							&& numbers[r][c - 3] == numbers[r + 3][c]) {// left to right
						return true;
					}
					if (numbers[r + 3][c - 3] == numbers[r + 2][c - 2] && numbers[r + 2][c - 2] == numbers[r + 1][c - 1]
							&& numbers[r][c] == numbers[r + 3][c - 3]) {/// right to left
						return true;
					}
					for (int i = 3; i >= 0; i--)// scan the block for vertical sets
						if (numbers[r][c - i] == numbers[r + 1][c - i] && numbers[r + 1][c - i] == numbers[r + 2][c - i]
								&& numbers[r][c - i] == numbers[r + 3][c - i]) {// vertical,
							return true;
						}
				}
			}
		}
		return false;// if we make it here, all are false
	}

	private static void randomizeNumbers() {// insert random numbers into the array
		Random rand = new Random();
		for (int r = 0; r < numbers.length; r++) {
			for (int c = 0; c < numbers[r].length; c++) {
				numbers[r][c] = rand.nextInt(9);
			}
		}

	}

	static void printNumbers() {
		for (int i = 0; i < numbers.length; i++) {
			for (int c = 0; c < numbers[i].length; c++) {
				System.out.print(numbers[i][c] + " ");
			}
			System.out.println();
		}
	}
}
