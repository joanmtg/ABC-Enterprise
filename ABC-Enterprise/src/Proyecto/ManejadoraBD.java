
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
    
    //Busca un username y un password en la tabla Gerente
    public ArrayList<String> buscarLoginEnGerente(){
        String sql_select;
        ArrayList<String> usernames = new ArrayList<>();
        sql_select = "SELECT cod_gerente, password, nombre FROM Gerentes";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                
                String usuario = tabla.getString(1);
                String pass = tabla.getString(2);
                String nombre = tabla.getString(3);
                usernames.add(usuario);
                usernames.add(pass);
                usernames.add(nombre);
                usernames.add("Gerente");
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return usernames;
    }
    
    //Busca un username y un password en la tabla Vendedor
    public ArrayList<String> buscarLoginEnVendedor(){
        String sql_select;
        ArrayList<String> usernames = new ArrayList<>();
        sql_select = "SELECT cod_vendedor, password, nombre FROM Vendedores";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                
                String usuario = tabla.getString(1);
                String pass = tabla.getString(2);
                String nombre = tabla.getString(3);
                usernames.add(usuario);
                usernames.add(pass);
                usernames.add(nombre);
                usernames.add("Vendedor");
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return usernames;
    }
    
    //Busca un username y un password en la tabla Jefes_taller
    public ArrayList<String> buscarLoginEnJefeTaller(){
        String sql_select;
        ArrayList<String> usernames = new ArrayList<>();
        sql_select = "SELECT cod_jefet, password, nombre FROM Jefes_taller";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                
                String usuario = tabla.getString(1);
                String pass = tabla.getString(2);
                String nombre = tabla.getString(3);
                usernames.add(usuario);
                usernames.add(pass);
                usernames.add(nombre);
                usernames.add("Jefe de taller");
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return usernames;
    }
    
    
    //Se encarga de toda la lóogica del log in.
    public ArrayList<String> login(String user, String pass){
        ArrayList<String> informacion = new ArrayList<>();
        ArrayList<String> gerentes = new ArrayList<>();
        ArrayList<String> vendedores = new ArrayList<>();
        ArrayList<String> jefes = new ArrayList<>();
        
        gerentes = buscarLoginEnGerente();
        vendedores = buscarLoginEnVendedor();
        jefes = buscarLoginEnJefeTaller();
        
        //Se busca en cada una de las tablas el user.
        
        //En gerentes:
        for (int i = 0; i < gerentes.size(); i=i+4) {
            if(gerentes.get(i).equals(user) && gerentes.get(i+1).equals(pass)){
                informacion.add(gerentes.get(i)); //ID
                informacion.add(gerentes.get(i+2)); //Nombre
                informacion.add(gerentes.get(i+3)); //Cargo
                return informacion;
            }
        }
        
        //En vendedores:
        for (int i = 0; i < vendedores.size(); i=i+4) {
            if(vendedores.get(i).equals(user) && vendedores.get(i+1).equals(pass)){
                informacion.add(vendedores.get(i)); //ID
                informacion.add(vendedores.get(i+2)); //Nombre
                informacion.add(vendedores.get(i+3)); //Cargo
                return informacion;
            }
        }
        
        //En jefes_taller:
        for (int i = 0; i < jefes.size(); i=i+4) {
            if(jefes.get(i).equals(user) && jefes.get(i+1).equals(pass)){
                informacion.add(jefes.get(i)); //ID
                informacion.add(jefes.get(i+2)); //Nombre
                informacion.add(jefes.get(i+3)); //Cargo
                return informacion;
            }
        }
        
        
        return informacion;
    }

}
    

