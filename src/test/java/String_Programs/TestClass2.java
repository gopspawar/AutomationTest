package String_Programs;

import java.util.Scanner;

public class TestClass2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your sentece: ");
		String str = sc.nextLine();
		
		String[] word = str.split(" ");
		
		String s2 = " ";
		
		String s3=" ";
		
		for(int i=word.length-1; i>=0; i--) {
			
			s2=s2+ word[i]+" ";
		}
		for(int i=str.length()-1; i>=0; i-- ) {
			
			s3=s3+str.charAt(i);
			
		}
		System.out.println("The Reserse strng: "+s2);
		System.out.println("The Reserse strng: "+s3);
	}	
	
}
