package labs;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
course: CSC 191
project: Lab 11  
date: 	11/8/2023
author: Grayson Lyvers
purpose: Create tic tac toe with a GUI
*/

public class GraysonLyversLab11 {

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

@SuppressWarnings("serial")
class TicTacToe extends JFrame {
	

	// Text field to display current turn and winner outputs
	private JTextField display,turn;

	// button grid
	private JPanel buttonGrid;
	
	//keeps track of the current turn
	private String turnLetter = "X";
	
	// buttons
	private JButton topLButton, topCButton, topRButton, middleLButton, middleCButton, middleRButton, bottomLButton, 
	bottomCButton, bottomRButton;
	
	//virtual game board for easier win condition checking
	private JButton[][] board = new JButton[3][3];

	public TicTacToe() {
		buildUI();
	}

	private void buildUI() {
		// set up window
		Container contentPane = getContentPane();
		BorderLayout layout = new BorderLayout();
		contentPane.setLayout(layout);
		
		//create text fields for output
		display = new JTextField();
		turn = new JTextField("X's turn!");
		turn.setHorizontalAlignment(JTextField.CENTER);
		display.setHorizontalAlignment(JTextField.CENTER);
		display.setEditable(false);
		turn.setEditable(false);
		display.setFont(new Font("SansSerif", Font.PLAIN, 18));
		turn.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contentPane.add(turn,BorderLayout.NORTH);
		contentPane.add(display,BorderLayout.SOUTH);
		
		//create grid
		buttonGrid = new JPanel();
		GridLayout grid = new GridLayout(3,3);
		buttonGrid.setLayout(grid);
		
		//create and add buttons to grid
		topLButton = new JButton(" ");
		topLButton.addActionListener(e->buttonPressed(topLButton));
		topLButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		buttonGrid.add(topLButton);
		
		
		topCButton = new JButton(" ");
		topCButton.addActionListener(e->buttonPressed(topCButton));
		topCButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		buttonGrid.add(topCButton);
		
		topRButton = new JButton(" ");
		topRButton.addActionListener(e->buttonPressed(topRButton));
		topRButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		buttonGrid.add(topRButton);
		
		middleLButton = new JButton(" ");
		middleLButton.addActionListener(e->buttonPressed(middleLButton));
		middleLButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		buttonGrid.add(middleLButton);
		
		middleCButton = new JButton(" ");
		middleCButton.addActionListener(e->buttonPressed(middleCButton));
		middleCButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		buttonGrid.add(middleCButton);
		
		middleRButton = new JButton(" ");
		middleRButton.addActionListener(e->buttonPressed(middleRButton));
		middleRButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		buttonGrid.add(middleRButton);
		
		bottomLButton = new JButton(" ");
		bottomLButton.addActionListener(e->buttonPressed(bottomLButton));
		bottomLButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		buttonGrid.add(bottomLButton);
		
		bottomCButton = new JButton(" ");
		bottomCButton.addActionListener(e->buttonPressed(bottomCButton));
		bottomCButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		buttonGrid.add(bottomCButton);
		
		bottomRButton = new JButton(" ");
		bottomRButton.addActionListener(e->buttonPressed(bottomRButton));
		bottomRButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		buttonGrid.add(bottomRButton);
		
		
		contentPane.add(buttonGrid,BorderLayout.CENTER);
		
		//add buttons to board array for easier score checking
		board[0][0]=topLButton;
		board[0][1]=topCButton;
		board[0][2]=topRButton;
		board[1][0]=middleLButton;
		board[1][1]=middleCButton;
		board[1][2]=middleRButton;
		board[2][0]=bottomLButton;
		board[2][1]=bottomCButton;
		board[2][2]=bottomRButton;
	
		setTitle("Tic Tac Toe");
		setSize(450, 300);
		setVisible(true);

	}
	void buttonPressed(JButton button) {
		if(button.getText().equals("X")||button.getText().equals("O")) { // check to make sure location is available for play
			display.setText("Already chosen, pick a different spot.");
			return;
		}
		display.setText("");
		button.setText(turnLetter);
		if(checkForWin()) { // if winner no need to change turns so return
			return;
		}
		if(turnLetter == "X")
			turnLetter = "O";
		else
			turnLetter = "X";
		turn.setText(String.format("%s's turn!", turnLetter));
	}
	
	boolean checkForWin() {
		//check horizonal
		for (int i = 0; i < board.length; i++) {
			if(board[i][0].getText().equals(turnLetter) && board[i][1].getText().equals(turnLetter) 
					&& board[i][2].getText().equals(turnLetter)) {
				display.setText(String.format("%s is the winner!!",turnLetter));
				return true;
			}
		}
		//check vertical
		for (int i = 0; i < board.length; i++) {
			if(board[0][i].getText().equals(turnLetter) && board[1][i].getText().equals(turnLetter) 
					&& board[2][i].getText().equals(turnLetter)) {
				display.setText(String.format("%s is the winner!!",turnLetter));
				return true;
			}
		}
		
		//check for diagonal
		if(board[0][0].getText().equals(turnLetter) && board[1][1].getText().equals(turnLetter) 
				&& board[2][2].getText().equals(turnLetter)) {
			display.setText(String.format("%s is the winner!!",turnLetter));
			return true;
		}
		if(board[0][2].getText().equals(turnLetter) && board[1][1].getText().equals(turnLetter) 
				&& board[2][0].getText().equals(turnLetter)) {
			display.setText(String.format("%s is the winner!!",turnLetter));
			return true;
		}
		
		return false; // no one has won
	}
	
	

}