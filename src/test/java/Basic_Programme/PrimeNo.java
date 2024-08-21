package Basic_Programme;

public class PrimeNo {
	
	public static void main(String[] args) {
		
		int n=45;
		int count=0;
		
		if(n<=1)
		{
			System.out.println("Is not prime no");
			return;
			
		}
		for(int i=2; i<=n/2;i++) {
	      
			if(n%i==0)
				count++;
			}
			if(count>1) {
				System.out.println("num is not prime");
			}else {
				System.out.println("num is prime");
			}
		}
	}

