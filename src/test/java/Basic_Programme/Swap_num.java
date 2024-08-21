package Basic_Programme;

import java.util.Scanner;

public class Swap_num {
public static void main(String[] args) {
	int a, b, c;
	
	Scanner s = new Scanner(System.in);
	
	System.out.println("Enter your first number: ");
	a = s.nextInt();
	
	System.out.println("Enter your first number: ");
	b = s.nextInt();
	
	System.out.println("Enter your first number: ");
	c = s.nextInt();
	
	System.out.println("Before swapping a= "+a+" and b= "+b+"and c= "+c);
	
	int temp = a;
	a=b;
	b=c;
	c=temp;
	
	
//	System.out.println("After swapping a= "+a+" and b= "+b+"and c= "+c);
//	
//	a=a+b;
//	b=a-b;
//	a=a-b;

	
	
	System.out.println("After swapping a= "+a+"and b= "+b+" and c= "+c);
	
	a=a^b;
	b=a^b;
	c=a^b;
	a=a^b;
	
	
	System.out.println("After swapping a="+a+"and b= "+b+" and c= "+c);
	
	
	
	
	
}
}
