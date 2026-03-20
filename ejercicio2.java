package tpn1;

import java.util.*;

public class ejercicio2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] num = new int [10];
		int mayor = num[0];
		
		for(int i=0; i<10; i++) {
			System.out.println("Ingrese un nuevo número: ");
            num[i] = scanner.nextInt();

		}
		
		
		for(int i=0; i<10; i++) {
			
			if(num[i] > mayor) {
				mayor = num [i];
			}

		}
		
		System.out.println("el numero mayor es: " + mayor );
		
		scanner.close();

	}

}
