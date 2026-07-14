package tpn1;

import java.util.*;

public class ejercicio9 {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int [4];
		int[] numusu = new int [4];
		
		for (int i=0; i<4; i++) {
			numeros[i] = (int)(Math.random() * 9) + 1;
		}
		System.out.println("los numeros del arreglo son:");
		System.out.print(numeros[0] + " " + numeros[1] + " " + numeros[2] + " " + numeros[3]);
		Thread.sleep(1000);
		for (int i = 0; i < 50; i++) {
		    System.out.println();
		}
		System.out.println("ingrese el primer numero:");
		numusu[0] = sc.nextInt();
		
		System.out.println("ingrese el segundo numero:");
		numusu[1] = sc.nextInt();
		
		System.out.println("ingrese el tercer numero:");
		numusu[2] = sc.nextInt();
		
		System.out.println("ingrese el cuarto numero:");
		numusu[3] = sc.nextInt();
		
		if (numusu[0] == numeros[0] && numusu[1] == numeros[1] && numusu[2] == numeros[2] && numusu[3] == numeros[3]) {
			System.out.println("CORRECTOOOOOOOO");
		}
		else {
			System.out.println("incorrecto.");
		}
		 sc.close();
	}
	 
}
