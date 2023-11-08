package labs;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/*
course: CSC 191
project: Lab 10  
date: 	11/1/2023
author: Grayson Lyvers
purpose: Create a calculator GUI
*/

public class GraysonLyversLab10 {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Calculator extends JFrame {

	// Text field to see numbers
	private JTextArea calcJTextField;

	// button grids
	private JPanel numGrid;
	private JPanel opGrid;
	private JPanel clearGrid;

	// buttons
	private JButton oneJButton, twoJButton, threeJButton, fourJButton, fiveJButton, sixJButton, sevenJButton,
			eightJButton, nineJButton, zeroJButton, doubleZeroJButton, plusJButton, minusJButton, timesJButton,
			divideJButton, equalsJButton, decimalJButton, clearJButton, clearAllJButton, turnOffJButton;

	public Calculator() {
		buildUI();
	}

	private void buildUI() {
		// set up window
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		oneJButton = new JButton("1");
		oneJButton.setBounds(20, 60, 45, 45);
		oneJButton.setText("1");
		contentPane.add(oneJButton);

		twoJButton = new JButton("2");
		twoJButton.setBounds(65, 60, 45, 45);
		contentPane.add(twoJButton);

		threeJButton = new JButton("3");
		threeJButton.setBounds(110, 60, 45, 45);
		contentPane.add(threeJButton);

		fourJButton = new JButton("4");
		fourJButton.setBounds(20, 105, 45, 45);
		contentPane.add(fourJButton);

		fiveJButton = new JButton("5");
		fiveJButton.setBounds(65, 105, 45, 45);
		contentPane.add(fiveJButton);

		sixJButton = new JButton("6");
		sixJButton.setBounds(110, 105, 45, 45);
		sixJButton.setText("6");
		contentPane.add(sixJButton);

		sevenJButton = new JButton("7");
		sevenJButton.setBounds(20, 150, 45, 45);
		contentPane.add(sevenJButton);

		eightJButton = new JButton("8");
		eightJButton.setBounds(65, 150, 45, 45);
		contentPane.add(eightJButton);

		nineJButton = new JButton("9");
		nineJButton.setBounds(110, 150, 45, 45);
		contentPane.add(nineJButton);

		zeroJButton = new JButton("0");
		zeroJButton.setBounds(20, 195, 45, 45);
		contentPane.add(zeroJButton);

		doubleZeroJButton = new JButton("00");
		doubleZeroJButton.setBounds(65, 195, 90, 45);
		contentPane.add(doubleZeroJButton);

		plusJButton = new JButton("+");
		plusJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		plusJButton.setBounds(185, 60, 45, 120);
		contentPane.add(plusJButton);

		minusJButton = new JButton("-");
		minusJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		minusJButton.setBounds(250, 60, 45, 45);
		contentPane.add(minusJButton);

		timesJButton = new JButton("*");
		timesJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		timesJButton.setBounds(250, 105, 45, 45);
		contentPane.add(timesJButton);

		divideJButton = new JButton("/");
		divideJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		divideJButton.setBounds(250, 150, 45, 45);
		contentPane.add(divideJButton);

		equalsJButton = new JButton("=");
		equalsJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		equalsJButton.setBounds(250, 195, 45, 45);
		contentPane.add(equalsJButton);

		decimalJButton = new JButton(".");
		decimalJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		decimalJButton.setBounds(185, 195, 45, 45);
		contentPane.add(decimalJButton);

		clearJButton = new JButton("C");
		clearJButton.setBounds(350, 60, 60, 45);
		clearJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contentPane.add(clearJButton);

		clearAllJButton = new JButton("C/A");
		clearAllJButton.setBounds(350, 120, 60, 45);
		//clearAllJButton.setFont(new Font("SansSerif", Font.PLAIN, 18)); becomes ...
		contentPane.add(clearAllJButton);

		turnOffJButton = new JButton("OFF");
		turnOffJButton.setBounds(350, 200, 60, 45);
		//turnOffJButton.setFont(new Font("SansSerif", Font.PLAIN, 18)); becomes ...
		contentPane.add(turnOffJButton);

		numGrid = new JPanel();
		numGrid.setLayout(null);
		numGrid.setBorder(new BevelBorder(BevelBorder.LOWERED));
		numGrid.setBounds(10, 50, 155, 200);
		contentPane.add(numGrid);

		opGrid = new JPanel();
		opGrid.setBorder(new BevelBorder(BevelBorder.LOWERED));
		opGrid.setLayout(null);
		opGrid.setBounds(175, 50, 150, 200);
		contentPane.add(opGrid);

		clearGrid = new JPanel();
		clearGrid.setBorder(new BevelBorder(BevelBorder.LOWERED));
		clearGrid.setLayout(null);
		clearGrid.setBounds(340, 50, 80, 140);
		contentPane.add(clearGrid);

		calcJTextField = new JTextArea();
		calcJTextField.setBounds(10, 10, 420, 30);
		calcJTextField.setEditable(false);
		contentPane.add(calcJTextField);

		setTitle("Calculator");
		setSize(450, 300);
		setVisible(true);

	}

}