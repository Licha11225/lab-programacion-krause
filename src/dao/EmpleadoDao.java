package dao;

import java.util.List;
import model.Empleado;

public interface EmpleadoDao {
	boolean crear(Empleado e);
    boolean actualizar(Empleado e);
    boolean eliminar(int id); 
    Empleado listarPorId(int id);
    List<Empleado> listarTodo();
    Empleado buscarPorDni(int dni);
}