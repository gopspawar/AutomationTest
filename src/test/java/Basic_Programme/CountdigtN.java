package Basic_Programme;

import java.util.Scanner;

public class CountdigtN {
    Scanner sc = new Scanner(System.in);
    
	public void withoutUserDefine() {
		int n=123454, count=0;
		int n2=1234;
		
		while(n!=0) {
			n=n/10;
			count++;
		}
		System.out.println("Number of digits: "+count);
		
		String result = Integer.toString(n2);
		System.out.println(result.length());
	}
	
	public void withUserDefine() {
		int count=0;
		System.out.println("Enter your first number: ");
		int n = sc.nextInt();
		
		while(n!=0) {
			n=n/10;
			count++;
		}
		System.out.println("Number of digit "+count);
	}
	public static void main(String[] args) {
		
		CountdigtN cn = new CountdigtN();
		cn.withoutUserDefine();
		cn.withUserDefine();
	}
}
