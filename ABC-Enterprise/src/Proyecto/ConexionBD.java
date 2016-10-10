package Proyecto;

/**
 *
 * @author Jhonier Andrés
 */
import java.sql.*;

public class ConexionBD {

    String url, usuario, password;
    Connection conexion;

    ConexionBD() {
        url = "jdbc:postgresql://localhost:5432/abcbd";
        usuario = "wayne";
        password = "arkham";
    }

    public Connection conectar() {
        try {
            // Se carga el driver
            Class.forName("org.postgresql.Driver");
            //System.out.println( "Driver Cargado" );
        } catch (Exception e) {
            System.out.println("No fue posible cargar el driver.");
        }

        try {
            //Crear el objeto de conexion a la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion Exitosa");
            return conexion;
            //Crear objeto Statement para realizar queries a la base de datos
        } catch (Exception e) {
            System.out.println("No fue posible accerder a la Base de Datos.");
            return null;
        }

    }//end connectar

    public void cerrarConexion(Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("No se pudo cerrar la conexión.");
        }
    }
}//end class
