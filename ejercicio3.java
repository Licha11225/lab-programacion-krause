package tpn1;

import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] num = new int [10];
		
		
		for(int i=0; i<10; i++) {
			System.out.print("Ingrese un nuevo número: ");
            num[i] = scanner.nextInt();

		}
		
		int menor = num[0];
		
		for(int i=0; i<10; i++) {
			
			if(num[i] < menor) {
				menor = num [i];
			}

		}
		
		System.out.println("el numero menor es: " + menor );
		
		scanner.close();


	}

}
