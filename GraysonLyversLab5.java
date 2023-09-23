package labs;

import java.util.Scanner;

//course: CSC 191
//project: Lab 5
//date: 9/13/2023
//author: Grayson Lyvers
//purpose: to build a coordinate calculation system

public class GraysonLyversLab5 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size;
		while(true) {
			try {
				System.out.println("How many points do you want to compare?");
	        	size = scan.nextInt();
	        	if(size>=3) 
	        		break;
	        	else
	        		System.out.println("Please choose a number greater than 2!");
			}catch(Exception e){
				System.out.println("Error! Please try again.");
			}
				
        		
		}
        
        PointList p1 = new PointList(size);
        
        while(true) {
        	try {
        		System.out.println("----Menu----");
        		System.out.println("\t1. Determine if 3 points can create a triangle and the type of triangle it would be.\n"
        				+ "\t2. Determine the point which is the farthest outlier to the other points.\n"
        				+ "\t3. Find the upper left and lower right points of the smallest rectangle that can contain all the points \n"
        				+ "\t4. Exit");
        		
        		int input = scan.nextInt();
        		if(input==4)
        			break;
        		else if(input==1)
        			p1.isTriangle();
        		else if(input==2)
        			p1.findOutlier();
        		else if(input==3)
        			p1.findRectangle();
        	}catch(Exception e) {
        		scan.nextLine();
        		System.out.println("System error! Please try again!");
        		System.out.println(e);
        	}
        }
        
        System.out.println("Goodbye.");
	}

}

class PointList{
    //data member
    double points[][];
    
    //constructor
    public PointList(int len){
        points = new double[len][2];
        
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            System.out.println("Enter the coordinates of a point:");
            System.out.println("Enter the x value: ");
            points[i][0] = input.nextDouble();
            System.out.println("Enter the y value: ");
            points[i][1] = input.nextDouble();
        }
    } //close constructor
    
    //method to find distance between two points
    public double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    
    //find the pair of points that has the smallest distance between them
    public void findClosestPair(){
        int p1 = 0, p2 = 1;
        
        double shortDist = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
        
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                double dist = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if(shortDist>dist){
                    p1=i;
                    p2=j;
                    shortDist = dist;
                }
            }
        }
        
        System.out.println("The closest two points are ("+
                points[p1][0]+", "+points[p1][1]+") and (" +
                points[p2][0]+", "+points[p2][1]+")");
    }
    
    public void findOutlier() {
    	//store current values
    	double tempDist = 0;
    	double[] tempCords;
    	//store highest values 
    	double[] farestCord=null;
    	double highestDist=0;
    	
    	//loop to choose cords
    	for (int i = 0; i < points.length; i++) {
    		tempCords=points[i];
    		//loop to sum distances
			for (int r = 0; r < points.length; r++) {
				tempDist += distance(tempCords[0], tempCords[1], points[r][0], points[r][1]);
			}
			if(tempDist>highestDist) {
				//set new highest values if higher is found
				highestDist = tempDist;
				farestCord = tempCords;
			}
		}
    	
    	System.out.printf("The farthest coordinate from all others is %.2f,%.2f %n",farestCord[0],farestCord[1]);
    }
    
    public void findRectangle() {
    	// initialize with values within the points
    	double topX = points[0][0];
    	double topY = points[0][1];
    	double lowX = points[0][0];
    	double lowY = points[0][1];
    	//search for the highest and lowest cords
    	for (int i = 0; i < points.length; i++) {
			if(points[i][0]>topX)
				topX=points[i][0];
			if(points[i][1]>topY)
				topY=points[i][1];
			if(points[i][0]<lowX)
				lowX=points[i][0];
			if(points[i][1]<lowY)
				lowY=points[i][1];
		}
    	
    	System.out.printf("A rectangle with a top right corner of %.2f,%.2f and a bottom left corner of %.2f,%.2f contains all points%n",
    			topX,topY,lowX,lowY);
    }
    
    public void isTriangle() {
    	int[] pointNums = new int[3]; //store point choices
    	double[] sides = new double[3];//0=sideA 1=sideB 2=sideC
    	Scanner scan = new Scanner(System.in);
    	printPoints();
    	System.out.println("Please choose a point number:");
    	pointNums[0] = scan.nextInt()-1;
    	System.out.println("Please choose another point number:");
    	pointNums[1] = scan.nextInt()-1;
    	System.out.println("Please choose a final point number:");
    	pointNums[2] = scan.nextInt()-1;
    	sides[0] = distance(points[pointNums[0]][0], points[pointNums[0]][1], points[pointNums[1]][0], points[pointNums[1]][1]);
    	sides[1] = distance(points[pointNums[1]][0], points[pointNums[1]][1], points[pointNums[2]][0], points[pointNums[2]][1]);
    	sides[2] = distance(points[pointNums[2]][0], points[pointNums[2]][1], points[pointNums[0]][0], points[pointNums[0]][1]);
    	for (int i = 1; i < sides.length; i++) {
    		double temp = 0;
        	for (int j = 0; j < sides.length-i; j++) {//bubble sort the sides to avoid massive if-else tree
    			if(sides[j]>sides[j+1]) {
    				temp = sides[j+1];
    				sides[j+1]=sides[j];
    				sides[j]=temp;
    			}
    		}
		}
    	if(sides[2]>=sides[0]+sides[1])
    		System.out.println("Those points do not create a triangle.");
    	else if(sides[2]*sides[2]==sides[0]*sides[0]+sides[1]*sides[1])
    		System.out.println("Those points create a right triangle.");
    	else if(sides[2]*sides[2]<sides[0]*sides[0]+sides[1]*sides[1])
    		System.out.println("Those points create an acute triangle.");
    	else if(sides[2]*sides[2]>sides[0]*sides[0]+sides[1]*sides[1])
    		System.out.println("Those points create an obtuse triangle.");
    
    }

	private void printPoints() {
		for (int i = 0; i < points.length; i++) {
			System.out.printf("%d: %.2f,%.2f%n",i+1,points[i][0],points[i][1]);
		}
		System.out.println();
	}
}

