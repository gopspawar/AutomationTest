package Basic_Programme;

import java.util.Scanner;

public class ATMProgramme 
{
	    private double balance;

	    public ATMProgramme(double initialBalance) 
	    {
	        this.balance = initialBalance;
	    }

	    // Method to check the current balance
	    public void checkBalance() 
	    {
	        System.out.println("Your current balance is: $" + balance);
	    }

	    // Method to deposit money
	    public void deposit(double amount) 
	    {
	        if (amount > 0) 
	        {
	            balance += amount;
	            System.out.println("Successfully deposited $" + amount);
	        } else {
	            System.out.println("Invalid deposit amount. Please try again.");
	        }
	    }

	    // Method to withdraw money
	    public void withdraw(double amount) 
	    {
	        if (amount > 0 && amount <= balance) 
	        {
	            balance -= amount;
	            System.out.println("Successfully withdrew $" + amount);
	        } else if (amount > balance) {
	            System.out.println("Insufficient balance. Please try again.");
	        } else {
	            System.out.println("Invalid withdrawal amount. Please try again.");
	        }
	    }

	    // Main method
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        ATMProgramme atm = new ATMProgramme(1000);  // Initial balance is $1000
	        boolean exit = false;

	        while (!exit) 
	        {
	            System.out.println("\nWelcome to the ATM");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Exit");
	            System.out.print("Please choose an option: ");
	            int choice = sc.nextInt();

	            switch (choice) 
	            {
	                case 1:
	                    atm.checkBalance();
	                    break;
	                    
	                case 2:
	                    System.out.print("Enter the amount to deposit: $");
	                    double depositAmount = sc.nextDouble();
	                    atm.deposit(depositAmount);
	                    break;
	                    
	                case 3:
	                    System.out.print("Enter the amount to withdraw: $");
	                    double withdrawAmount = sc.nextDouble();
	                    atm.withdraw(withdrawAmount);
	                    break;
	                    
	                case 4:
	                    System.out.println("Thank you for using the ATM. Goodbye!");
	                    exit = true;
	                    break;
	                    
	                default:
	                    System.out.println("Invalid option. Please choose again.");
	            }
	        }

	        sc.close();
	    }
	}


