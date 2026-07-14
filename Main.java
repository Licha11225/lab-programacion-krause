package Ejercicio9;

public class Main {
	public static void realizarSoundcheck(Cantante cantante) throws EspectaculoCortoException {
        if (cantante.getCantCanciones() < 5) {
            throw new EspectaculoCortoException("Repertorio insuficiente. " + cantante.getNombre() + " solo tiene " + cantante.getCantCanciones() + " canciones programadas.");
        }
        System.out.println("Soundcheck exitoso para " + cantante.getNombre());
    }

    public static void main(String[] args) {
        String[][] datosCantantes = {
            {"Taylor Swift", "Pop", "1500000", "18", "Tree Paine"},
            {"Bad Bunny", "Reggaeton", "RECHAZADO", "12", "Noah Assad"}, 
            {"Coldplay", "Rock", "1200000", "3", "Phil Harvey"},         
            {"Duki", "Trap", "500000", "14", null}                       
        };



        for (int i = 0; i <datosCantantes.length; i++) {
            String nombreIngresado = datosCantantes[i][0];
            System.out.println("Procesando a: " + nombreIngresado);

            Cantante cantante = null;

            try {
                
                String nombre = datosCantantes [i][0];
                String genero = datosCantantes[i][1];
                int cachet = Integer.parseInt(datosCantantes[i][2]); 
                int canciones = Integer.parseInt(datosCantantes[i][3]);
                String manager = datosCantantes[i][4];

                cantante = new Cantante(nombre, genero, cachet, canciones, manager);

                
                try {
                    
                    System.out.println("Manager validado: " + cantante.getManager().toUpperCase());
                } catch (NullPointerException e) {
                    System.out.println("El artista no tiene un manager registrado");
                }

                
                
                realizarSoundcheck(cantante); 

                
                cantante.liquidarHonorarios(21.0); 
                cantante.asignarEscenario("Escenario Principal");

            } catch (NumberFormatException e) {
                System.out.println("Error de formato numerico en los datos del cachet/canciones. " + e.getMessage());
            } catch (EspectaculoCortoException e) {
                System.out.println("Show cancelado: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {
                
                System.out.println("ERROR:" + e.getMessage());
            } finally {
                
                System.out.println("Finalizando intento de procesamiento para el registro.\n" + "-".repeat(40));
            }
        }
        
        System.out.println("FINAL");
    }

}
