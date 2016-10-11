
package Proyecto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Juan Pablo
 */
public class ManejadoraBD {
    
    ConexionBD newConnection = new ConexionBD();
    
    public int guardarUsuario(Empleado newEmpleado){
        
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
    
    
    public int GuardarSede(Sede sede){
        String sql = "INSERT INTO sedes(cod_sede, nombre, direccion) VALUES ('"+sede.getIdSede()+"','"+sede.getNombre()+
                "','"+sede.getDireccion()+"')";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            int numFilas = sentencia.executeUpdate(sql);
            conexion.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }
    //obtiene el codigo de la ultima sede registrada, para saber cual ponerle a la nueva sede a registrar
    public String obtenerMaxCodigoSede(){
        String sql = "SELECT MAX(cod_sede) FROM Sedes";
        String result = "";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);
            while(tabla.next()){
                result = tabla.getString(1);
            } 
            conexion.close();
            System.out.println("Conexion cerrada");
        }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return result;
    }
    
    
    public ArrayList<Sede> obtenerInfoSedes(String usuario){
        
        ArrayList<Sede> sedes = new ArrayList<>();
        String sql_select;
        
        if(usuario.equals("Gerente"))
        {
             sql_select = "SELECT cod_sede, nombre FROM Sedes WHERE cod_sede IN (SELECT cod_sede FROM Sedes EXCEPT SELECT cod_sede FROM Gerentes)";
        }
        else
        {
             sql_select = "SELECT cod_sede, nombre FROM Sedes";
        }
        
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
    
    
    //Busca un username en la tabla empleados
    public String buscarLogin(String username){
        String sql_select, existe="";
        sql_select = "SELECT count(*) FROM empleados where cod_empleado = '"+username+"'";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                
                existe = tabla.getString(1);
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return existe;
    }
    
    
    //Se encarga de obtener la información del usuario que se acaba de loggear
    public ArrayList<String> obtenerInfoDelLogin(String user){
        
        ArrayList<String> informacion = new ArrayList<>();
        
        //Se busca la informacion en la tabla empleados
        
        String sql_select, codigo="", nombre="", cargo ="";
        sql_select = "SELECT nombre,tipo FROM empleados where cod_empleado = '"+user+"'";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                codigo = user;
                nombre = tabla.getString(1);
                cargo = tabla.getString(2);
                
                //Se agrega al array que se retornará
                informacion.add(codigo); //indice 0
                informacion.add(nombre); //indice 1
                informacion.add(cargo); //indice 2
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return informacion;
    }

}
    

