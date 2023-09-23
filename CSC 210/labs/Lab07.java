package labs;

//course: CSC210

//project: Lab07

//date: 3/25/2022

//author: Grayson Lyvers

//purpose: To get the size of a directory or file.



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack; 

public class Lab07 {
	
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("Please enter the directory you would like the size of:");
			String directory = reader.readLine();
			System.out.printf("%s is %d bytes. Used Queue.%n",directory,getSizeQueue(new File(directory)));
			System.out.printf("%s is %d bytes. Used Stack.%n",directory,getSizeStack(new File(directory)));
		}
		catch(IOException e) {
			
		}
	}
	
	public static long getSizeQueue(File directory) {
		long totalSize = 0;
		Queue<File> q = new PriorityQueue<>();
		q.add(directory);
		while(!q.isEmpty()) {
			File file = q.poll();
			if(file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					if(files[i].isFile()) {
						totalSize += files[i].length();
					}
					else if(files[i].isDirectory()) {
						q.add(files[i]);
					}
				}
			}
			else if(file.isFile()) {
				totalSize += file.length();
			}
		}
		
		return totalSize;
	}
	public static long getSizeStack(File directory) {
		long totalSize = 0;
		Stack<File> q = new Stack<>();
		q.push(directory);
		while(!q.isEmpty()) {
			File file = q.pop();
			if(file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					if(files[i].isFile()) {
						totalSize += files[i].length();
					}
					else if(files[i].isDirectory()) {
						q.push(files[i]);
					}
				}
			}
			else if(file.isFile()) {
				totalSize += file.length();
			}
		}
		
		return totalSize;
	}

}

/*
class DirectorySize {
  public static void main(String[] args) {
    // Prompt the user to enter a directory or a file
    System.out.print("Enter a directory or a file: ");    
    Scanner input = new Scanner(System.in);
    String directory = input.nextLine();
    
    // Display the size
    System.out.println(getSize(new File(directory)) + " bytes");
    input.close();
  }

  public static long getSize(File file) {
    long size = 0; // Store the total size of all files

    if (file.isDirectory()) {
      File[] files = file.listFiles(); // All files and subdirectories
      for (int i = 0; files != null && i < files.length; i++) {
        size += getSize(files[i]); // Recursive call
      }
    }
    else { // Base case
      size += file.length();
    }

    return size;
  }
}
*/