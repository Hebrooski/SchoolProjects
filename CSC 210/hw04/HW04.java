package hw04;

import java.util.Scanner;

//course: CSC210

//project: HW02

//date: 2/18/2022

//author: Grayson Lyvers

//purpose: To build a student records system to record students and sort them based on gpa and 
//         binary search through the array of records

public class HW04 {

	public static void main(String[] fish) {
		StudentRecord[] stusTemp = new StudentRecord[100];
		Scanner scan = new Scanner(System.in);
		System.out.println("Student Records");
		for (int i =0;true;i++) {
			System.out.println("Enter \"Exit\" to see inputed data.\nPlease enter the students info in this order:\nFirstName LastName CreditHours QualityPoints");
			String line = scan.nextLine();
			if (line.toLowerCase().equals("exit"))
				break;
			else {
				String[] args = line.split(" ");
				if(args.length == 4)
					stusTemp[i] = new StudentRecord(args[0]+" "+args[1],Integer.parseInt(args[2]),Integer.parseInt(args[3]));
				else
					System.err.println("Invalid entry. Please follow requested format.");
			}
		}
		StudentRecord[] validStus = buildValidArr(stusTemp);
		Sort sort = new Sort();
		sort.sortGPA(validStus);
		printArr(validStus);
		
		System.out.println("Please enter a GPA to search for: ");
		double gpa = scan.nextDouble();
		int index = sort.binarySearchGPA(validStus, gpa);
		if(index != -1) {
			System.out.printf("Match Found!%nName: %s CreditHours: %d QualityPoints: %d GPA: %.2f",
					validStus[index].getName(),
					validStus[index].getEarnedCh(),
					validStus[index].getQualPts(),
					validStus[index].getGPA());
		}
		else
			System.out.println("No Matching Records.");

	}

	static void printArr(StudentRecord[] arr) {
		System.out.println("Item#\tName\t\tCreditHours\tQualityPoints\tGPA");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d\t%s\t%d\t\t%d\t\t%.2f%n", i, arr[i].getName(), arr[i].getEarnedCh(),
					arr[i].getQualPts(), arr[i].getGPA());
		}
	}

	static StudentRecord[] buildValidArr(StudentRecord[] stus) {
		int size = 0;
		for (int i = 0; i < stus.length; i++) {
			if (stus[i] != null) {
				size++;
			}
		}
		StudentRecord[] validStus = new StudentRecord[size];
		for (int i = 0; i < validStus.length; i++) {
			validStus[i] = stus[i];
		}
		return validStus;
	}

}
