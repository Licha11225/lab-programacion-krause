package tpn1;

import java.util.Scanner;

public class ejercicio6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero = (int)(Math.random() * 100) + 1;
        int intento = 0;

        while (intento != numero) {
            System.out.println("ingrese un numero");
            intento = sc.nextInt();

            if (intento < numero) {
                System.out.println("mayor");
            } else if (intento > numero) {
                System.out.println("menor");
            }
        }

        System.out.println("acertaste");

        sc.close();
    }
}