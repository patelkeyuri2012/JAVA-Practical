import java.util.*;

public class ArrayPrinter {
	// create generic function
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + "	");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice, size;
		try
		{
			do
			{
				System.out.print("\nSelect array type that you want to create:\n");
				System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println("1.Integer Array");
				System.out.println("2.Double Array");
				System.out.println("3.Exit");
				System.out.print("\nEnter Choice : ");
				choice = sc.nextInt();
							
				switch(choice)
				{
					case 1:
						System.out.print("\nEnter the size of the array : ");
						size = sc.nextInt();
						System.out.println();
						// create integer array
						Integer[] Array1 = new Integer[size];
						for(int i = 0; i < size; i++)
						{
							System.out.print("Enter Element : ");
								Array1[i] = sc.nextInt();
						}
						System.out.print("\nElements of Integer array are : ");
						printArray(Array1);
						break;
					case 2:
						System.out.print("\nEnter the size of the array : ");
						size = sc.nextInt();
						System.out.println();
						// create double array
						Double[] Array2 = new Double[size];
						for(int i = 0; i < size; i++)
						{
							System.out.print("Enter Element : ");
							Array2[i] = sc.nextDouble();
						}
						System.out.print("\nElements of Double array are : ");
						printArray(Array2);
						break;
					case 3:
						System.exit(0);
					default:
						System.out.print("Invalid Choice..!!\n");
				}
			}
			while(choice!=3);
		}
		catch(InputMismatchException ex){
			System.out.println();
			System.out.println("Please enter valid input");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
}
