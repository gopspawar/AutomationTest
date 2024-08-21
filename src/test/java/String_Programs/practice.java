package String_Programs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class practice {
    Scanner sc = new Scanner(System.in);

    public void ReverseString1() {
        // using charAt
        System.out.println("Enter your String: ");
        String str = sc.next();
        String s2 = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            s2 = s2 + str.charAt(i);
        }
        System.out.println("The Reverse String is: " + s2);
    }

    public void ReverseString2() {
        System.out.println("Enter your String: ");
        String str = sc.next();

        StringBuffer str1 = new StringBuffer(str);
        str1.reverse();

        System.out.println("The Reverse String is: " + str1);
    }

    public void ReverseString3() {
        System.out.println("Enter your String: ");
        String str = sc.next();

        StringBuilder str1 = new StringBuilder();
        str1.append(str);
        str1.reverse();

        System.out.println("The Reverse String is: " + str1);
    }

    public void RemoveSpacefromString() {
        System.out.println("Enter your String: ");
        sc.nextLine();  // Clear the newline left by nextInt
        String input = sc.nextLine();

        System.out.println("Original String: " + input);

        input = input.replaceAll("\\s", "");

        System.out.println("Final String: " + input);
    }

    public void findCommonElement() {
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {2, 3, 6, 7, 8};

        System.out.println("Array1: ");
        for (Integer num : array1) 
        {
        System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Array2: ");
        for (Integer num : array2) 
        {
            System.out.print(num + " ");
        }
        System.out.println();

        List<Integer> comEle = new ArrayList<>();

        // by using loop
        for (int i = 0; i < array1.length; i++) 
        {
            for (int j = 0; j < array2.length; j++) 
            {
                if (array1[i].equals(array2[j])) 
                {
                    comEle.add(array1[i]);
                }
            }
        }

        System.out.println("The Common Element is: " + comEle);
    }

    public void FindcommanElement2() {
    	
    	Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {2, 3, 6, 7, 8};
        
        //using retainAll
        
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(array1));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(array2));
        
        list1.retainAll(list2);
        
        System.out.println("The common element is "+list1);
    	
    
    } 
    
   public void FindCommelement3() {
	 
   }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        practice p = new practice();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Reverse String using three methods");
            System.out.println("2. Remove spaces between words");
            System.out.println("3. Find the common element from array1 and array2");
            System.out.println("4. Exit\n");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n1. Using charAt\n2. Using StringBuffer\n3. Using StringBuilder");
                    System.out.println("Please select your choice: ");
                    int ch = sc.nextInt();
                    switch (ch) {
                        case 1:
                            p.ReverseString1();
                            break;
                        case 2:
                            p.ReverseString2();
                            break;
                        case 3:
                            p.ReverseString3();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;

                case 2:
                    p.RemoveSpacefromString();
                    break;

                case 3:
                	System.out.println("\n1. Using loop mehtod\n2. Using retainAll method \n3. Using java stream");
                    System.out.println("Please select your choice: ");
                    int ch1 = sc.nextInt();
                    switch (ch1) 
                    {
                        case 1:
                        	p.findCommonElement();
                            break;
                        case 2:
                            p.FindcommanElement2();
                            break;
                      
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Program. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("You entered the wrong input.");
                    exit = true;
                    break;
            }
        }
        sc.close();
    }
}
