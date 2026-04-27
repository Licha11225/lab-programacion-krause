package tpn1;

import java.util.Scanner;

public class ejercicio11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int[] numeros = new int[5];

	       for (int i = 0; i < 5; i++) {
	        	System.out.println("ingrese un numero");
	            numeros[i] = sc.nextInt();
	       }
	        
	       for (int i = 4; i >=0 ; i--) {
	    	   System.out.println(" " + numeros[i]);
	            
	       }

	}

}
