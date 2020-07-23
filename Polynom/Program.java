package Polynom;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

	 	System.out.println("Welcome to the Polynoms Game! Please follow the instructions.");
	    System.out.println("\n\n----FIRST POLYNOM----");
	    System.out.println("Please enter the number of elements in the first polynom.");
	    
	    int num = scanner.nextInt();
	    int[] cons1 = new int[num];
	    int[] power1 = new int[num];
		      
	    for(int i=0; i<num; i++) {
		     System.out.println("Please write a const, press enter and write the power of the current element in the polynom.");
		     cons1[i] = scanner.nextInt();
			  power1[i] = scanner.nextInt();
		}
	    Polynom p = new Polynom(cons1, power1);
			
	    System.out.println("\n\n----SECOND POLYNOM----");
	    System.out.println("Please enter the number of elements in the second polynom.");
	    num = scanner.nextInt();
	    int[] cons2 = new int[num];
	    int[] power2 = new int[num];
	      
	    for(int i=0; i<num; i++) {
	    	System.out.println("Please write a const, press enter and write the power of the current element in the polynom.");
	    	cons2[i] = scanner.nextInt();
	    	power2[i] = scanner.nextInt();
	 	}
	    Polynom p2 = new Polynom(cons2, power2);
	      
	    System.out.println("\n\n----FIRST POLYNOM----");
		p.toString();
		System.out.println("Nigzeret: ");
		p.Nigzeret().toString();
	    System.out.println("\n\n----SECOND POLYNOM----");
	    p2.toString();
		System.out.println("Nigzeret: ");
		p2.Nigzeret().toString();

		System.out.println("\n\nOpertions on Polynoms:");
		System.out.println("First PLUS Second :");
		p.plus(p2).toString();
		System.out.println("First MINUS Second :");
		p.minus(p2).toString();
		System.out.println("First Equals Second ?");
		p.equals(p2);

	    scanner.close();
		
	}

}
