package hw.timer;

public class Sorts {
	
	public static int[] bubbleSort(int[] nums) {
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

	public static int[] selectionSort(int[] nums) {
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

	public static int[] insertionSort(int nums[]) {
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
	

}
