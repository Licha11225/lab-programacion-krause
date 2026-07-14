package Ejercicio9;

public class Cantante implements Contratable {
    private String nombre;
    private String generoMusical;
    private int cachet;
    private int cantCanciones;
    private String manager;

    public Cantante(String nombre, String generoMusical, int cachet, int cantCanciones, String manager) {
        this.nombre = nombre;
        this.generoMusical = generoMusical;
        this.cachet = cachet;
        this.cantCanciones = cantCanciones;
        this.manager = manager;
    }

    
    public String getNombre() { return nombre; }
    public int getCantCanciones() { return cantCanciones; }
    public String getManager() { return manager; }

    @Override
    public void liquidarHonorarios(double impuestos)  {
        
        if (impuestos < 0 || impuestos > 100) {
            throw new IllegalArgumentException("El porcentaje de impuestos es inválido. Debe estar entre 0 y 100.");
        }
        
        double descuento = this.cachet * (impuestos / 100.0);
        double totalPagado = this.cachet - descuento;
        System.out.println(" -> Honorarios de " + this.nombre + " liquidados. Total a pagar (con " + impuestos + "% de imp.): $" + totalPagado);
    }

    @Override
    public void asignarEscenario(String nombreEscenario) {
        if (nombreEscenario == null) {
            throw new NullPointerException("El nombre del escenario no puede ser nulo.");
        }
        System.out.println(this.nombre + " ha sido asignado al escenario: " + nombreEscenario);
    }
}