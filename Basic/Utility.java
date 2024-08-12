import java.util.*;

class Utility{
	
	//method for find even number
	public static boolean isEven(int no){
		if(no%2 == 0){
			return true;
		}else{
			return false;
		}
	}	
	
	//method for find odd number
	public static boolean isOdd(int no){
		if(no%2 != 0){
			return true;
		}else{
			return false;
		}
	}	
	
	//method for find prime number
	public static boolean isPrime(int no) {
		if (no <= 1) {
			return false;
		}
		int m = (int) Math.sqrt(no);
		for (int i = 2; i <= m; i++) {
			if (no % i == 0) {
				return false;
			}
		}	
		return true;
	}
	//method for find factorial of number
	public static long factorial(long no){
		
		long fact=1;
		
		for(int i=1; i<=no; i++){
			fact = fact*i;
		}
		return fact;
	}	
	
	//main method of Utility class
	public static void main(String [] args){
		
		int no;
		long fact=1;
		
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.print("Enter number to Check Number is Even or not : ");
			no = sc.nextInt();
			
			//call isEven method
			if (isEven(no)){
				System.out.println(no+" Number is Even");
			}else{
				System.out.println(no+" Number is not Even");
			}
			
			System.out.println();
			
			System.out.print("Enter number to Check Number is Odd or not : ");
			no = sc.nextInt();
			
			//call isOdd method
			if (isOdd(no)){
				System.out.println(no+" Number is Odd");
			}else{
				System.out.println(no+" Number is not Odd");
			}
	
			System.out.println();
			
			System.out.print("Enter number to Check Number is Prime or not : ");
			no = sc.nextInt();
			
			//call isPrime method
			if (isPrime(no)){
				System.out.println(no+" Number is Prime");
			}else{
				System.out.println(no+" Number is not Prime");
			}
			
			System.out.println();
			
			System.out.print("Enter number to find factorial : ");
			no = sc.nextInt();
			
			//call factorial method
			fact = factorial(no);
			
			System.out.println("Factorial of "+no+" Number is : "+fact);
		}
		catch(InputMismatchException ex){
			System.out.println();
			System.out.println("Please enter only integer number");
		}
	}
}



