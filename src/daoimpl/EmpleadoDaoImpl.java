package daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmpleadoDao;
import model.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao {

	private static final String URL = "jdbc:mysql://localhost:3306/globant_db?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
    private static final String PASSWORD = "usbw";

    public Connection conexionBd() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean crear(Empleado e) {
        String sql = "INSERT INTO empleados (nombre, apellido, dni, cargo, salario, activo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = conexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setInt(3, e.getDni());
            ps.setString(4, e.getCargo());
            ps.setDouble(5, e.getSalario());
            ps.setBoolean(6, e.isActivo());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Empleado e) {
        String sql = "UPDATE empleados SET nombre = ?, apellido = ?, dni = ?, cargo = ?, salario = ?, activo = ? WHERE id = ?";
        try (Connection con = conexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setInt(3, e.getDni());
            ps.setString(4, e.getCargo());
            ps.setDouble(5, e.getSalario());
            ps.setBoolean(6, e.isActivo());
            ps.setInt(7, e.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "UPDATE empleados SET activo = false WHERE id = ?";
        try (Connection con = conexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Empleado listarPorId(int id) {
        String sql = "SELECT * FROM empleados WHERE id = ?";
        try (Connection con = conexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearEmpleado(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Empleado> listarTodo() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados WHERE activo = true";
        try (Connection con = conexionBd();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearEmpleado(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Empleado buscarPorDni(int dni) {
        String sql = "SELECT * FROM empleados WHERE dni = ?";
        try (Connection con = conexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearEmpleado(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        return new Empleado(
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getString("apellido"),
            rs.getInt("dni"),
            rs.getString("cargo"),
            rs.getDouble("salario"),
            rs.getBoolean("activo")
        );
    }
    
}