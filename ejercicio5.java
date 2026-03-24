package tpn1;

import java.util.Scanner;

public class ejercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int[] numeros = new int[5];

        for (int i = 0; i < 5; i++) {
        	System.out.println("ingrese un numero");
            numeros[i] = sc.nextInt();
        }

        int contadorPares = 0;
        for (int i = 0; i < 5; i++) {
            if (numeros[i] % 2 == 0) {
                contadorPares++;
            }
        }

        System.out.println("cantidad de numeros pares: " + contadorPares);

        sc.close();
    }
}