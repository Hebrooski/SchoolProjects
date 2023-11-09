package assignments.hw;

import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/*
course: CSC 191
project: HW 6 
date: 	11/9/2023
author: Grayson Lyvers
purpose: Create a function calculator with GUI
*/

public class GraysonLyversHW6 {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}

@SuppressWarnings("serial")
class Calculator extends JFrame {

	// Text field to see numbers
	private JTextField calcJTextField;

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
		oneJButton.addActionListener(e->buttonPressed(oneJButton));
		contentPane.add(oneJButton);

		twoJButton = new JButton("2");
		twoJButton.setBounds(65, 60, 45, 45);
		twoJButton.addActionListener(e->buttonPressed(twoJButton));
		contentPane.add(twoJButton);

		threeJButton = new JButton("3");
		threeJButton.setBounds(110, 60, 45, 45);
		threeJButton.addActionListener(e->buttonPressed(threeJButton));
		contentPane.add(threeJButton);

		fourJButton = new JButton("4");
		fourJButton.setBounds(20, 105, 45, 45);
		fourJButton.addActionListener(e->buttonPressed(fourJButton));
		contentPane.add(fourJButton);

		fiveJButton = new JButton("5");
		fiveJButton.setBounds(65, 105, 45, 45);
		fiveJButton.addActionListener(e->buttonPressed(fiveJButton));
		contentPane.add(fiveJButton);

		sixJButton = new JButton("6");
		sixJButton.setBounds(110, 105, 45, 45);
		sixJButton.addActionListener(e->buttonPressed(sixJButton));
		contentPane.add(sixJButton);

		sevenJButton = new JButton("7");
		sevenJButton.setBounds(20, 150, 45, 45);
		sevenJButton.addActionListener(e->buttonPressed(sevenJButton));
		contentPane.add(sevenJButton);

		eightJButton = new JButton("8");
		eightJButton.setBounds(65, 150, 45, 45);
		eightJButton.addActionListener(e->buttonPressed(eightJButton));
		contentPane.add(eightJButton);

		nineJButton = new JButton("9");
		nineJButton.setBounds(110, 150, 45, 45);
		nineJButton.addActionListener(e->buttonPressed(nineJButton));
		contentPane.add(nineJButton);

		zeroJButton = new JButton("0");
		zeroJButton.setBounds(20, 195, 45, 45);
		zeroJButton.addActionListener(e->buttonPressed(zeroJButton));
		contentPane.add(zeroJButton);

		doubleZeroJButton = new JButton("00");
		doubleZeroJButton.setBounds(65, 195, 90, 45);
		doubleZeroJButton.addActionListener(e->buttonPressed(doubleZeroJButton));
		contentPane.add(doubleZeroJButton);

		plusJButton = new JButton("+");
		plusJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		plusJButton.setBounds(185, 60, 45, 120);
		plusJButton.addActionListener(e->buttonPressed(plusJButton));
		contentPane.add(plusJButton);

		minusJButton = new JButton("-");
		minusJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		minusJButton.setBounds(250, 60, 45, 45);
		minusJButton.addActionListener(e->buttonPressed(minusJButton));
		contentPane.add(minusJButton);

		timesJButton = new JButton("*");
		timesJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		timesJButton.setBounds(250, 105, 45, 45);
		timesJButton.addActionListener(e->buttonPressed(timesJButton));
		contentPane.add(timesJButton);

		divideJButton = new JButton("/");
		divideJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		divideJButton.setBounds(250, 150, 45, 45);
		divideJButton.addActionListener(e->buttonPressed(divideJButton));
		contentPane.add(divideJButton);

		equalsJButton = new JButton("=");
		equalsJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		equalsJButton.setBounds(250, 195, 45, 45);
		equalsJButton.addActionListener(e->calc());
		contentPane.add(equalsJButton);

		decimalJButton = new JButton(".");
		decimalJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		decimalJButton.setBounds(185, 195, 45, 45);
		decimalJButton.addActionListener(e->buttonPressed(decimalJButton));
		contentPane.add(decimalJButton);

		clearJButton = new JButton("C");
		clearJButton.setBounds(350, 60, 60, 45);
		clearJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		clearJButton.addActionListener(e->clearLast());
		contentPane.add(clearJButton);

		clearAllJButton = new JButton("C/A");
		clearAllJButton.setBounds(350, 120, 60, 45);
		clearAllJButton.addActionListener(e->clearAll());
		//clearAllJButton.setFont(new Font("SansSerif", Font.PLAIN, 18)); becomes ...
		contentPane.add(clearAllJButton);

		turnOffJButton = new JButton("OFF");
		turnOffJButton.setBounds(350, 200, 60, 45);
		turnOffJButton.addActionListener(e->off());
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

		calcJTextField = new JTextField();
		calcJTextField.setBounds(10, 10, 420, 30);
		calcJTextField.setEditable(false);
		calcJTextField.setHorizontalAlignment(JTextField.RIGHT);
		contentPane.add(calcJTextField);

		setTitle("Calculator");
		setSize(450, 300);
		setVisible(true);

	}
	
	private void calc() {
		try {
			String text = calcJTextField.getText();
			//add spaces to the operators for string splitting
			if(text.contains("*"))
				text = text.replace("*", " * ");
			if(text.contains("+"))
				text = text.replace("+", " + ");
			if(text.contains("-"))
				text = text.replace("-", " - ");
			if(text.contains("/"))
				text = text.replace("/", " / ");
			String[] temp = text.split(" ");
			//using an arraylist so that when i remove indexes i'm not left will nulls. Also the shifting of the elements is auto-handled
			ArrayList<String> equation = new ArrayList<>();
			for (int i = 0; i < temp.length; i++) {
				equation.add(temp[i]);
			}
			//we reduce the equation down to a single result
			while(equation.size()>1) {
				//complete all the multiplication operations on the equation
				while(equation.contains("*")) {
					int index = equation.indexOf("*");
					double num1 = Double.parseDouble(equation.get(index-1));
					double num2 = Double.parseDouble(equation.get(index+1));
					equation.set(index, (num1*num2)+"");
					equation.remove(index-1);
					equation.remove(index);
				}
				equation.remove("");//remove any possible empty strings
				//complete all the division operations on the equation
				while(equation.contains("/")) {
					int index = equation.indexOf("/");
					double num1 = Double.parseDouble(equation.get(index-1));
					double num2 = Double.parseDouble(equation.get(index+1));
					equation.set(index, (num1/num2)+"");
					equation.remove(index-1);
					equation.remove(index);
				}
				equation.remove("");
				//complete all the addition operations on the equation
				while(equation.contains("+")) {
					int index = equation.indexOf("+");
					double num1 = Double.parseDouble(equation.get(index-1));
					double num2 = Double.parseDouble(equation.get(index+1));
					equation.set(index, (num1+num2)+"");
					equation.remove(index-1);
					equation.remove(index);
				}
				equation.remove("");
				//complete all the subtraction operations on the equation
				while(equation.contains("-")) {
					int index = equation.indexOf("-");
					double num1 = Double.parseDouble(equation.get(index-1));
					double num2 = Double.parseDouble(equation.get(index+1));
					equation.set(index, (num1-num2)+"");
					equation.remove(index-1);
					equation.remove(index);
				}
			}
			calcJTextField.setText(equation.get(0));
		} catch(NumberFormatException e) {
			calcJTextField.setText("Error! Can not have multiple decimal points in one number. Try again.");
		}
		
	}

	void buttonPressed(JButton button) {
		calcJTextField.setText(calcJTextField.getText()+button.getText());
	}
	
	void clearLast() {
		String text = calcJTextField.getText();
		calcJTextField.setText(text.substring(0, text.length()-1));
	}
	void clearAll() {
		calcJTextField.setText(" ");
	}
	void off() {
		if (isDisplayable()) {
            dispose();
        }
	}
	

}