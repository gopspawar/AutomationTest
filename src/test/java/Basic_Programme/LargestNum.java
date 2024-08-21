package Basic_Programme;

import java.util.Scanner;

public class LargestNum {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter your First Numbar");
		int a = sc.nextInt();
		
		System.out.println("Enter your second Numbar");
		int b = sc.nextInt();
		
		System.out.println("Enter your Third Numbar");
		int c = sc.nextInt();
		
		if(a>=b && a>=c) {
			System.out.println("The First number "+a+" is greater than "+b+" and "+c);
		}else if(b>=a && b>=c) {
			System.out.println("The second number "+b+" is greater than "+a+" and "+c);
		}else if (c>=a && c>=b) {
			System.out.println("The Third number "+c+" is greater than "+a+" and "+b);
		
		}
		}
		
	}


