package hw04;

public class Sort implements SortInterface {

	
	public void sortGPA(StudentRecord[] stus) {
		for (int i = 0; i < stus.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < stus.length; j++) {
				if (stus[j].getGPA() < stus[index].getGPA()) { // searching for lowest index
					index = j;
				}
			}
			StudentRecord lowerGPA = stus[index];
			stus[index] = stus[i];
			stus[i] = lowerGPA;
		}
		
	}
	
	public int binarySearchGPA(StudentRecord[] stu, double gpa) {
		int start = 0;
		int end = stu.length-1;
		
		
		
		while(start<=end) {
			int mid = (start+end)/2;
			double currentGPA = Double.parseDouble(String.format("%.2f", stu[mid].getGPA()));
			if(currentGPA > gpa)
				end = mid-1;
			else if(currentGPA == gpa)
				return mid;
			else
				start = mid+1;
		}
		return -1;
	}

}
