package hw08;

//course: CSC210

//project: HW08

//date: 3/30/2022

//author: Grayson Lyvers

//purpose: Read mathmatic expressions and 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class HW08 {
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Please enter an expression:");
			String line = reader.readLine();
			System.out.printf("%s = %d",line,evaluateExpression(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Evaluate an expression */
	public static int evaluateExpression(String expression) {
		// Create operandStack to store operands
		Stack<Integer> operandStack = new Stack<>();

		// Create operatorStack to store operators
		Stack<Character> operatorStack = new Stack<>();

		// Insert blanks around (, ), +, -, /, and *
		expression = insertBlanks(expression);

		// Extract operands and operators
		String[] tokens = expression.split(" ");

		// Phase 1: Scan tokens
		for (int i = 0; i<tokens.length;i++) {
			String token = tokens[i];
			if (token.length() == 0) // Blank space
				continue; // Back to the while loop to extract the next token
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				// Process all +, -, *, / in the top of the operator stack
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
						|| operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '%')) {
					processAnOperator(operandStack, operatorStack);
				}

				// Push the + or - operator into the operator stack
				operatorStack.push(token.charAt(0));
			} else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
				// Process all *, / in the top of the operator stack
				if(!operatorStack.isEmpty()) {
					while ((operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '%') && !operatorStack.isEmpty()) {
						processAnOperator(operandStack, operatorStack);
					}
				}

				// Push the * or / operator into the operator stack
				operatorStack.push(token.charAt(0));
			} else if (token.trim().charAt(0) == '(') {
				operatorStack.push('('); // Push '(' to stack
			} else if (token.trim().charAt(0) == ')') {
				// Process all the operators in the stack until seeing '('
				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.pop(); // Pop the '(' symbol from the stack
			}
			else if(token.trim().charAt(0) == '^') {
				operatorStack.push(token.trim().charAt(0));
				operandStack.push(Integer.valueOf(tokens[++i]));
				processAnOperator(operandStack, operatorStack);
			}
			else { // An operand scanned
				// Push an operand to the stack
				operandStack.push(Integer.valueOf(token));
			}
		}

		// Phase 2: process all the remaining operators in the stack
		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}

		// Return the result
		return operandStack.pop();
	}

	/**
	 * Process one operator: Take an operator from operatorStack and apply it on the
	 * operands in the operandStack
	 */
	public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		//System.out.println(operandStack);
		//System.out.println(operatorStack);
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+')
			operandStack.push(op2 + op1);
		else if (op == '-')
			operandStack.push(op2 - op1);
		else if (op == '*')
			operandStack.push(op2 * op1);
		else if (op == '/')
			operandStack.push(op2 / op1);
		else if(op == '%') 
			operandStack.push(op2 % op1);
		else if(op == '^') 
			operandStack.push((int)Math.pow(op2, op1));
			
	}

	public static String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
					|| s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '%' || s.charAt(i) == '^')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}

		return result;
	}
}