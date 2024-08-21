package String_Programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindingCommonElement {

    Scanner sc = new Scanner(System.in); // Class-level Scanner object
	
    public void withoutUserdefine() {
        Integer[] array1 = {2, 3, 4, 5, 6};
        Integer[] array2 = {3, 4, 6, 7, 8};

        List<Integer> ComEle = new ArrayList<>();

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i].equals(array2[j])) {
                    ComEle.add(array1[i]);
                    break; // Optional: Stop further checking once a common element is found
                }
            }
        }

        System.out.println("The Common elements are: " + ComEle);
    }

    public void withuserDefine() {
        // Input for the first array
        System.out.print("Enter the number of elements in the first array: ");
        int n1 = sc.nextInt();
        Integer[] array1 = new Integer[n1];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n1; i++) {
            array1[i] = sc.nextInt();
        }

        // Input for the second array
        System.out.print("Enter the number of elements in the second array: ");
        int n2 = sc.nextInt();
        Integer[] array2 = new Integer[n2];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < n2; i++) {
            array2[i] = sc.nextInt();
        }

        List<Integer> ComEle = new ArrayList<>();

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i].equals(array2[j])) {
                    ComEle.add(array1[i]);
                    break; // Stop further checking once a common element is found
                }
            }
        }

        System.out.println("The common elements are: " + ComEle);
    }

    public static void main(String[] args) {
        FindingCommonElement fce = new FindingCommonElement();

        System.out.println("Without User Defined Arrays:");
        fce.withoutUserdefine();

        System.out.println("\nWith User Defined Arrays:");
        fce.withuserDefine();

       // Close the scanner after all input is done
    }
}
