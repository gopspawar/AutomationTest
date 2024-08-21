package Basic_Programme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestClass {
    Scanner sc = new Scanner(System.in);

    public void swapNumber() {
        System.out.println("Enter the First number: ");
        int a = sc.nextInt();

        System.out.println("Enter the second number: ");
        int b = sc.nextInt();

        System.out.println("Before swapping: a= " + a + " and b= " + b);

        // Swap using a temporary variable
        int temp = a;
        a = b;
        b = temp;

        System.out.println("After swapping with temp variable: a= " + a + " and b= " + b);

        // Swap back using arithmetic operations (demonstrating another method)
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swapping back using arithmetic: a= " + a + " and b= " + b);

        // Swap using bitwise XOR
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After swapping using XOR: a= " + a + " and b= " + b);
    }

    public void armstrong() {
        // Armstrong number
        int rem, sum = 0, temp;

        System.out.println("Enter your number: ");
        int n = sc.nextInt();
        temp = n;

        while (n > 0) {
            rem = n % 10;
            n = n / 10;
            sum = sum + (rem * rem * rem);
        }
        if (temp == sum) {
            System.out.println("Armstrong number: " + sum);
        } else {
            System.out.println("Not an Armstrong number: " + sum);
        }
    }

    public void fibonacci() {
        int a = 0, b = 1;

        System.out.println("Enter your range: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci Series:");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();
    }

    public void ReverseNumberAndPalindrome() {
        int rev = 0, rem;

        System.out.println("Enter your number: ");
        int n = sc.nextInt();
        int temp = n;

        while (n > 0) {
            rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        System.out.println("The reverse number is: " + rev);

        if (temp == rev) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    public void FactorialNo() {
        int fact = 1;

        System.out.println("Enter your number: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println("The factorial of " + n + " is " + fact);
    }

    public void EvenOdd() {
        System.out.println("Enter your number to check even or odd: ");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("Your number is Even");
        } else {
            System.out.println("Your number is Odd");
        }
    }

    public void PrimeNoCheck() {
        int count = 0;

        System.out.println("Enter the number to check prime or not: ");
        int n = sc.nextInt();

        if (n <= 1) {
            System.out.println("Not Prime");
            return;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
                break;
            }
        }

        if (count == 0) {
            System.out.println("The number is prime");
        } else {
            System.out.println("The number is not prime");
        }
    }

    public void largestNumberfrom3() {
        System.out.println("Enter your first number: ");
        int a = sc.nextInt();
        System.out.println("Enter your second number: ");
        int b = sc.nextInt();
        System.out.println("Enter your third number: ");
        int c = sc.nextInt();

        // Using if-else ladder
        System.out.println("\n1. Using if-else ladder");

        if (a >= b && a >= c) {
            System.out.println("The first number " + a + " is the largest.");
        } else if (b >= c) {
            System.out.println("The second number " + b + " is the largest.");
        } else {
            System.out.println("The third number " + c + " is the largest.");
        }

        // Using ArrayList
        System.out.println("\n2. Using ArrayList");
        ArrayList<Integer> x = new ArrayList<>();
        x.add(a);
        x.add(b);
        x.add(c);
        System.out.println("The largest number is " + Collections.max(x));
    }

    public void sumofDigit() {
        int sum = 0;

        System.out.println("Enter your number: ");
        int n = sc.nextInt();

        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        System.out.println("The sum of its digits is: " + sum);
    }

    public void countDigit() {
        int count = 0;

        System.out.println("Enter your number: ");
        int n = sc.nextInt();
        int temp = n;

        while (n != 0) {
            n = n / 10;
            count++;
        }

        System.out.println("The number of digits is: " + count);

        String result = Integer.toString(temp);
        System.out.println("The size of the number is: " + result.length());
    }

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        Scanner sc = new Scanner(System.in);

        System.out.println("The following are the Basic Programs: ");
        System.out.println("1. Swap number");
        System.out.println("2. Check Armstrong");
        System.out.println("3. Fibonacci Series");
        System.out.println("4. Reverse Number and check Palindrome");
        System.out.println("5. Factorial Number");
        System.out.println("6. Check if number is even or odd");
        System.out.println("7. Prime or Not");
        System.out.println("8. Find largest number from 3 digits using ArrayList and if-else ladder");
        System.out.println("9. Sum of digits");
        System.out.println("10. Count digits");

        System.out.println("\nEnter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                tc.swapNumber();
                break;
            case 2:
                tc.armstrong();
                break;
            case 3:
                tc.fibonacci();
                break;
            case 4:
                tc.ReverseNumberAndPalindrome();
                break;
            case 5:
                tc.FactorialNo();
                break;
            case 6:
                tc.EvenOdd();
                break;
            case 7:
                tc.PrimeNoCheck();
                break;
            case 8:
                tc.largestNumberfrom3();
                break;
            case 9:
                tc.sumofDigit();
                break;
            case 10:
                tc.countDigit();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

        sc.close();
    }
}
