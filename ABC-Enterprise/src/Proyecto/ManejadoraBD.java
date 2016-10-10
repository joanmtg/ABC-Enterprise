
package Proyecto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Juan Pablo
 */
public class ManejadoraBD {
    
    ConexionBD newConnection = new ConexionBD();
    
    public int guardarGerente(Empleado newEmpleado){
        
        String sql_guardar;
        
        String tipo = newEmpleado.getTipo();
        String tabla = "";
        String codVariable = "";      
        
        switch (tipo) {
            case "Gerente":
                tabla = "gerentes";
                codVariable = "cod_gerente";
                break;
            case "Vendedor":
                tabla = "vendedores";
                codVariable = "cod_vendedor";
                break;
            default:
                tabla = "jefes_taller";
                codVariable = "cod_jefeT";
                break;
        }
                        
        sql_guardar = "INSERT INTO " + tabla + "(" + codVariable + ",nombre,password,edad,estado,telefono,email,titulo,direccion,cod_sede)"
                    + " VALUES ('" + newEmpleado.getCodigo() + "', '" + newEmpleado.getNombre() +  "',"
                    +           " '" + newEmpleado.getPassword()+ "', '" + newEmpleado.getEdad()+"',"
                    +           " '" + newEmpleado.getEstado()+"','" + newEmpleado.getTelefono()+ "',"
                    +           " '" + newEmpleado.getEmail() +"','" + newEmpleado.getTitulo() + "',"
                    +           " '" + newEmpleado.getDireccion()+"','" + newEmpleado.getCodigoSede() + "')";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conexion.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }
    
        public ArrayList<Sede> obtenerInfoSedes(){
        
        ArrayList<Sede> sedes = new ArrayList<>();
        String sql_select;
        sql_select = "SELECT cod_sede, nombre FROM Sedes";
        
         try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
               
                String codigoSede = tabla.getString(1);
                String nombreSede = tabla.getString(2);
                
                Sede newSede = new Sede();
                newSede.setIdSede(codigoSede);
                newSede.setNombre(nombreSede);
                
                sedes.add(newSede);
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         
         return sedes;
    }

}
    

