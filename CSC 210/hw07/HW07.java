package hw07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//course: CSC210

//project: HW07

//date: 3/22/2022

//author: Grayson Lyvers

//purpose: To read postfix notation for equations

public class HW07 {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				System.out.println("Enter \"exit\" to stop. Please enter postfix equation:");
				String line = reader.readLine();
				if (line != null && !line.equals("exit")) {
					int result = equationReader(line);
					System.out.printf("The result of %s is %d %n",line,result);
				} else
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int equationReader(String line) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < line.length(); i++) {
			char value = line.charAt(i);
			switch(value) {
				case '+':
					stack.push(stack.pop().intValue()+stack.pop().intValue());break;
				case '*':
					stack.push(stack.pop().intValue()*stack.pop().intValue());break;
				case '-':
					int second = stack.pop().intValue();
					int first = stack.pop().intValue();
					stack.push(first-second);break;
				case '/':
					int second2 = stack.pop().intValue();
					int first2 = stack.pop().intValue();
					stack.push(first2/second2);break;
				default:
					try {
						stack.push(Integer.parseInt(value+""));
					}catch(NumberFormatException e) {
					//	System.out.printf("Value was [%c], not a number. %n",value);
					}
			}
		}
		return stack.pop();
	}

}
