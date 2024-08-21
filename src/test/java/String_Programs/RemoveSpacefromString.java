package String_Programs;

import java.util.Scanner;

public class RemoveSpacefromString {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the String: ");
		String input=sc.nextLine();
		
		System.out.println("The Original String: "+input);
		
		input=input.replaceAll("\\s", "");
		
		System.out.println("The Final String: "+input);
	}

}
