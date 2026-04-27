package tpn1;

public class ejercicio12 {

	public static void main(String[] args) {
		
		int[] numeros = {9, 12, 18, 3, 1, 12, 23, 44};
		
		
		int mayor = numeros[0];
		int menor = numeros[0];
		
		
		for (int i = 1; i < 8; i++) {
			if (numeros[i] > mayor) {
				mayor = numeros[i];
			}
			if (numeros[i] < menor) {
				menor = numeros[i];
			}
		}
		
		System.out.println("mayor: " + mayor);
		System.out.println("menor: " + menor);

	}

}
