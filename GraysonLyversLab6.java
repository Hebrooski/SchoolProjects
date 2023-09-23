package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

//course: 	CSC 191
//project: 	Lab 6
//date: 	9/20/23
//author:	Grayson Lyvers
//purpose: To build a class that can read from a file and create a new class that contains the text ciphered

public class GraysonLyversLab6 {
	
	public static void main(String[] args) {
		MyCipher cipher = new MyCipher();
		try(Scanner scan = new Scanner(System.in)){
			while(true) {
				while(true) {
					System.out.println("Please enter a cipher key:");
					try {
						int key = scan.nextInt();
						if(key>-1) {//check that the key is positive
							cipher.setKey(key);
							break;
						}else
							System.out.println("Must be a positive number!");
					}catch(Exception e) {
						scan.nextLine();
						System.out.println("Invalid! Must be a number!");
					}
				}
				System.out.println("Please enter the file path you would like ciphered");
				cipher.encode(scan.next());
				System.out.println("Would you like to cipher another txt file? y/n");
				char reply = scan.next().charAt(0);
				if(reply!='y')
					break;
			}
			System.out.println("Goodbye!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Please try again:");
		}
		
	}
}

class MyCipher{
	private int key;
	
	//key is implicitly initialized to zero when default constructor is called.
	//Here we are doing it explicitly.
	public MyCipher() {
		super();
		key = 0;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		if(key>-1)
			this.key = key;
		else
			throw new RuntimeException("Key must be a positive number!");
		//using run time exception to avoid complier checks for unhandled exceptions.
	}
	
	public void encode(String filePath) {
		File fileIn = new File(filePath);
		//remove the .txt from the file path and add ciphered after then re-attach the .txt
		File fileOut = new File(filePath.substring(0, filePath.length()-4)+"Ciphered.txt");
		//try with resources, auto closes the scanner and print stream when try block is exited.
		try(Scanner scanIn = new Scanner(fileIn);PrintStream printer = new PrintStream(fileOut)) {
			while(scanIn.hasNext()) {
				String textIn = scanIn.nextLine();//read file line by line
				String textOut = "";
				//add all ciphered characters to textOut
				for (int i = 0; i < textIn.length(); i++) {
					int letter = textIn.charAt(i);
					//check to ensure the characters remain lower case letters
					if(letter==32)//check for space, in the instructions the requirements show with a key of 5 becoming 'e'
						textOut += (char)(letter+64+key);//so, I have moved space to just before 'a'
					else if(letter+key>122)//if the letter goes past 'z' move it back to 'a'
						textOut += (char)(letter-25+key);
					else//cipher as normal
						textOut += (char)(letter+key);
				}
				//print to file line by line
				printer.println(textOut);
			}
			System.out.println("Output complete!");
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be found!");
		}
		
	}
	
	
	
}
