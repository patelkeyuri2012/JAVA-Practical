import java.util.Scanner;

class Matrix{
	
	public static void main(String [] args){
		
		//create first matrix
		int r1, c1;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Number of Row for First Matrix : ");
		r1 = sc.nextInt();
		System.out.print("Enter Number of Column for First Matrix : ");
		c1 = sc.nextInt();
		
		
		//fetch element of first matrix from user
		System.out.println();
		System.out.println("Enter Element of First Matrix : ");
		int [][] a = new int[r1][c1];
		
		for (int i=0; i<r1; i++){
			System.out.println();
			System.out.print("Element of ["+i+"] Row of Matrix ");
			System.out.println();
			for (int j=0; j<c1; j++){
				System.out.print("Enter ["+j+"] Column Element of Matrix : ");
				a[i][j] = sc.nextInt();
			}
		}
		
		//create second matrix
		int r2, c2;
				
		System.out.println();
		System.out.print("Enter Number of Row for Second Matrix : ");
		r2 = sc.nextInt();
		System.out.print("Enter Number of Column for Second Matrix : ");
		c2 = sc.nextInt();
		
		//fetch element of second matrix from user
		System.out.println();
		System.out.println("Enter Element of Second Matrix : ");
		int [][] b = new int[r2][c2];
		
		for (int i=0; i<r2; i++){
			System.out.println();
			System.out.print("Element of ["+i+"] Row of Matrix ");
			System.out.println();
			for (int j=0; j<c2; j++){
				System.out.print("Enter ["+j+"] Column Element of Matrix : ");
				b[i][j] = sc.nextInt();
			}
		}
	
		//show all the element of first matrix
		System.out.println();
		System.out.println("Element of First Matrix : ");
		for (int i=0; i<r1; i++){
			for (int j=0; j<c1; j++){
				System.out.print(" " + a[i][j]);
			}
			System.out.println(" ");
		}
		
		//show all the element of second matrix
		System.out.println();
		System.out.println("Element of Second Matrix : ");
		for (int i=0; i<r2; i++){
			for (int j=0; j<c2; j++){
				System.out.print(" " + b[i][j]);
			}
			System.out.println(" ");
		}
		
		//addition of both matrix
		if(r1 == r2 && c1 == c2){
			int [][] c = new int [r1][c1];
			
			System.out.println();
			System.out.println("Addition of Both Matrix is : ");
			for (int i=0; i<r1; i++){
				for (int j=0; j<c1; j++){
					c[i][j] = a[i][j] + b[i][j];
					System.out.print(" " +c[i][j]);
				}
				System.out.println(" ");
			}
		}else{
			System.out.println();
			System.out.println("Addition can not perform");
		}
		
		//substrction of both matrix
		if(r1 == r2 && c1 == c2){
			int [][] d = new int [r1][c1];
			
			System.out.println();
			System.out.println("Substraction of Both Matrix is : ");
			for (int i=0; i<r1; i++){
				for (int j=0; j<c1; j++){
					d[i][j] = a[i][j] - b[i][j];
					System.out.print(" " +d[i][j]);
				}
				System.out.println(" ");
			}
		}else{
			System.out.println();
			System.out.println("Substraction can not perform");
		}
		
		//multiplication of both matrix
		if(r1 == c2){
			int [][] e = new int [r1][c1];
			System.out.println();
			System.out.println("Multiplication of Both Matrix is : ");
			for(int i=0;i<r1;i++){    
				for(int j=0;j<c2;j++){    
					for(int k=0;k<r1;k++)      
					{  				
						e[i][j] += a[i][k] * b[k][j]; 
					}	
					System.out.print(e[i][j]+" ");				
				}
				System.out.println(" ");
			}
		}else{
			System.out.println();
			System.out.println("Multiplication can not perform");
		}
	}
}
