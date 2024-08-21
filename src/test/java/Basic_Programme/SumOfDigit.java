package Basic_Programme;

import java.util.Scanner;

import org.testng.reporters.jq.Main;

public class SumOfDigit {

	public void withoutUserDefine() {
		int n=987, sum=0;
		
		while(n!=0) {
			sum=sum+n%10;
			n=n/10;
		}
			System.out.println(sum);
		}
	
	public void withuserdeine() {
		int sum=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your number: ");
		int n=sc.nextInt();
		
		while(n!=0) {
			sum=sum+n%10;
			n=n/10;
			
		}
		System.out.println(sum);
	
	}
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
		
     SumOfDigit a = new SumOfDigit();
	
     
     System.out.println("\n1.Run withoutuserdefine ");
     System.out.println("2.Run withuserdefine ");
     System.out.println("Enter your choice: ");
     int choice =sc.nextInt();
     
     switch (choice) {
	case 1:
		
		a.withoutUserDefine();
		break;
		
	case 2:
		
		a.withuserdeine();
		break;

	default:
		break;
	}
	}
}

