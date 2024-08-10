import org.gvp.dcs.ds.Stack;
import org.gvp.dcs.ds.Queue;
import org.gvp.dcs.shapes.Cube;
import org.gvp.dcs.shapes.Sphere;
import java.util.Scanner;

public class Packages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int choice, size, value, ch;
		double volume, SurfaceArea;
		try
		{
			do
			{
                System.out.println("\nSelect Demonstrating opearation ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("1.Demonstrating Stack");
				System.out.println("2.Demonstrating Queue");
				System.out.println("3.Demonstrating Cube");
				System.out.println("4.Demonstrating Sphere");
				System.out.println("5.Exit");
				
				System.out.print("\nEnter your choice  : ");
				ch = sc.nextInt();
				
				if(ch == 1)
				{
					System.out.print("\nEnter Your Stack Size : ");
					size = sc.nextInt();
					// object of stack class
					Stack stack = new Stack(size);
					do
					{
						System.out.println();
						System.out.println("Demonstrating Stack");
                        System.out.println("~~~~~~~~~~~~~~~~~~~");
						System.out.println("1.push");
						System.out.println("2.pop");
						System.out.println("3.peek");
						System.out.println("4.Exit");
						System.out.print("\nEnter your choice  : ");
						choice = sc.nextInt();
						switch(choice)
						{
							case 1: System.out.println();
									System.out.print("\nEnter Your Element : ");
									value = sc.nextInt();
									// call push method of Stack class
									stack.push(value);
									System.out.println();
									break;
							case 2: System.out.println();
									// call pop method of Stack class
									stack.pop();
									break;
							case 3: System.out.println();
									// call peek method of Stack class
									stack.peek();
									break;
							case 4: System.exit(0);
									break;
							default:
									System.out.println("Invalid Input..!");
						}
					}while(choice != 0);
				}
				else if(ch == 2)
				{
					
					System.out.print("\nEnter Your Queue Size : ");
					size = sc.nextInt();
					// object of stack class
					Queue queue = new Queue(size);
					do
					{	
						System.out.println();
						System.out.println("\nDemonstrating Queue");
                        System.out.println("~~~~~~~~~~~~~~~~~~~");
						System.out.println("1.Insert Element");
						System.out.println("2.Delete Element");
						System.out.println("3.Peek Element");
						System.out.println("4.Exit");
						System.out.print("\nEnter your choice  : ");
						choice = sc.nextInt();
						switch(choice)
						{
							case 1: System.out.println("");
									System.out.print("Enter Your Element : ");
									value = sc.nextInt();
									// call enqueue method of Queue class
									queue.enqueue(value);
									break;
							case 2: System.out.println();
									// call dequeue method of Queue class
									queue.dequeue();
									break;
							case 3: System.out.println();
									// call peek method of Queue class
									queue.peek();
									break;
							case 4: System.exit(0);
									break;
							default:
									System.out.println("Invalid Input..!");
						}
					}while(choice != 0);
				}
				else if(ch == 3) 
				{
					System.out.print("\nEnter Your Cube side : ");
					size = sc.nextInt();
					// object of cube class
					Cube c = new Cube(size);
					
					do
					{	
						System.out.println();
						System.out.println("\nDemonstrating Cube");
                        System.out.println("~~~~~~~~~~~~~~~~~~");
						System.out.println("1.Calculate Volume");
						System.out.println("2.Calculate SurfaceArea");
						System.out.println("3.Exit");
						System.out.print("\nEnter your choice  : ");
						choice = sc.nextInt();
						switch(choice)
						{
							case 1: System.out.println();
									// call calculateVolume method of Cube class
									volume = c.calculateVolume();
									System.out.println("Sphere volume is : " + volume);
									break;
							case 2: System.out.println();
									// call calculateSurfaceArea method of Cube class
									SurfaceArea = c.calculateSurfaceArea();
									System.out.println("Cube SurfaceArea is : " + SurfaceArea);
									break;
							case 3: System.exit(0);
									break;
							default:
									System.out.println("Invalid Input..!");
						}
					}while(choice != 0);
					
				}
				else if(ch == 4)
				{
					System.out.print("\nEnter Your Sphere radius : ");
					size = sc.nextInt();
					// object of sphere class
					Sphere sphere = new Sphere(size);
					
					do
					{	
						System.out.println();
						System.out.println("\nDemonstrating Sphere");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~");
						System.out.println("1.Calculate Volume");
						System.out.println("2.Calculate SurfaceArea");
						System.out.println("3.Exit");
						
						System.out.print("\nEnter your choice  : ");
						choice = sc.nextInt();
						
						switch(choice)
						{
							case 1: System.out.println();
									// call calculateVolume method of Sphere class
									volume = sphere.calculateVolume();
									System.out.println("Sphere volume is : " + volume );
									break;
							case 2: System.out.println();
									// call calculateSurfaceArea method of Sphere class
									SurfaceArea = sphere.calculateSurfaceArea();
									System.out.println("Sphere SurfaceArea is : " + SurfaceArea);
									break;
							case 3: System.exit(0);
									break;
							default:
									System.out.println("Invalid Input..!");
						}
					}while(choice != 0);
				}
				
			}while(ch != 5 );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
    }
}
