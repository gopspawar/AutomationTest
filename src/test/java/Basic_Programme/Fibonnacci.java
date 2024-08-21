package Basic_Programme;

import java.util.Scanner;

public class Fibonnacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int a=0, b=1;
      
      Scanner s= new Scanner(System.in);
      
      System.out.println("Enter range your number:");
      int n= s.nextInt();
      
      for(int i=0; i<=n;i++) 
      {
    	System.out.println(a);
		int temp=a+b;
		a=b;
		b=temp;

}
}
}