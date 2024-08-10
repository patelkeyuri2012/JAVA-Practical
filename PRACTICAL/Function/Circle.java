import java.util.*;

public class Circle {

	private static double r;
	private static int x, y;
	
	//default constructor
	public Circle(){
		
	}
	
	//one parameter constructor
	public Circle(double r) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter Radius of Circle : ");
		r = sc.nextDouble();
		this.r = r;
	}
	
	//two parameter constructor
	public Circle(int x, int y) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter x coordinates of Circle : ");
		x = sc.nextInt();
		System.out.print("Enter y coordinates of Circle : ");
		y = sc.nextInt();
		this.x = x;
		this.y = y;
	}
	
	//method for find area of circle
	public static double area(double r){
		double area;
		area = Math.PI*r*r;
		return area;
	}
	
	//method for find circumference of circle
	public static double circumference(double r){
		double circumference;
		circumference = 2*Math.PI*r;
		return circumference;
	}
	
	//method for find diameter of circle
	public static double diameter(double r){
		double diameter;
		diameter = 2*r;
		return diameter;
	}
	
	public static void main(String[] args) {
	
		try{
			//craete an object of two parameter constructor
			Circle c = new Circle(x, y);
			System.out.println();
			System.out.println("x coordinates of Circle is : "+c.x);			//call variable x of two parameter constructor
			System.out.println("y coordinates of Circle is : "+c.y);			//call variable y of two parameter constructor
			
			//craete an object of one parameter constructor
			Circle c1 = new Circle(r);
			System.out.println("Radius of Circle is : "+c1.r);			//call variable r of one parameter constructor
			
			System.out.println();
			System.out.println("Area of Circle is : "+area(r));			//call area method
			System.out.println("Circumference of Circle is : "+circumference(r));			//call circumference method
			System.out.println("Diameter of Circle is : "+diameter(r));			//call diameter method
		}
	
		catch(InputMismatchException ex){
			System.out.println();
			System.out.println("Please enter only valid digits");
		}
	}	
}
