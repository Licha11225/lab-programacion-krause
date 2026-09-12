package service;

import java.util.List;
import model.Empleado;
import excepciones.*;

public interface IEmpleadoService {

    Empleado registrar(String nombre, String apellido, int dni, String cargo, double salario)
            throws DniInvalidoException, DniDuplicadoException, SalarioInvalidoException, CargoInvalidoException;

    boolean actualizar(int id, String nombre, String apellido, int dni, String cargo, double salario)
            throws EmpleadoNoEncontradoException, DniInvalidoException, DniDuplicadoException, SalarioInvalidoException, CargoInvalidoException;

    boolean eliminar(int id) 
            throws EmpleadoNoEncontradoException, EmpleadoYaInactivoException;

    Empleado listarPorId(int id) 
            throws EmpleadoNoEncontradoException;

    List<Empleado> listarTodo();
}