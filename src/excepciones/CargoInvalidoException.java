package excepciones;

public class CargoInvalidoException extends Exception {
    public CargoInvalidoException(String mensaje) {
        super(mensaje);
    }
}