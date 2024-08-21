package Basic_Programme;

import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n,sum=0, res;
		
		int temp;
		
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your number: ");
		 n = s.nextInt();
		
		 temp=n;
		 
		while(n>0) {
			
			res=n%10;
			n=n/10;
			sum=sum+(res*res*res);	
		}
		
		if(temp==sum) {
			System.out.println("Number is Armstrong "+temp);
			
		}
		else {
			System.out.println("Number is not Armstrong "+temp);
		}
	}

}
