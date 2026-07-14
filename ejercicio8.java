package tpn1;

import java.util.Scanner;

public class ejercicio8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] palabras = {"hola", "river", "java", "lisandro", "sadañoski"};
        String palabra = palabras[(int)(Math.random() * palabras.length)];

        char[] progreso = new char[palabra.length()];


        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }

        int aciertos = 0;

        while (aciertos < palabra.length()) {

            
            for (int i = 0; i < progreso.length; i++) {
                System.out.print(progreso[i] + " ");
            }
            System.out.println();

            System.out.println("ingrese una letra");
            char letra = sc.next().charAt(0);

            boolean encontro = false;

            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra && progreso[i] == '_') {
                    progreso[i] = letra;
                    aciertos++;
                    encontro = true;
                }
            }

            if (!encontro) {
                System.out.println("letra incorrecta");
            }
        }

        System.out.println("ganaste");

        sc.close();
    }
}