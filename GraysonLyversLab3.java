package labs;

import java.util.Random;
import java.util.Scanner;

//course: CSC 191
//project: Lab 3
//date: 8/30/2023
//author: Grayson Lyvers
//purpose: To build a simulation of the bean machine

/*This program uses an int[] to simulate a ball playing plinko.
 * Where the ball lands is stored inside the int[] with the balls position corresponding 
 * to the index of the int[]. Each ball starts in the center and will either move left or
 * right as it "hits" nails. Each ball will hit at least as many nails as there are slots
 * at the bottom of the plinko board.
 */
public class GraysonLyversLab3 {
	
	private static int[] beanSlots;//use an int[] to store where the balls have landed
	private static int ballNum;//number of balls to drop
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the bean machine! We will simulate the falling of beans!");
		System.out.println();
		while(true) {//loop until user is done playing
			//loop until acceptable ball number is input
			while(true) {
				try {
					System.out.println("Please enter the amount of balls you would like dropped:");
					int reply = scan.nextInt();
					if(reply > 0) {
						ballNum = reply;
						break;
					}
					else
						System.out.println("Number cannot be negative! Please try again.");
				}
				catch(Exception e) {
					scan.nextLine();
					System.out.println("Invalid input! Please try again.");
				}
			}
			//loop until acceptable slot number is input
			while(true) {
				try {
					System.out.println("Please enter the amount of slots you would like:");
					int reply = scan.nextInt();
					if(reply > 0) {
						beanSlots = new int[reply];
						break;
					}
					else
						System.out.println("Number cannot be negative! Please try again.");
				}
				catch(Exception e) {
					scan.nextLine();
					System.out.println("Invalid input! Please try again.");
				}
			}
			
			dropBalls();
			printHisto();
			System.out.println();
			System.out.println("Would you like to play again? y/n");
			char reply = scan.next().charAt(0);
			if(reply != 'y')
				break;
		}
		scan.close();
		System.out.println("Thank you!\n\nGoodbye.");
	}
	
	private static void dropBalls() {
		Random r = new Random();
		System.out.println("Here are the paths the balls took: ");
		//loop for the amount of chosen balls
		for (int i = 0; i < ballNum; i++) {
			System.out.print("\t");
			int curPosition = beanSlots.length/2;// start above the middle slot.
			for (int j = 0; j < beanSlots.length; j++) { // loop to hit slot num of nails
				int direction = r.nextInt(2);//0 = left and 1 = right
				switch(direction) {
					case 0://move left
						System.out.print("L");
						if(curPosition-1>=0) //check to make sure ball stays in bounds
							curPosition--;
						break;
					case 1://move right
						System.out.print("R");
						if(curPosition+1<beanSlots.length)//check to make sure ball stays in bounds
							curPosition++;
						break;
				}
			}
			System.out.println();
			beanSlots[curPosition]++;//add a ball to current slot
			
		}
		System.out.println();
	}
	
	private static void printHisto() {
		System.out.println("Here is a histogram of where each ball landed:\n");
		//first we find the max
		int max = 0;
		for (int i = 0; i < beanSlots.length; i++) {
			if(beanSlots[i]>max) {
				max = beanSlots[i];
			}
		}
		//next we will print out the histogram
		for (int i = max; i > 0; i--) {
			System.out.print(" ");
			for (int j = 0; j < beanSlots.length; j++) {
				if(beanSlots[j]==i) {
					System.out.print("* ");
					beanSlots[j]--;
				}
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		System.out.print(" ");
		for (int i = 1; i <= beanSlots.length; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
