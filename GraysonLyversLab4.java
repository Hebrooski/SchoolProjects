package labs;

import java.util.Scanner;

//course: CSC 191
//project: Lab 4
//date: 9/6/2023
//author: Grayson Lyvers
//purpose: to build a command line tic tac toe game.

public class GraysonLyversLab4 {

	private static String[][] board = new String[3][3];
	private static int[] wins = new int[3];//0 for O wins, 1 for O wins, and 2 for draws
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe!! X and O will take turns placing themselves on the board.\n"
				+ "Three in a row means you're the winner!!\nX will go first!");
		String turn = "X";//set turn for easier turn management
		//multi game loop
		while(true) {
			while(true) {//main game loop
				printBoard();
				//board spot selection loop
				while(true) {
					int row;
					int column;
					while(true) {//row selection loop 
						System.out.printf("%nPlayer %s please select a row (1, 2, or 3):",turn);
						try {
							row = scan.nextInt()-1;
							if(row>2 || row<0) {
								System.out.println("\nInvalid Input must be 1, 2, or 3!");
							}
							else
								break;
						}catch(Exception e){
							System.out.println("\nInvalid Input must be 1, 2, or 3!");
							scan.nextLine();
						}
					}//end of row loop
					while(true) {//column selection loop 
						System.out.printf("%nPlayer %s please select a column (1, 2, or 3):",turn);
						try {
							column = scan.nextInt()-1;
							if(column>2 || column<0) {
								System.out.println("\nInvalid Input must be 1, 2, or 3!");
							}
							else
								break;
						}catch(Exception e){
							System.out.println("\nInvalid Input must be 1, 2, or 3!");
							scan.nextLine();
						}
					}//end of column loop
					if(board[row][column]==null) {//make sure the space is available 
						board[row][column] = turn;
						break;
					}
					else
						System.out.println("\nBoard location has already been picked! Please try again.");
				}//end of selection loop
				if(checkForWin()) {
					System.out.printf("%nCongragulations to %s for winning!%n",turn);
					if(turn.equals("X"))
						wins[0]++;
					else
						wins[1]++;
					
					break;
				}
				if(checkForDraw()) {
					System.out.println("It's a draw!");
					wins[2]++;
					break;
				}
				if(turn.equals("X"))//change the turn
					turn = "O";
				else
					turn = "X";
			}//end of main game loop
			System.out.println("Would you like to play again? y/n");
			char reply = scan.next().toLowerCase().charAt(0);
			if(reply == 'n')
				break;	
			System.out.println("Replaying... \n");
			board=new String[3][3];//reset the board with an array of nulls
		}//end of multi game loop
		System.out.printf("Thank you for playing! %nX won %d times! O won %d times! The game ended in a draw %d times!%n",
				wins[0],wins[1],wins[2]);
		System.out.println("Goodbye!");
		scan.close();
	}

	private static boolean checkForDraw() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]==null)
					return false;
			}
		}
		return true;
	}

	private static boolean checkForWin() {//surround all checks with individual tries to prevent null pointer 
		try {
			//check first for horizontal victories
			for (int i = 0; i < board.length; i++) {
				if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]))
					return true;
			}
		}catch(NullPointerException e) {}
		try {
			//next check for vertical victories 
			for (int i = 0; i < board.length; i++) {
				if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]))
					return true;
			}
		}catch(NullPointerException e){}
		// next we need to check both diagonal direction
		try {
			if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
				return true;
		}catch(NullPointerException e){}
		try {
			if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
				return true;
		}catch(NullPointerException e){}
		//if there are no victories return false
		return false;
		
	}

	//print the board, if a value in the 2D array is null print a space to show an empty spot
	private static void printBoard() {
		for (int i = 0; i < board.length; i++) {
			System.out.println("----------------");
			for (int j = 0; j < board[i].length; j++) {
				System.out.print("|");
				if(board[i][j]==null) {
					System.out.print("   ");
				}
				else
					System.out.printf(" %s ",board[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println("----------------");
		
	}
	
	
}
