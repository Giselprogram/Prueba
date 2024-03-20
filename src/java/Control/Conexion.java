
package Control;

/**
 *
 * @author Jhon Gerardo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    Connection conexion = null;

    String base = "empleado"; // Nombre de la base de datos
    String url = "jdbc:mysql://localhost:3306/" + base; // Dirección, puerto y nombre de la Base de Datos
    String user = "root"; // Usuario de Acceso a MySQL
    String password = ""; // Contraseña del usuario

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                System.out.println("Error al conectar a la base de datos.");
            }
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al abrir Conexión: " + e.toString());
            return null;
        }
    }
}
