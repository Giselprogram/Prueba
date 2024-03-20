package Control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class accionesEmpleado {
    
    public static int registrarEmpleado(Empleado e){
        int estatus = 0;
    
        try {
            Conexion conexionDB = new Conexion();
            String q= "INSERT INTO empleado(nom_emp, pass_emp, email_emp, pais) VALUES (?,?,?,?)"; 
            PreparedStatement ps = conexionDB.getConexion().prepareStatement(q);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPassword()); 
            ps.setString(3, e.getEmail()); 
            ps.setString(4, e.getPais()); 
          
            estatus=ps.executeUpdate();
            System.out.println("Registro de empleado exitoso");
             conexionDB.getConexion().close();
        } catch (SQLException ex) {
            System.out.println("Error al registrar el empleado");
            System.out.println(ex.getMessage()); 
        }
        return estatus;
    }

    public static int actualizarEmpleado(Empleado e){
        int estatus = 0;
    
        try {
            Conexion conexionDB = new Conexion();
            String q= "UPDATE empleado SET nom_emp=?, pass_emp=?, email_emp=?, pais=? WHERE id=?";
            PreparedStatement ps = conexionDB.getConexion().prepareStatement(q);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPassword()); 
            ps.setString(3, e.getEmail()); 
            ps.setString(4, e.getPais()); 
            ps.setInt(5, e.getId()); 
          
            estatus = ps.executeUpdate();
            System.out.println("Actualización de empleado exitosa");
             conexionDB.getConexion().close();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el empleado");
            System.out.println(ex.getMessage()); 
        }
        return estatus;
    }

    public static int borrarEmpleado(int id){
        int estatus = 0;
    
        try {
            Conexion conexionDB = new Conexion();
            String q= "DELETE FROM empleado WHERE id=?";
            PreparedStatement ps = conexionDB.getConexion().prepareStatement(q);
            ps.setInt(1,id);
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminación del empleado exitosa");
             conexionDB.getConexion().close();
        } catch (SQLException ex) {
            System.out.println("Error al borrar el empleado");
            System.out.println(ex.getMessage()); 
        }
        return estatus;
    }

    public static List<Empleado> getAllEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        Conexion conexionDB = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String q = "SELECT * FROM empleado";
            ps = conexionDB.getConexion().prepareStatement(q);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setPassword(rs.getString("password"));
                e.setEmail(rs.getString("email"));
                e.setPais(rs.getString("pais"));
                lista.add(e);
            }
            System.out.println("Se encontraron empleados");
        } catch (SQLException ex) {
            System.out.println("Error al buscar el empleado");
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexionDB.getConexion() != null) conexionDB.getConexion().close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión");
                System.out.println(ex.getMessage());
            }
        }
        return lista;
    }

    public static Empleado buscarEmpleadoById(int id) {
        Empleado empleado = null;
        Conexion conexionDB = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String q = "SELECT * FROM empleado WHERE id = ?";
            ps = conexionDB.getConexion().prepareStatement(q);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                empleado = new Empleado();
                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setPassword(rs.getString("password"));
                empleado.setEmail(rs.getString("email"));
                empleado.setPais(rs.getString("pais"));
                System.out.println("Empleado encontrado con ID: " + id);
            } else {
                System.out.println("No se encontró ningún empleado con ID: " + id);
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar el empleado por ID");
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexionDB.getConexion() != null) conexionDB.getConexion().close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión");
                System.out.println(ex.getMessage());
            }
        }
        return empleado;
    }
}
