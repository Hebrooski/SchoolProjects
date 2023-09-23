package labs;


import java.util.Scanner;

public class GraysonLyversLab1 {
	
	// course: CSC 191
	// project: Lab 1
	// date: 8/16/2023
	// author: Grayson Lyvers
	// purpose: The purpose of this program is to take an integer input 
	//and print shapes with the height equal to the input
	
	
	public static void main(String[] args) {
		Scanner sncr = new Scanner(System.in);
		System.out.println("Hello! Please enter an integer value:");
		int height = sncr.nextInt();
		
		//loop to print a V formation
		for(int i = 1;i<=height;i++) {
			//leading spaces
			for(int j = 1;j<i;j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			//center spaces
			for(int j = 0;j<height*2-(2*i);j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		System.out.println();
		//print an obtuse triangle
		for (int i = 1; i <= height; i++) {
			//leading spaces
			for (int j = 0; j < height*2-(2*i); j++) {
				System.out.print(" ");
			}
			//incrementing amount of stars printed
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		//print a parallelogram
		for(int i = 0;i<height;i++) {
			//leading spaces
			for(int j = 0;j<i;j++) {
				System.out.print(" ");
			}
			//stars = to height
			for (int j = 0; j < height; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sncr.close();
	}

}
