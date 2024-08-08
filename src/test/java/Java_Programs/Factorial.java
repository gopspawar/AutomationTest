package Java_Programs;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		System.out.println("Factorial number");
		
		int n;
		int fact=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the your number: ");
	    n = sc.nextInt();
	    
	    for(int i=1;i<=n;i++)
	    {
	    	fact=fact*i;
	    }
		
		System.out.println("\nThe factorial of" + n + "is"+ fact);
	}

}
