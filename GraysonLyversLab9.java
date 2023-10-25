package labs;

import java.util.Scanner;

/*
course: CSC 191
project: Lab 9  2D Array Recursion
date: 	10/25/2023
author: Grayson Lyvers
purpose: Create a schedule for a competition
*/

public class GraysonLyversLab9 {

	static int[][] timeTable;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			int n = getArrSize(scan);
			timeTable = new int[n][n];
			buildSchedule(n);
			printArr();
			System.out.println("Would you like go again? y/n");
			char reply = scan.next().charAt(0);
			if(reply!='y')
				break;
		}
	}
	
	

	private static void printArr() {
		System.out.println("\t   Player");
		for (int i = 0; i < timeTable.length; i++) {
			if(i == 0)
				System.out.print("\t   ");
			else if(i == 1)
				System.out.print("Day\td1 ");
			else
				System.out.print("\td"+i+" ");
			for (int j = 0; j < timeTable[i].length; j++) {
				System.out.print(timeTable[i][j]+ " ");
			}
			System.out.println();
		}
		
	}



	private static int getArrSize(Scanner scan) {
		while(true) {
			try {
				System.out.println("Please enter a number that is a power of 2:");
				int num = scan.nextInt();
				int temp = num;
				while(temp!=1) {//check if num is a power of 2
					if(temp%2 != 0)
						break;
					temp = temp/2;
				}
				if(temp == 1)
					return num;
				System.out.println("Not a power of 2!");
			}catch(Exception e){
				scan.next();
				System.out.println("Invalid! Please try again.");
			}
		}
	}



	static public void buildSchedule(int n) {
		if (n == 1)
			timeTable[0][0] = 1;
		else {
			buildSchedule(n/2);
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < n/2; j++) {
					timeTable[i][j+n/2] = timeTable[i][j]+n/2;
					timeTable[j+n/2][i] = timeTable[i][j]+n/2;
					timeTable[i+n/2][j+n/2] = timeTable[i][j];
				}
				
			}
		}
	}

}
