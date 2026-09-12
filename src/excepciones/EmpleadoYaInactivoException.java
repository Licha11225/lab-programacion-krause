package excepciones;

public class EmpleadoYaInactivoException extends Exception {
    public EmpleadoYaInactivoException(String mensaje) {
        super(mensaje);
    }
}