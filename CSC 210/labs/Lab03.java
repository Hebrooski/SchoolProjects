package labs;

import java.util.Scanner;

//course: CSC210

//project: Lab03

//date: 2/11/2022

//author: Grayson Lyvers

//purpose: To create a triangle subclass of the abstract GeometricObject class that holds three sides

public class Lab03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the three sides of the triangle seperated by a space: ");
		int[] sides = new int[3];
		for (int i = 0; i < sides.length; i++) {
			//.next() will read until a space character which allows it to read all the numbers using the for loop
			sides[i] = Integer.parseInt(scan.next());
		}
		System.out.print("Please enter the color of the triangle: ");
		String color = scan.next();
		System.out.print("Is the triangle filled by the color? (Y/N): ");
		String response = scan.next().toLowerCase();
		boolean filled = false;
		// for the option to enter the boolean value instead of entering y or n
		if(response.equals("true")| response.equals("false")) {
			filled = Boolean.parseBoolean(response);
		}
		else if(response.equals("y")) {
			filled = true;
		}
		
		Triangle tri = new Triangle(color,filled,sides[0],sides[1],sides[2]);
		System.out.printf("Triangle: side1 = %.0f | side2 = %.0f | side3 = %.0f %n",tri.side1,tri.side2,tri.side3);
		System.out.printf("The area: %.2f %n",tri.getArea());
		System.out.printf("The perimeter: %.1f %n",tri.getPerimeter());
		System.out.printf("Color: %s%n",tri.getColor());
		System.out.printf("Filled: %b",tri.isFilled());
	}
}

class Triangle extends GeometricObject {
	
	double side1;
	double side2;
	double side3;
	
	Triangle(){}
	Triangle(String color, boolean filled,double side1,double side2,double side3){
		//using the super constructor
		super(color,filled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	@Override
	public double getArea() {
		//using heron's method for finding the area
		double halfPerim = getPerimeter()/2;
		return Math.sqrt((halfPerim*(halfPerim-side1))*(halfPerim-side2)*(halfPerim-side3));
	}

	@Override
	public double getPerimeter() {
		return side1+side2+side3;
	}
	
}

abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;

	/** Construct a default geometric object */
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}

	/** Construct a geometric object with color and filled value */
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	/** Return color */
	public String getColor() {
		return color;
	}

	/** Set a new color */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Return filled. Since filled is boolean, the get method is named isFilled
	 */
	public boolean isFilled() {
		return filled;
	}

	/** Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/** Get dateCreated */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}

	/** Abstract method getArea */
	public abstract double getArea();

	/** Abstract method getPerimeter */
	public abstract double getPerimeter();
}