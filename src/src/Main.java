package src;

import excepciones.*;
import model.Empleado;
import service.EmpleadoService;
import service.IEmpleadoService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IEmpleadoService service = new EmpleadoService();

        System.out.println("=================================================");
        System.out.println("      PRUEBAS DE VALIDACIONES Y EXCEPCIONES      ");
        System.out.println("=================================================\n");


        System.out.println("--> PRUEBA 1: Registrar con DNI corto (1234)");
        try {
            service.registrar("Carlos", "Pérez", 1234, "ANALISTA", 2000.0);
        } catch (DniInvalidoException | DniDuplicadoException | SalarioInvalidoException | CargoInvalidoException e) {
            System.out.println(" Error capturado: " + e.getMessage());
        }


        System.out.println("\n--> PRUEBA 2: Registrar con DNI duplicado (38456123)");
        try {
            service.registrar("Pedro", "Gómez", 38456123, "ANALISTA", 2000.0);
        } catch (DniDuplicadoException e) {
            System.out.println(" Error capturado: " + e.getMessage());
        } catch (DniInvalidoException | SalarioInvalidoException | CargoInvalidoException e) {
            System.out.println(" Otro error: " + e.getMessage());
        }

  
        System.out.println("\n--> PRUEBA 3: Registrar con cargo no permitido ('Arquitecto')");
        try {
            service.registrar("Mariano", "López", 41239876, "Arquitecto", 2500.0);
        } catch (CargoInvalidoException e) {
            System.out.println(" Error capturado: " + e.getMessage());
        } catch (DniInvalidoException | DniDuplicadoException | SalarioInvalidoException e) {
            System.out.println(" Otro error: " + e.getMessage());
        }

       
        System.out.println("\n--> PRUEBA 4: Registrar con salario <= 0");
        try {
            service.registrar("Marcos", "Sosa", 42333444, "DESARROLLADOR", -500.0);
        } catch (SalarioInvalidoException e) {
            System.out.println(" Error capturado: " + e.getMessage());
        } catch (DniInvalidoException | DniDuplicadoException | CargoInvalidoException e) {
            System.out.println(" Otro error: " + e.getMessage());
        }

        System.out.println("\n--> PRUEBA 5: Actualizar empleado con ID inexistente (ID: 9999)");
        try {
            service.actualizar(9999, "Juan", "Martínez", 40111222, "GERENTE", 3500.0);
        } catch (EmpleadoNoEncontradoException e) {
            System.out.println(" Error capturado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Otro error: " + e.getMessage());
        }

 
        System.out.println("\n--> PRUEBA 6: Eliminar dos veces al mismo empleado (ID: 2)");
        try {
            boolean exito = service.eliminar(2);
            if (exito) {
                System.out.println(" Primera eliminación realizada con éxito para el ID 2.");
            }

        
            service.eliminar(2);
        } catch (EmpleadoYaInactivoException e) {
            System.out.println(" Error capturado en el segundo intento: " + e.getMessage());
        } catch (EmpleadoNoEncontradoException e) {
            System.out.println(" Error de ID inexistente: " + e.getMessage());
        }

  
        System.out.println("\n--> PRUEBA 7: Buscar/Listar por ID inexistente (ID: 8888)");
        try {
            service.listarPorId(8888);
        } catch (EmpleadoNoEncontradoException e) {
            System.out.println(" Error capturado: " + e.getMessage());
        }

  
        System.out.println("\n--> PRUEBA 8: Listar todos los empleados activos");
        List<Empleado> listaActivos = service.listarTodo();
        System.out.println("Empleados activos encontrados (" + listaActivos.size() + "):");
        for (Empleado emp : listaActivos) {
            System.out.println(" - " + emp);
        }

        System.out.println("\n=================================================");
        System.out.println("            FIN DE LAS PRUEBAS                  ");
        System.out.println("=================================================");
    }
}