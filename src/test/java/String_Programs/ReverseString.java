package String_Programs;

import java.util.Scanner;

public class ReverseString {

    Scanner sc = new Scanner(System.in);

    // Method to reverse a string using StringBuilder
    public void method_with_StringBuilder() {
        System.out.println("Enter your name: ");
        String n = sc.next();
        
        StringBuilder str = new StringBuilder(n);
        str.reverse();
        
        System.out.println("The reverse string is: " + str);
    }

    // Method to reverse a string using StringBuffer
    public void method_with_StringBuffer() {
        System.out.println("Enter your name: ");
        String n = sc.next();
        
        StringBuffer str = new StringBuffer(n);
        str.reverse();
        
        System.out.println("The reverse string is: " + str);
    }

    // Method to reverse a string using charAt() method
    public void usingCharAt() {
        System.out.println("Enter your name: ");
        String str = sc.next();
        
        String reversedString = "";
        
        for (int i = str.length() - 1; i >= 0; i--) 
        {
            reversedString += str.charAt(i);
        }
        
        System.out.println("The reverse string is: " + reversedString);
        
        // Check if the original string is a palindrome
        if (str.equalsIgnoreCase(reversedString.trim())) {
            System.out.println("Given string is a palindrome.");
        } else {
            System.out.println("Given string is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ReverseString rs = new ReverseString();

        System.out.println("Choose an option:");
        System.out.println("1. Reverse with StringBuilder");
        System.out.println("2. Reverse with StringBuffer");
        System.out.println("3. Reverse using charAt() method");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                rs.method_with_StringBuilder();
                break;
            case 2:
                rs.method_with_StringBuffer();
                break;
            case 3:
                rs.usingCharAt();
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
                break;
        }
        
        sc.close();
    }
}
