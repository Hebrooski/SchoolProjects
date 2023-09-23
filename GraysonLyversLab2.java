package labs;

import java.util.Scanner;

//course: CSC 191
//project: Lab 2
//date: 8/23/2023
//author: Grayson Lyvers
//purpose: to practice creating objects that contain private attributes. In the program 
// 		we create rectangles on a grid and use objects to represent them in a program.

public class GraysonLyversLab2 {
	
	/*
	 * 1. Create a default rectangle object named r1.
	 * 2. Allow the user to set the values for a rectangle object named r2
	 * 3. Print the area and perimeter of each rectangle.
	 * 4. Test to see if r1 contains r2 and output result.
	 * 5. Allow the user to specify a point to see if it is inside r1 or r2 and output result.
	 * 6. Print both r1 & r2.
	 * 7. Allow the user to change the data field values for r1
	 * 8. Repeat steps 3, 4, and 5 above.
	 * 9. Print both objects again
	 */
	
	
	public static void main(String[] args) {
		Rectangle2D r1 = new Rectangle2D();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the the cordinates of the center of the "
				+ "rectangle r2, aswell as the height and width of the rectangle. "
				+ "\nEX: x y height width");
		Rectangle2D r2 = new Rectangle2D(scan.nextDouble(),scan.nextDouble(),
				scan.nextDouble(),scan.nextDouble());
		System.out.println();
		//print the area of each rectangle
		System.out.println("Area of rectangle 1: "+r1.getArea());
		System.out.println("Area of rectangle 2: "+r2.getArea());
		System.out.println();
		//print the perimeter of each rectangle
		System.out.println("Perimeter of rectangle 1: "+r1.getPerimeter());
		System.out.println("Perimeter of rectangle 2: "+r2.getPerimeter());
		System.out.println();
		//Print out the results of testing if r1 contains r2
		System.out.println("Rectangle 1 contains Rectangle 2: "+r1.contains(r2));
		System.out.println();
		//Test if the user provided coordinates are inside r1 or r2
		System.out.println("Please enter x and y coordinates to see if they "
				+ "are inside rectangle 1 or retangle 2. \nEX: x y");
		double x = scan.nextDouble();
		double y = scan.nextDouble();
		System.out.println(String.format("Coordinates (%.1f,%.1f) are inside "
				+ "Rectangle 1: %b\n", x,y,r1.contains(x, y)));
		System.out.println(String.format("Coordinates (%.1f,%.1f) are inside "
				+ "Rectangle 2: %b\n", x,y,r2.contains(x, y)));
		System.out.println();
		//print out both r1 and r2
		System.out.println(r1);
		System.out.println(r2);
		System.out.println();
		//Reassign values to r1 to create a new rectangle
		System.out.println("Please enter the the cordinates of the center of the "
				+ "rectangle r1, aswell as the height and width of the rectangle."
				+ "\nEX: x y height width");
		r1.setX(scan.nextDouble());
		r1.setY(scan.nextDouble());
		r1.setHeight(scan.nextDouble());
		r1.setWidth(scan.nextDouble());
		System.out.println();
		//print the area of each rectangle
		System.out.println("Area of rectangle 1: "+r1.getArea());
		System.out.println("Area of rectangle 2: "+r2.getArea());
		System.out.println();
		//print the perimeter of each rectangle
		System.out.println("Perimeter of rectangle 1: "+r1.getPerimeter());
		System.out.println("Perimeter of rectangle 2: "+r2.getPerimeter());
		System.out.println();
		//Print out test if r1 contains r2
		System.out.println("Rectangle 1 contains Rectangle 2: "+r1.contains(r2));
		System.out.println();
		//Test if the user provided coordinates are inside r1 or r2
		System.out.println("Please enter x and y coordinates to see if they are "
				+ "inside rectangle 1 or retangle 2. \nEX: x y");
		x = scan.nextDouble();
		y = scan.nextDouble();
		System.out.println(String.format("Coordinates (%.1f,%.1f) are inside "
				+ "Rectangle 1: %b\n", x,y,r1.contains(x, y)));
		System.out.println(String.format("Coordinates (%.1f,%.1f) are inside "
				+ "Rectangle 2: %b\n", x,y,r2.contains(x, y)));
		System.out.println();
		//print out both r1 and r2
		System.out.println(r1);
		System.out.println(r2);
		System.out.println();
		
		System.out.println("Thank you! This is the end of the program! Goodbye.");
		
		scan.close();
	}

}

class Rectangle2D{
	private double x;
	private double y;
	private double width;
	private double height;
	
	//default constructor
	public Rectangle2D() {
		x=0;
		y=0;
		width=1;
		height=1;
	}
	//constructor that takes the coordinates and height and width
	public Rectangle2D(double x, double y, double height, double width) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	//getters and setter
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	//end of getters and setters
	
	@Override // override the toString method to print relevant info about the object 
	public String toString() {
		return String.format("This retangle has a center point "
				+ "of (%.1f,%.1f).\nIt has a height of %.1f and a width of %.1f.\n",
				x,y,height,width);
	}
	
	/*
	 * A method named getArea() that returns the area of the rectangle
	 *  A method named getPerimeter() that returns the perimeter of the rectangle
	 *  A method named contains(double x, double y) that returns true if the specified 
	 *  point is inside the rectangle.
	 *  A method named contains(Rectangle2D rectangle) that returns true if the rectangle
	 *  specified by the caller is inside this rectangle
	 */
	
	public double getArea() {
		return height*width;
	}
	public double getPerimeter() {
		return (height*2) + (width*2);
	}
	public boolean contains(double xIn,double yIn) {
		//confirm the x and y coordinates are within the rectangles limits
		if((xIn > x-width && xIn < x+width) && (yIn > y-height && yIn < y+height))
			return true;
		else
			return false;
	}
	public boolean contains(Rectangle2D rec) {
		//create the upper and lower bounds of the rectangle
		double upper = rec.getY()+rec.getHeight();
		double lower = rec.getY()-rec.getHeight();
		//create the right and left bounds of the rectangle
		double right = rec.getX()+rec.getWidth();
		double left = rec.getX()-rec.getWidth();
		//test if the bounds of the other rectangle object are within this rectangle instance
		if((left > x-width && right < x+width) &&  (lower > y-height && upper < y+height))
			return true;
		else
			return false;
	}
	
}
