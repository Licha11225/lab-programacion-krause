package tpn1;

import java.util.*;

public class ejercicio1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int total = 0;
		int[] num = new int [10];
		for(int i=0; i<10; i++) {
			System.out.println("Ingrese un nuevo número: ");
            num[i] = scanner.nextInt();

		}
		
		
		for(int i=0; i<10; i++) {
			
			total= total + num[i];
            

		}
		System.out.println("La suma de los numeros es: " + total);
		
		scanner.close();

	}

}
