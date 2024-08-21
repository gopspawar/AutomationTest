package Basic_Programme;

import java.util.Scanner;
 
public class ReverseNum{
	
public static void main(String[] args) 
{
	 
	 int rev=0, rem;
	 
	 Scanner s = new Scanner(System.in);
	 
	 System.out.println("Enter your Number: ");
	 int n=s.nextInt();
	 
	 int temp=n;
	 
	 while(n>0) 
	 {
		 rem=n%10;
		 rev=rev*10+ rem;
		 n=n/10;
	 }	 
	 
	 System.out.println("Reverse number: "+rev);
	 if(rev==temp)
	 {
		 System.out.println("Number is palindrome");
	 }else 
	 {
		 System.out.println("Number is not palindrome");
	 }
}
}
