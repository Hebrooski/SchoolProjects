package labs;

import java.util.Scanner;

/*
course: CSC 191
project: Lab 8 Array Recursion
date: 	10/18/2023
author: Grayson Lyvers
purpose: Demonstrate recursive algorithms using recursion
*/

public class GraysonLyversLab8 {
	
	public static void main(String[] args) {//keeping main clean
		Scanner scan = new Scanner(System.in);
        int[] a = getUserArr(scan);
        Recursion r = new Recursion(a);
        startMenu(scan,r);
        System.out.println("Goodbye!");
   }

	private static void startMenu(Scanner scan,Recursion r) {//handles user input for the main menu
		while (true) {
			System.out.println("Menu:\n1. rotate array to the left\n2. check if elements in array are sorted\n3. check if all elements in array are equal\na. input new array\ne. exit");
			try {
				String input = scan.next();
				switch(input.charAt(0)){
				case '1':
					runRotate(scan,r);
					break;
				case '2':
					System.out.println();
					runSorted(scan,r);
					break;
				case '3':
					System.out.println();
					System.out.println("Equal: "+r.isEqual());
					break;
				case 'a':
					r.setA(getUserArr(scan));
					break;
				case 'e':
					return;
				default:
					System.out.println("Not an option.");
				}
				System.out.println("\n");
			}catch(Exception e) {
				System.out.println("Invalid input!");
			}
		}
		
	}

	private static void runSorted(Scanner scan, Recursion r) {// handles user input for isSorted
		while(true) {
			System.out.println("Please enter the number of elements you would check if sorted: (zero index)");
			try {
				int n = scan.nextInt();
				if(n>=r.getA().length)
					n=r.getA().length-1;
				System.out.println("Sorted: "+r.isSorted(n));
				break;
			}catch(Exception e) {
				System.out.println("Invalid input!");
				scan.next();
			}
		}
		
	}

	private static void runRotate(Scanner scan, Recursion r) {//handles user input for rotate array
		while(true) {
			System.out.println("Please enter the number of elements you would like rotated 1 to the left:(zero index)");
			try {
				int n = scan.nextInt();
				if(n>=r.getA().length)
					n=r.getA().length-1;
				r.rotateLeft(n);
				int[] a = r.getA();
				System.out.print("[");
				for (int i = 0; i < a.length-1; i++) {
					System.out.printf("%s,",a[i]);
				}
				System.out.println(a[a.length-1]+"]");
				break;
			}catch(Exception e) {
				System.out.println("Invalid input!");
				scan.next();
			}
		}
		
	}

	private static int[] getUserArr(Scanner scan) {//gets the array from user
		int[]a;
		while(true) {
			System.out.println("Please enter the number of element in the array:");
			try {
				int n = scan.nextInt();
				if(n<2) {
					System.out.println("Must be greater than 1 in size!");
					continue;
				}
				a = new int[n];
				System.out.println("Please enter the number of elements in the array:");
				for (int i = 0; i < n; i++) {
					System.out.printf("Please enter element %d of %d:%n",i+1,n);
					try {
						a[i]=scan.nextInt();
					}catch(Exception e) {
						System.out.println("Invalid input! Try again.");
						scan.next();
						i--;
					}
				}
				break;
			}catch(Exception e) {
				System.out.println("Invalid input! Enter a number.");
				scan.next();
			}
			
		}
		return a;
	}

}

class Recursion{
    private int[] a;
    
    //constructor
    public Recursion(int[] array){
        a = array;
    }


    //get and set methods for data members
    public int[] getA(){
	return a;
    }

    public void setA(int[] array){
	a = array;
    }
    
    //some recursive methods for arrays
    // n in these methods will be the number of elements to affect
  
    
    //print array forward
    // n in these methods will be the number of elements to affect
    public void printF(int n){
        if(n>0){
            printF(n-1);
            System.out.print(a[n-1]);
        }
    }
    
    //print array backward
    public void printB(int n){
        if(n>0){
            System.out.print(a[n-1]);
            printB(n-1);
        }
    }
    
    //smallest element
    public int minA(int n){
        if(n==1)
            return a[0];
        return Math.min(minA(n-1), a[n-1]);
    }
    
    //reversing an array
    public void reverseA(){
        reverseA(0, a.length-1);
    }
    
    private void reverseA(int l, int r){
        if(l<r){
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            reverseA(l+1, r-1);
        }
    }
    
    //mode of the int array - int that appears most often
    public int mode(int n){
        if (n==1)
            return a[0];
        int m = mode(n-1);
        int c1 = 0, c2 = 1;
        for (int i = 0; i < n-1; i++) {
            if(a[i]==m)
                c1++;
            else if(a[i]==a[n-1])
                c2++;
        }
        if(c1>c2)
            return m;
        return a[n-1];
    }
    
    public void rotateL(int n){//according to timed testing this is slower than rotate left
        if(n>1){
            int t = a[0];
            a[0] = a[n-1];
            a[n-1] = t;
            rotateL(n-1);
        }
    }
    
    public void rotateLeft(int n) {//rotates n array elements to the left
    	int temp = a[0];//store last value
    	rotateLeftHelp(n-1,a[n]);
    	a[n] = temp;// insert last value
    	
    }
    private void rotateLeftHelp(int n,int temp) {//moves temp value to the left in the array
    	if(n==0) {
    		a[n]=temp;
    		return;
    	}
    	rotateLeftHelp(n-1,a[n]);
    	a[n]=temp;
    }
    
    public boolean isSorted(int n) {//checks if n elements in array are sorted
    	if(n==1)
    		return a[n-1]<a[n];
    	
    	if(a[n-1]<a[n])
    		return true && isSorted(n-1);
    	else
    		return false;//for quick exit from recursive search
    }
    
    
    public boolean isEqual() {//starter method because user does not specify n
    	return isEqual(a.length-1);
    }
    private boolean isEqual(int n) {// checks if n elements in array are equal
    	if(n==1)
    		return a[n-1]==a[n];
    	
    	if(a[n-1]==a[n])
    		return true && isEqual(n-1);
    	else
    		return false;//for quick exit from recursive search
    }
}

