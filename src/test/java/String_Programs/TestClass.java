package String_Programs;

import java.util.Scanner;


public class TestClass {
	Scanner sc = new Scanner(System.in);
	
	public void ReversString1() {
		
	   System.out.println("Enter your String: ");
	   String Input = sc.next();
	   
	   String str2=" ";
	   
	   for(int i=Input.length()-1;i>=0;i--) {
		   
		   str2 = str2 + Input.charAt(i);
	   }
		System.out.println("The Reverse String : "+str2);
		
		//using String Buffer 
		System.out.println("By using StringBuffer:");
		
		StringBuffer str1 = new StringBuffer(Input);
		str1.reverse();
		System.out.println("The Reverse string is: "+str1);
		
		//using String Builder 
				System.out.println("By using StringBuilder:");
				
				StringBuilder str3 = new StringBuilder();
				str3.append(Input);
				str3.reverse();
				
				System.out.println("The Reverse String is: "+str3);
	}
	
	public void reverseSentence() {
		
		        //String str = "Gopal Pawar";
		        
		        System.out.println("Enter your sentence: ");
		        String str = sc.nextLine();
		
		        String[] words = str.split("\\s");
		        String s2 = "";

		        // Reverse the array of words
		        for (int i = words.length - 1; i >= 0; i--) {
		            s2 = s2 + words[i] + " ";
		        }

		        // Trim the trailing space and print the result
		        System.out.println(s2);
		    }
	public void reverseEachWord() {
		
		 System.out.println("Enter your sentence: ");
	        String str = sc.nextLine();
	        
	        String[] words = str.split("\\s");
	        
	        String s2 = "";
	        
	        for(String w : words) {
	        	StringBuilder sb = new StringBuilder(w);
	        	sb.reverse();
	        	
	        	s2 = s2 + sb.toString() + " ";
	        	
	        }
		System.out.println(s2);
	}

		

	
	
 public static void main(String[] args) {
	
	 Scanner sc = new Scanner(System.in);
	 
	TestClass tc = new TestClass();
	
	System.out.println("The following program is related to Strings");
	System.out.println("1.The reverse String by using Three methods");
	System.out.println("2.Reverse Sentence");
	System.out.println("3.Reverse each word from sentence");
	
	System.out.println("\nEnter your choice: ");
	int choice =sc.nextInt();
	
	
	
	switch(choice) {
	
	case 1:
		tc.ReversString1();
		break;
		
	case 2:
		tc.reverseSentence();
		break;
		
	case 3:
		tc.reverseEachWord();
		break;
		
		default:
			System.out.println("Wrong Input");
			break;
		
	}
}
}
