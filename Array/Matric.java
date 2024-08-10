import java.util.*;

class Matrices
{
	private double [][]matrix;
	private int r;
	private int c;

	//default constructor
	Matrices(){
		r = 3;
		c = 3;
		matrix = new double[r][c];
	}
	
	//two parameter constructor
	Matrices(int r,int c){
		this.r = r;
		this.c = c;
		matrix = new double[r][c];
	}
	
	//method for addition of both matrix
	public static Matrices addtion(Matrices m1,Matrices m2){
		int i,j;
		Matrices mt = new Matrices(m1.r,m2.c);
		if(m1.r == m2.r && m1.c == m2.c){
			for(i=0; i<m1.r; i++){
				for(j=0; j<m1.c; j++){
					mt.matrix[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
				}
			}			  
		}
		else{
			System.out.println();
			System.out.println("Addition can not perform");
		}
		return mt;
	}
	
	//method for substrction of both matrix
	public static Matrices substrction(Matrices m1,Matrices m2){
		Matrices mt = new Matrices(m1.r,m2.c);
		if(m1.r == m2.r && m1.c == m2.c){
			for(int i=0; i<m1.r; i++){
				for(int j=0; j<m1.c; j++){
					mt.matrix[i][j] = m1.matrix[i][j] - m2.matrix[i][j];		
				}
			}			  
		}
		else{
			System.out.println();
			System.out.println("Substrction can not perform");
		}
		return mt;
	}
	
	//method for multiplication of both matrix
	public static Matrices multiplication(Matrices m1,Matrices m2){
		Matrices mt = new Matrices(m1.r,m2.c);
		if(m1.c != m2.r){
			System.out.println();
			System.out.println("Multiplication can not perform");
		}
		else{
			for(int i=0; i<m1.r; i++){
				for(int j=0; j<m2.c; j++){
					mt.matrix[i][j] = 0;
					for(int k=0; k<m2.r; k++){
						mt.matrix[i][j] += m1.matrix[i][k] * m2.matrix[k][i];
					}
				}
			}
		}
		return mt;
	}

	//method for addition of both matrix using one parameter
	public Matrices add(Matrices m2){
		Matrices mt = new Matrices(r,m2.c);
		if(r == m2.r && c == m2.c){
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					mt.matrix[i][j] = matrix[i][j] + m2.matrix[i][j];
				}
			}
		}
		else{
			System.out.println();
			System.out.println("Addition can not perform");
		}
		return mt;
	}
	
	//method for substrction of both matrix using one parameter
	public Matrices sub(Matrices m2){
		Matrices mt = new Matrices(r,m2.c);
		if(r == m2.r && c == m2.c){
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					mt.matrix[i][j] = matrix[i][j] - m2.matrix[i][j];
				}
			}
		}
		else{
			System.out.println();
			System.out.println("Substrction can not perform");
		}
		return mt;
	}
	
	//method for multiplication of both matrix using one parameter
	public Matrices mul(Matrices m2){
		Matrices mt = new Matrices(r,m2.c);
		if(r == m2.c){
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					mt.matrix[i][j] = 0;
					for(int k=0; k<r; k++){
						mt.matrix[i][j] += matrix[i][k] * matrix[k][i];
					}
				}
			}
		}
		else{
			System.out.println();
			System.out.println("Multiplication can not perform");
		}
		return mt;
	}
	
	//method for transpose of matrix
	public static Matrices transpose(Matrices m1){
		Matrices mt = new Matrices(m1.r,m1.c);
		for(int i=0; i<m1.r; i++){
			for(int j=0; j<m1.c; j++){
				mt.matrix[j][i] = m1.matrix[i][j];
			}
		}
		return mt;
	}
	
	//method for inverse of matrix
	public static Matrices inverse(Matrices m1) {
		Matrices mt = new Matrices(m1.r, m1.c);

		if (m1.r != m1.c) {
			System.out.println("Matrix must be square for inversion.");
			return mt; 
		}

		int n = m1.r;
		double[][] adjugate = new double[n][n];
		double det = determinant(m1.matrix, n);

		if (det == 0) {
			System.out.println("Matrix is singular; inverse does not exist.");
			return mt; 
		}

		adjugate = adjugateMatrix(m1.matrix, n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mt.matrix[i][j] = adjugate[i][j] / det;
			}
		}

		return mt;
	}
	
	private static double determinant(double[][] mat, int n) {
		if (n == 1) {
			return mat[0][0];
		}
		
		if (n == 2) {
			return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
		}

		double det = 0;
		int sign = 1;

		for (int i = 0; i < n; i++) {
			double[][] submatrix = new double[n - 1][n - 1];
			for (int j = 1; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (k < i) {
						submatrix[j - 1][k] = mat[j][k];
					} else if (k > i) {
						submatrix[j - 1][k - 1] = mat[j][k];
					}
				}
			}

			det += sign * mat[0][i] * determinant(submatrix, n - 1);
			sign = -sign;
		}
		return det;
	}

	private static double[][] adjugateMatrix(double[][] mat, int n) {
		double[][] adjugate = new double[n][n];

		int sign = 1;
		double[][] temp = new double[n - 1][n - 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				getCofactor(mat, temp, i, j, n);
				sign = ((i + j) % 2 == 0) ? 1 : -1;
				double det = determinant(temp, n - 1);
				adjugate[j][i] = sign * det;
			}
		}

		return adjugate;
	}

	private static void getCofactor(double[][] mat, double[][] temp, int p, int q, int n) {
		int i = 0, j = 0;

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (row != p && col != q) {
					temp[i][j++] = mat[row][col];

					if (j == n - 1) {
						j = 0;
						i++;
					}
				}
			}
		}
	}

	
	//method for fetch element of matrix from user
	public void get_element(){
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<r; i++){
			System.out.println();
			System.out.print("Element of ["+i+"] Row of Matrix ");
			System.out.println();
			for (int j=0; j<c; j++){
				System.out.print("Enter ["+j+"] Column Element of Matrix : ");
				matrix[i][j]=sc.nextInt();
			}
		}
	}
		
	//method for override toString method
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				sb.append(matrix[i][j]).append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
		
class Matric
{
	public static void main(String [] args )
	{
		try{
			Scanner sc = new Scanner(System.in);
			int choice, r1, c1, r2, c2;
			
			System.out.print("Enter Number of Row for First Matrix : ");
			r1 = sc.nextInt();
			System.out.print("Enter Number of Column for First Matrix : ");
			c1 = sc.nextInt();
			
			System.out.println();
			System.out.print("Enter Number of Row for Second Matrix : ");
			r2 = sc.nextInt();
			System.out.print("Enter Number of Column for Second Matrix : ");
			c2 = sc.nextInt();
			
			Matrices m1 = new Matrices(r1,c2);
			Matrices m2 = new Matrices(r2,c2);
			
			do{
				System.out.println();
				System.out.println("Select operations of the matrix that you want to perform on matrix:");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("1.Addition of Matrix\n2.Substrction of Matrix\n3.Multiplication of Matrix\n4.Transpose of Matrix\n5.Inverse of Matrix\n6.Add of Matrix\n7.Sub of Matrix\n8.Mul of Matrix\n9.Exit");
				System.out.println();
				System.out.print("Enter your choice : ");
				choice = sc.nextInt();
				System.out.println();
				
				switch(choice){  
					//addition of two matrix
					case 1:
						Matrices m_addition;
						System.out.print("Enter Element of First Matrix : \n");
						m1.get_element();
						System.out.println();
						System.out.print("Enter Element of Second Matrix : \n");
						m2.get_element();
						m_addition = Matrices.addtion(m1,m2);
						System.out.println("\nAddition of two Matrices");
						System.out.println(m_addition.toString());
						break;
					
					//substrction of two matrix
					case 2:
						Matrices m_substraction;
						System.out.print("Enter Element of First Matrix : \n");
						m1.get_element();
						System.out.println();
						System.out.print("Enter Element of Second Matrix : \n");
						m2.get_element();
						m_substraction = Matrices.substrction(m1,m2);
						System.out.println("\nSubstrction of two Matrices");
						System.out.println(m_substraction.toString());
						break;
						
					//multiplication of two matrix
					case 3:
						Matrices m_maltiplication;
						System.out.print("Enter Element of First Matrix : \n");
						m1.get_element();
						System.out.println();
						System.out.print("Enter Element of Second Matrix : \n");
						m2.get_element();
						m_maltiplication = Matrices.multiplication(m1,m2);
						System.out.println("\nMultiplication of two Matrices");
						System.out.println(m_maltiplication.toString());
						break;
						
					//transpose of two matrix
					case 4:
						Matrices m_transpose;
						System.out.print("Enter Element of Matrix : \n");
						m1.get_element();
						System.out.println("\nBefore transpose operation : ");
						System.out.println(m1.toString());
						System.out.println("\nAfter transpose operation : ");
						m_transpose = Matrices.transpose(m1);
						System.out.println(m_transpose.toString());
						break;
							
					//inverse of two matrix
					case 5:
						Matrices m_inverse;
						System.out.print("Enter Element of Matrix : \n");
						m1.get_element();
						System.out.println("\nBefore inverse operation : ");
						System.out.println(m1.toString());
						System.out.println("\nAfter inverse operation : ");
						m_inverse = Matrices.inverse(m1);
						System.out.println(m_inverse.toString());
						break;
						
					//addition of two matrix using one parameter
					case 6:
						Matrices m_add;
						System.out.print("Enter Element of First Matrix : \n");
						m1.get_element();
						System.out.print("Enter Element of Second Matrix : \n");
						m2.get_element();
						m_add = m1.add(m2);
						System.out.println("\nAddition of two Matrices");
						System.out.println(m_add.toString());
						break;
						
					//substrction of two matrix using one parameter
					case 7:
						Matrices m_sub;
						System.out.print("Enter Element of First Matrix : \n");
						m1.get_element();
						System.out.print("Enter Element of Second Matrix : \n");
						m2.get_element();
						m_sub = m1.sub(m2);
						System.out.println("\nSubstrction of the Matrices");
						System.out.println(m_sub.toString());
						break;
					
					//multiplication of two matrix using one parameter
					case 8:
						Matrices m_mul;
						System.out.print("Enter Element of First Matrix : \n");
						m1.get_element();
						System.out.print("Enter Element of Second Matrix : \n");
						m2.get_element();
						m_mul = m1.mul(m2);
						System.out.println("\nMultiplication of the Matrices");
						System.out.println(m_mul.toString());
						break;
											
					case 9:
						System.exit(0);

					default:
						System.out.print("\nInvalid choice!!");			
				}
			}
			while(choice!=9);
		}
		catch(InputMismatchException ex){
			System.out.println();
			System.out.println("Please enter valid input");
		}
	}
}