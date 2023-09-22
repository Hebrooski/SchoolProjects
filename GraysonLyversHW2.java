package assignments.hw2;

import java.util.Random;
import java.util.Scanner;

	//course: CSC 191
	// project: HW 2
	// date: 8/29/2023
	// author: Grayson Lyvers
	// purpose: To create a card matching game where a user can progressively
 	// reveal matching pairs of cards until all pairs have been matched

public class GraysonLyversHW2 {
	
	//store the numbers on each card
	private static int[][] numBoard;
	//store the cards that have been matched and reveled
	private static boolean[][] foundBoard;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Number Matching Cards!\n\n"+
				"In this game you will be flipping two cards on the board at a time"+
				"\nin order to try and reveal matching pairs!");
		//main game loop begins
		while(true) {
			do {//loop until numBoard and foundBoard are initialized
				try {
					System.out.println("Please choose a game board size. (an even number between 2 and 14):");
					int size = scan.nextInt();
					// check to confirm input is even
					if(size%2 == 0 && size > 1 && size <15) {
						numBoard = new int[size][size];
						foundBoard = new boolean[size][size];
					}
					else if(size%2 != 0) {
						System.out.println("Odd number input. Please enter an even number!");
					}
					else
						System.out.println("Invalid board size. Please try again.");
				}catch(Exception e) {
					System.out.println("Invalid input!");
					scan.next();
				}	
			}while(numBoard == null && foundBoard == null);
			
			initNumBoard();
			printGameBoard();
			while(gameCheck()) {
				playRound(scan);
				printGameBoard();
			}
			
			System.out.println("You Win!");
			System.out.println("Would you like to play again? y/n");
			if(scan.next().toLowerCase().charAt(0)=='y')
				System.out.println("Restarting... \n");
			else
				break;
		}
		System.out.println("Thank you!\n\nGoodbye.");
		scan.close();
	}
	
	private static void playRound(Scanner scan) {
		System.out.println();
		int y1;//x and y values exist outside loop scopes
		int x1;
		int y2;
		int x2;
		while(true) {// loop until acceptable input is found
			try {
				System.out.println("Please enter a coordinate to reveal, space seperated: y x");
				y1 = scan.nextInt()-1;
				x1 = scan.nextInt()-1;
				if(y1 >= numBoard.length || y1<0) {
					System.out.println("Invalid y input! Please try again.");
				}
				else if(x1 >= numBoard.length || x1<0) {
					System.out.println("Invalid x input! Please try again.");
				}
				else if(foundBoard[y1][x1]) {
					System.out.println("Invalid input! Coordinated has already been matched.");
				}
				else
					break;
			}catch(Exception e) {
				System.out.println("Invalid input! Please try again.");
				scan.nextLine();
			}
		}
		while(true) {// loop until acceptable input is found
			try {
				System.out.println("Please enter another coordinate to reveal, space seperated: y x");
				y2 = scan.nextInt()-1;
				x2 = scan.nextInt()-1;
				if(y2 >= numBoard.length || y2<0) {
					System.out.println("Invalid y input! Please try again.");
				}
				else if(x2 >= numBoard.length || x2<0) {
					System.out.println("Invalid x input! Please try again.");
				}
				else if(y1 == y2 && x1 == x2)//coordinates cannot be the same
					System.out.println("Second coordinate cannot be the same as the first! Try again.");
				else if(foundBoard[y2][x2]) {
					System.out.println("Invalid input! Coordinated has already been matched.");
				}
				else
					break;
			}catch(Exception e) {
				System.out.println("Invalid input! Please try again.");
				scan.nextLine();
			}
		}
		
		if(numBoard[y1][x1] == numBoard[y2][x2]) {
			foundBoard[y1][x1] = true;
			foundBoard[y2][x2] = true;
		}//using the foundBoard to track the matched pairs
		else {
			System.out.printf("No match! (%d,%d) = %d & (%d,%d) = %d%n",y1+1,x1+1,
					numBoard[y1][x1],y2+1,x2+1,numBoard[y2][x2]);
		}
		
	}

	private static boolean gameCheck() {//check if there are any pairs left to find
		int totalNums = 0;
		for (int i = 0; i < foundBoard.length; i++) {
			for (int j = 0; j < foundBoard[i].length; j++) {
				if(!foundBoard[i][j])
					totalNums++;
			}
		}
		return totalNums>0;
	}

	private static void initNumBoard() {
		Random r = new Random();
		for (int i = 0; i < numBoard.length; i++) {
			for (int j = 0; j < numBoard[i].length; j++) {
				if(numBoard[i][j] == 0) {
					int pairNum = r.nextInt(8)+1;
					numBoard[i][j] = pairNum;
					boolean search = true;//signal for brute search
					//random search max 10 tries
					for (int k = 0; k < 10; k++) {
						int x = r.nextInt(numBoard.length);
						int y = r.nextInt(numBoard.length);
						if(numBoard[x][y] == 0) {
							numBoard[x][y] = pairNum;
							search = false;
							break;
						}
					}
					//start a brute search
					if(search) {
						for (int a = 0; a < numBoard.length; a++) {
							for (int b = 0; b < numBoard[a].length; b++) {
								if(numBoard[a][b] == 0) {
									numBoard[a][b] = pairNum;
								}	
							}
						}
					}
				}
			}
		}	
	}

	private static void printGameBoard() {
		//print header
		System.out.print("    ");
		for (int i = 0; i < numBoard.length; i++) {
			System.out.print((i+1)+"    ");
		}
		System.out.println();
		System.out.print("  --");
		for (int i = 0; i < numBoard.length; i++) {
			System.out.print("----");
		}
		System.out.println("--");//end header
		//print each game board line
		for (int i = 0; i < numBoard.length; i++) {
			System.out.print((i+1)+" | ");
			for (int j = 0; j < numBoard[i].length; j++) {
				if(foundBoard[i][j])
					System.out.print(numBoard[i][j]+"    ");
				else
					System.out.print("*    ");
			}
			System.out.println("\n");
		}
	}

}
