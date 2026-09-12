package service;

import dao.EmpleadoDao;
import daoimpl.EmpleadoDaoImpl;
import excepciones.*;
import model.Empleado;

import java.util.Arrays;
import java.util.List;

public class EmpleadoService implements IEmpleadoService {

    private final EmpleadoDao empleadoDao;

    private static final List<String> CARGOS_PERMITIDOS = Arrays.asList(
            "ANALISTA", "DESARROLLADOR", "GERENTE", "SOPORTE"
    );

    private static final double SALARIO_MINIMO = 0.0;

    public EmpleadoService() {
        this.empleadoDao = new EmpleadoDaoImpl();
    }

    public EmpleadoService(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }

    @Override
    public Empleado registrar(String nombre, String apellido, int dni, String cargo, double salario)
            throws DniInvalidoException, DniDuplicadoException, SalarioInvalidoException, CargoInvalidoException {

        validarDniFormato(dni);
        validarDniExistente(dni, 0);
        validarSalario(salario);
        validarCargo(cargo);

        Empleado nuevoEmpleado = new Empleado(0, nombre, apellido, dni, cargo, salario, true);

        boolean insertado = empleadoDao.crear(nuevoEmpleado);        
        if (insertado) {
            return empleadoDao.buscarPorDni(dni);
        }
        return null;
    }

    @Override
    public boolean actualizar(int id, String nombre, String apellido, int dni, String cargo, double salario)
            throws EmpleadoNoEncontradoException, DniInvalidoException, DniDuplicadoException, SalarioInvalidoException, CargoInvalidoException {

        Empleado existente = empleadoDao.listarPorId(id);
        if (existente == null) {
            throw new EmpleadoNoEncontradoException("No se encontró ningún empleado con el ID: " + id);
        }

        validarDniFormato(dni);
        validarDniExistente(dni, id);
        validarSalario(salario);
        validarCargo(cargo);

        Empleado empleadoActualizado = new Empleado(id, nombre, apellido, dni, cargo, salario, existente.isActivo());

        return empleadoDao.actualizar(empleadoActualizado);
    }

    @Override
    public boolean eliminar(int id) throws EmpleadoNoEncontradoException, EmpleadoYaInactivoException {
        Empleado emp = empleadoDao.listarPorId(id);

        if (emp == null) {
            throw new EmpleadoNoEncontradoException("No se encontró ningún empleado con el ID: " + id);
        }

        if (!emp.isActivo()) {
            throw new EmpleadoYaInactivoException("El empleado con ID " + id + " ya se encuentra inactivo.");
        }

        return empleadoDao.eliminar(id);
    }

    @Override
    public Empleado listarPorId(int id) throws EmpleadoNoEncontradoException {
        Empleado emp = empleadoDao.listarPorId(id);
        if (emp == null) {
            throw new EmpleadoNoEncontradoException("No existe un empleado registrado con el ID: " + id);
        }
        return emp;
    }

    @Override
    public List<Empleado> listarTodo() {
        return empleadoDao.listarTodo();
    }



    private void validarDniFormato(int dni) throws DniInvalidoException {
        int longitud = String.valueOf(dni).length();
        if (longitud < 7 || longitud > 8) {
            throw new DniInvalidoException("El DNI debe tener 7 u 8 dígitos. DNI ingresado: " + dni);
        }
    }

    private void validarDniExistente(int dni, int idActual) throws DniDuplicadoException {
        Empleado empExistente = empleadoDao.buscarPorDni(dni);
        if (empExistente != null && empExistente.getId() != idActual) {
            throw new DniDuplicadoException("El DNI " + dni + " ya se encuentra registrado en el sistema.");
        }
    }

    private void validarSalario(double salario) throws SalarioInvalidoException {
        if (salario <= SALARIO_MINIMO) {
            throw new SalarioInvalidoException("El salario debe ser mayor a " + SALARIO_MINIMO + ". Salario ingresado: " + salario);
        }
    }

    private void validarCargo(String cargo) throws CargoInvalidoException {
        if (cargo == null || !CARGOS_PERMITIDOS.contains(cargo.trim().toUpperCase())) {
            throw new CargoInvalidoException("El cargo '" + cargo + "' no es válido. Cargos permitidos: " + CARGOS_PERMITIDOS);
        }
    }
}