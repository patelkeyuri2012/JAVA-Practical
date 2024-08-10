import java.util.*;

//interface
interface Shape2D{
	int x = 1;
	int	y = 1;
	public double area();
	public double perimeter();
}

//class circle that implements from interface shape2D
class Circles implements Shape2D{
	
	private static double r;
	
	//default constructor
	public Circles(){
		
	}
	
	//one parameter constructor
	public Circles(double r) {
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

//class rectangle that implements from interface shape2D
class Rectangles implements Shape2D{
	
	private static double l, b;
	
	//default constructor
	public Rectangles(){
		
	}
	
	//two parameter constructor
	public Rectangles(double l, double b) {
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

//class triangle that implements from interface shape2D
class Triangles implements Shape2D{
	
	private static double x, y, z;
	
	//default constructor
	public Triangles(){
		
	}
	
	//three parameter constructor
	public Triangles(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//method for find area of triangle
	public double area(){
		if((x+y)>z || (x+z)>y || (y+z)>x){
			return 0.0;
		}else{
			double area, s, ar;
			s = (x + y + z) / 2;
			ar = (s * (s-x) * (s-y) * (s-z));
			area = Math.sqrt(ar);
			return area;
		}
	}
	
	//method for find perimeter of triangle
	public double perimeter(){
		if((x+y)>z || (x+z)>y || (y+z)>x){
			return 0.0;
		}else{
			double perimeter;
			perimeter = x + y + z;
			return perimeter;
		}
	}
}

interface Shaped{
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		int choice;
		try{
			
			do{
				System.out.print("\nSelect Shape to find thier area and perimeter:\n");
				System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.print("\n1.CIRCLE\n2.RECTANGLE\n3.TRIANGLE\n4.EXIT");
				System.out.print("\n\nEnter the choice: ");
				choice = sc.nextInt();

				switch (choice)
				{
					case 1:
						//code for find area and perimeter of circle
						double r;
						System.out.println();
						System.out.print("Enter Radius of Circle : ");
						r = sc.nextDouble();
						//craete objects of constructors of class circle
						Circles c = new Circles();		//object of default constructor
						Circles c1 = new Circles(r);		//object of one perameter constructor
						System.out.println();
						System.out.println("Area of Circle is : "+c1.area());
						System.out.println("Perimeter of Circle is : "+c1.perimeter());
						break;
					case 2:
						//code for find area and perimeter of rectangle
						double l, b;
						System.out.println();
						System.out.print("Enter length of Rectangle : ");
						l = sc.nextDouble();		
						System.out.print("Enter width of Rectangle : ");
						b = sc.nextDouble();
						//craete objects of constructors of class rectangle
						Rectangles re = new Rectangles();		//object of default constructor
						Rectangles re1 = new Rectangles(l, b);		//object of two perameter constructor
						System.out.println();
						System.out.println("Area of Rectangle is : "+re1.area());
						System.out.println("Perimeter of Rectangle is : "+re1.perimeter());
						break;
					case 3:
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
						Triangles t = new Triangles();		//object of default constructor
						Triangles t1 = new Triangles(x, y, z);		//object of three perameter constructor
						System.out.println();
						if(t1.area() == 0.0){
							System.out.println("For find Area please enter valid side");
						}else{
							System.out.println("Area of Triangle is : "+t1.area());
						}
						if(t1.perimeter() == 0.0){
							System.out.println("For find Perimeter please enter valid side");
						}else{
							System.out.println("Perimeter of Triangle is : "+t1.perimeter());
						}
						break;
					case 4:
						System.exit(0);
					default:
						System.out.print("\nInvalid choice!!");			
				}
			}while(choice!=4);
		}
		catch(InputMismatchException ex){
			System.out.println();
			System.out.println("Please enter only valid digits");
		}
	}
}