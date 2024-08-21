package Basic_Programme;

import java.util.Scanner;

public class EvenOdd {
	
	int n;
	
	Scanner sc = new Scanner(System.in);

		
	public void EvenOdd() {
		// TODO Auto-generated method stub
		
		if(n%2==0) {
			System.out.println(n+" number is even");
		}else {
			System.out.println(n+" number is odd");
		}
	}

	public static void main(String[] args) {
		
		EvenOdd EV = new EvenOdd();
		EV.EvenOdd();
		
	}
}
