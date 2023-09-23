package hw10;

import java.util.Arrays;
import java.util.Random;

public class HW10 {

	public static void main(String[] args) {

		int[] sizes = { 50000, 100000, 150000, 200000, 250000, 300000 };
		String[][] results = new String[7][6];
		String[] temp = { "Size", "Selection", "Merge", "Quick", "Heap", "Radix" };
		results[0] = temp;
		temp = null;
		StopWatch timer = new StopWatch();
		for (int i = 0; i < sizes.length; i++) {
			results[i + 1][0] = sizes[i] + "";
			int[][] arrs = buildArrs(sizes[i]);
			timer.start();
			selectionSort(arrs[0]);
			timer.stop();
			results[i + 1][1] = String.format("%d mili", timer.timeElapsed());
			timer.start();
			mergeSort(arrs[1], 0, arrs[1].length - 1);
			timer.stop();
			results[i + 1][2] = String.format("%d mili", timer.timeElapsed());
			timer.start();
			quickSort(arrs[2], 0, arrs[2].length - 1);
			timer.stop();
			results[i + 1][3] = String.format("%d mili", timer.timeElapsed());
			timer.start();
			heapSort(arrs[3]);
			timer.stop();
			results[i + 1][4] = String.format("%d mili", timer.timeElapsed());
			timer.start();
			radixSort(arrs[4],arrs[4].length);
			timer.stop();
			results[i + 1][5] = String.format("%d mili", timer.timeElapsed());

			System.out.printf("Test of size %s completed! Progress is %.0f%% %n", sizes[i],
					(((double) (i + 1)) / sizes.length) * 100);
		}
		System.out.println();
		for (String[] line : results) {
			for (String output : line) {
				System.out.printf("%s\t", output);
			}
			System.out.println();
		}
	}

	public static int[][] buildArrs(int size) {
		int[][] arrs = new int[5][];
		arrs[0] = buildUnsortedArr(size);
		arrs[1] = Arrays.copyOf(arrs[0], arrs[0].length);
		arrs[2] = Arrays.copyOf(arrs[0], arrs[0].length);
		arrs[3] = Arrays.copyOf(arrs[0], arrs[0].length);
		arrs[4] = Arrays.copyOf(arrs[0], arrs[0].length);
		return arrs;
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

	static int[] buildUnsortedArr(int arraySize) {
		int[] nums = new int[arraySize];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new Random().nextInt(100000);
		}
		return nums;
	}

	static void mergeSort(int array[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	static void merge(int array[], int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int L[] = new int[n1];
		int M[] = new int[n2];

		for (int i = 0; i < n1; i++)
			L[i] = array[p + i];
		for (int j = 0; j < n2; j++)
			M[j] = array[q + 1 + j];
		int i = 0;
		int j = 0;
		int k = p;
		while (i < n1 && j < n2) {
			if (L[i] <= M[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = M[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			array[k] = M[j];
			j++;
			k++;
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	public static void heapSort(int arr[]) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}
	static void heapify(int arr[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && arr[l] > arr[largest])
			largest = l;
		if (r < n && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, n, largest);
		}
	}
	
	static void countingSort(int array[], int size, int place) {
	    int[] output = new int[size + 1];
	    int max = array[0];
	    for (int i = 1; i < size; i++) {
	      if (array[i] > max)
	        max = array[i];
	    }
	    int[] count = new int[max + 1];
	    for (int i = 0; i < max; ++i)
	      count[i] = 0;
	    for (int i = 0; i < size; i++)
	      count[(array[i] / place) % 10]++;
	    for (int i = 1; i < 10; i++)
	      count[i] += count[i - 1];
	    for (int i = size - 1; i >= 0; i--) {
	      output[count[(array[i] / place) % 10] - 1] = array[i];
	      count[(array[i] / place) % 10]--;
	    }
	    for (int i = 0; i < size; i++)
	      array[i] = output[i];
	  }
	  static int getMax(int array[], int n) {
	    int max = array[0];
	    for (int i = 1; i < n; i++)
	      if (array[i] > max)
	        max = array[i];
	    return max;
	  }
	 static void radixSort(int array[], int size) {
	    int max = getMax(array, size);
	    for (int place = 1; max / place > 0; place *= 10)
	      countingSort(array, size, place);
	  }

}
