package tpn1;

public class ejercicio13 {

	public static void main(String[] args) {
		
		String[] nombres = {"Lucas", "Junior", "Diego", "Santiago", "Lisandro"};
		double[] notas = {9.1, 1.2, 1.8, 6.5, 10.0};
		
		for (int i = 0; i < nombres.length; i++) {
			if (notas[i] >= 6) {
				System.out.println(nombres[i] + " aprobado");
			} else {
				System.out.println(nombres[i] + " reprobado");
			}
		}

	}

}