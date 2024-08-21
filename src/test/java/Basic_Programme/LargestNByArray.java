package Basic_Programme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LargestNByArray {

    // Method without user-defined inputs
    public void withOutUserdefine() {
        ArrayList<Integer> x = new ArrayList<>();
        
        x.add(24);
        x.add(54);
        x.add(76);
        
        System.out.println(Collections.max(x) + " is the largest number");
    }

    // Method with user-defined inputs
    public void withUserDefine() {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter the number of elements you want to add: ");
        int n = scanner.nextInt();
        
        System.out.println("Enter " + n + " numbers:");
        
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        
        int maxNumber = Collections.max(numbers);
        System.out.println(maxNumber + " is the largest number");
    }

    public static void main(String[] args) {
        LargestNByArray a = new LargestNByArray();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Run method without user-defined inputs");
        System.out.println("2. Run method with user-defined inputs");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                a.withOutUserdefine();
                break;
            case 2:
                a.withUserDefine();
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }

        scanner.close();
    }
}
