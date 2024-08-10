import java.util.*;

class StackOperator {
	
	static int top, max = 5;
	static int [] stack;
	
	//default constructor
	StackOperator(){
		top = -1;
		stack = new int[5];
	}
	
	//one parameter constructor
	StackOperator(int size){
		System.out.println("arg call");
		top = -1;
		stack = new int[size];
		max = size;
	}
	
	//method to check stack is empty or not
	public static Boolean isEmpty() 
	{
		return top == - 1;
	}
	
	//method to check stack is full or not
	public static Boolean isFull() 
	{
		return top == max - 1;
	}
	
	//method to push element in stack
	public static void push(){
	
		int x;
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
			if (isFull())
			{
				System.out.println("Stack is Full!!");
			}
			else
			{
				System.out.print("Enter the elements that you want to add : ");
				x = sc.nextInt();
				top = top + 1;
				stack[top] = x;	
			}
			
	}
	
	//method to pop element in stack
	public static int pop(){
		
		if (isEmpty())
		{
			System.out.println("Stack is Empty!!");
		}
		else
		{
			System.out.println();
			System.out.print("Popped element is : ");
			System.out.println(" "+stack[top]);
			top = top - 1;
		}
		return 0;
	}
	
	//method to display element in stack
	public static void traverse(){
		
		if (isEmpty())
		{
			System.out.println("Stack is Empty!!");
		}
		else
		{
			System.out.println();
			System.out.print("Element of Stack : ");
			for(int i = top; i >= 0; i--){
				System.out.print(" "+stack[i]);
			}
			System.out.println();
		}
	}
	
}

class Stack{
	
	static int top, max;
	static int [] stack;
	
	public static void main (String [] args){
		
		try{
			Scanner sc = new Scanner(System.in);
			StackOperator s = new StackOperator();		//object of StackOperator class

			int choice;

			do{
				System.out.print("\nSelect operations of the stack that you want to perform:\n");
				System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.print("\n1.Push the element\n2.Pop the element\n3.Show all the element of Stack\n4.Exit");
				System.out.print("\n\nEnter the choice: ");
				choice = sc.nextInt();

				switch (choice)
				{
					case 1:
						s.push();
						break;
					case 2:
						s.pop();
						break;
					case 3:
						s.traverse();
						break;
					case 4:
						System.exit(0);
					default:
						System.out.print("\nInvalid choice!!");			
				}
			}
			while(choice!=4);
		}
		catch(InputMismatchException ex){
			System.out.println();
			System.out.println("Please enter valid input");
		}
	}
}