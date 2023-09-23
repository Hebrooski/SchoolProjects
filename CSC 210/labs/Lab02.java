package labs;

import java.util.Scanner;

public class Lab02 {

	// course: CSC210

	// project: Lab02

	// date: 1/28/2022

	// author: Grayson Lyvers

	// purpose: To build a submatrix builder and finder of the values within said
	// matrix

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter how many rows to create: ");
		int rows = scan.nextInt();
		int[][] matrix = new int[rows][];
		for (int i = 0; i < matrix.length; i++) {
			System.out.printf("Enter the numbers for row %d:", i + 1);
			String stringyNums = scan.nextLine();
			if(i == 0)
				stringyNums = scan.nextLine();
			matrix[i] = buildRow(stringyNums);
		}
		int[] result = findLargestBlock(matrix);
		System.out.printf("%nThe maximum square submatrix is at (%d, %d) with size %d", result[0], result[1],
				result[2]);

	}

	public static int getNumsInRow(String numsIn) {
		// find the amount of numbers in the string
		int numTotal = 0;
		for (int i = 0; i < numsIn.length(); i++) {
			if (numsIn.charAt(i) == '0' || numsIn.charAt(i) == '1') {
				numTotal++;
			}
		}
		return numTotal;
	}

	public static int[] buildRow(String numsIn) {
		// set the array size to the amount of ints in the string
		int[] nums = new int[getNumsInRow(numsIn)];
		// set the values of the array to the values from the string
		for (int i = 0,j = 0; i < numsIn.length(); i++) {
			if (numsIn.charAt(i) == '0' || numsIn.charAt(i) == '1') {
				nums[j++] = Integer.parseInt(numsIn.charAt(i) + "");
			}
		}
		return nums;
	}

	// this method really just builds the matrix with updated sub matrix
	public static int[] findLargestBlock(int[][] m) {
		int[][] subMatrix = new int[m.length][];
		for (int i = 0; i < m.length; i++) {
			// make multi array dynamiclly sized
			subMatrix[i] = new int[m[i].length];
			for (int j = 0; j < m[i].length; j++) {

				if (i == 0) {
					subMatrix[i][j] = m[i][j];
				} else {
					if (m[i][j] == 1) {
						subMatrix[i][j] = smallestNum(numTest(i, j - 1, subMatrix), numTest(i - 1, j, subMatrix),
								numTest(i - 1, j - 1, subMatrix)) + 1;
					} else {
						subMatrix[i][j] = 0;
					}
				}
			}
		}
		printArray(subMatrix);
		return findArray(subMatrix);
	}

	// make sure the numbers being tested do not cause an exception
	public static int numTest(int r, int c, int[][] array) {
		try {
			return array[r][c];
		} catch (IndexOutOfBoundsException e) {
			return 0;
		}
	}

	// custom min method
	public static int smallestNum(int num1, int num2, int num3) {
		int small = Math.min(num2, num3);
		return Math.min(num1, small);

	}

	// find the index of the highest number
	public static int[] findArray(int[][] array) {
		int[] finalArr = { 0, 0, 0 };
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > finalArr[2]) {
					finalArr[0] = (i - array[i][j]) + 1;
					finalArr[1] = (j - array[i][j]) + 1;
					finalArr[2] = array[i][j];
				}
			}
		}
		return finalArr;
	}

	static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
