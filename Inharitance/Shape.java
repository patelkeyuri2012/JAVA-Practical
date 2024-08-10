import java.util.*;

//abstract class : no one access it, means can not create object of abstract class
abstract class Shape2D{
	int x, y;
	public abstract double area();
	public abstract double perimeter();
}

//class circle that extends from class shape2D
class Circle extends Shape2D{
	
	private static double r;
	
	//default constructor
	public Circle(){
		
	}
	
	//one parameter constructor
	public Circle(double r) {
		this.r = r;
	}
	
	//method for find area of circle
	public double area(){
		double area;
		area = Math.PI*r*r;
		return area;
	}
	
	//method for find perimeter of circle
	public double perimeter(){
		double perimeter;
		perimeter = 2*Math.PI*r;
		return perimeter;
	}
}

//class rectangle that extends from class shape2D
class Rectangle extends Shape2D{
	
	private static double l, b;
	
	//default constructor
	public Rectangle(){
		
	}
	
	//two parameter constructor
	public Rectangle(double l, double b) {
		this.l = l;
		this.b = b;
	}
	
	//method for find area of rectangle
	public double area(){
		double area;
		area = l * b ;
		return area;
	}
	
	//method for find perimeter of rectangle
	public double perimeter(){
		double perimeter;
		perimeter = 2 * (l+b);
		return perimeter;
	}
}

//class triangle that extends from class shape2D
class Triangle extends Shape2D{
	
	private static double x, y, z;
	
	//default constructor
	public Triangle(){
		
	}
	
	//three parameter constructor
	public Triangle(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//method for find area of triangle
	public double area(){
		double area, s, ar;
		s = (x + y + z) / 2;
		ar = (s * (s-x) * (s-y) * (s-z));
		area = Math.sqrt(ar);
		return area;
	}
	
	//method for find perimeter of triangle
	public double perimeter(){
		double perimeter;
		perimeter = x + y + z;
		return perimeter;
	}
}

class Shape{
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		try{
			//code for find area and perimeter of circle
			double r;
			System.out.println();
			System.out.print("Enter Radius of Circle : ");
			r = sc.nextDouble();
			//craete objects of constructors of class circle
			Circle c = new Circle();		//object of default constructor
			Circle c1 = new Circle(r);		//object of one perameter constructor
			System.out.println();
			System.out.println("Area of Circle is : "+c1.area());
			System.out.println("Perimeter of Circle is : "+c1.perimeter());
			
			//code for find area and perimeter of rectangle
			double l, b;
			System.out.println();
			System.out.print("Enter length of Rectangle : ");
			l = sc.nextDouble();		
			System.out.print("Enter width of Rectangle : ");
			b = sc.nextDouble();
			//craete objects of constructors of class rectangle
			Rectangle re = new Rectangle();		//object of default constructor
			Rectangle re1 = new Rectangle(l, b);		//object of two perameter constructor
			System.out.println();
			System.out.println("Area of Rectangle is : "+re1.area());
			System.out.println("Perimeter of Rectangle is : "+re1.perimeter());
			
			//code for find area and perimeter of triangle
			double x, y, z;
			System.out.println();
			System.out.print("Enter side1 of Triangle : ");
			x = sc.nextDouble();
			System.out.print("Enter side2 of Triangle : ");
			y = sc.nextDouble();
			System.out.print("Enter side3 of Triangle : ");
			z = sc.nextDouble();
			//craete objects of constructors of class triangle
			Triangle t = new Triangle();		//object of default constructor
			Triangle t1 = new Triangle(x, y, z);		//object of three perameter constructor
			System.out.println();
			System.out.println("Area of Triangle is : "+t1.area());
			System.out.println("Perimeter of Triangle is : "+t1.perimeter());
		}
		catch(InputMismatchException ex){
			System.out.println();
			System.out.println("Please enter only valid digits");
		}
	}
}