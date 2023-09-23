package hw.timer;

import java.util.Random;

//course: CSC210

//project: HW02

//date: 1/29/2022

//author: Grayson Lyvers

//purpose: To build a stopwatch and test the speed different sorting methods

public class HW02 {
	public static void main(String[] args) throws InterruptedException {
		int[] arr = buildUnsortedArr();
		StopWatch timer = new StopWatch();
		bubbleSort(arr);
		timer.stop();
		timer.timeElapsed("Bubble Sorting");
		// Reset the array to original unsorted state
		arr = buildUnsortedArr();
		timer.start();
		selectionSort(arr);
		timer.stop();
		timer.timeElapsed("Selection Sorting");
		// Reset the array to original unsorted state
		arr = buildUnsortedArr();
		timer.start();
		insertionSort(arr);
		timer.stop();
		timer.timeElapsed("Insertion Sorting");

	}

	static int[] bubbleSort(int[] nums) {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
					swapped = true;
				}
			}
		}
		return nums;
	}

	static int[] selectionSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[index]) { // searching for lowest index
					index = j;
				}
			}
			int smallerNumber = nums[index];
			nums[index] = nums[i];
			nums[i] = smallerNumber;
		}
		return nums;
	}

	static int[] insertionSort(int nums[]) {
		int n = nums.length;
		for (int j = 1; j < n; j++) {
			int key = nums[j];
			int i = j - 1;
			while ((i > -1) && (nums[i] > key)) {
				nums[i + 1] = nums[i];
				i--;
			}
			nums[i + 1] = key;
		}
		return nums;
	}

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

	/*
	 * build an array of random numbers. I am using a seed system to produce the
	 * same random numbers every time the array is built.
	 */
	static int[] buildUnsortedArr() {
		int[] nums = new int[100000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new Random(i).nextInt(Integer.MAX_VALUE);
		}
		return nums;
	}
}
