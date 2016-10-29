
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
                 
        sql_guardar = "INSERT INTO Empleados(identificacion,nombre,password,edad,estado,telefono,email,titulo,direccion,tipo,cod_sede)"
                    + " VALUES ('" + newEmpleado.getCodigo() + "', '" + newEmpleado.getNombre() +  "',"
                    +           " '" + newEmpleado.getPassword()+ "', '" + newEmpleado.getEdad()+"',"
                    +           " '" + newEmpleado.getEstado()+"','" + newEmpleado.getTelefono()+ "',"
                    +           " '" + newEmpleado.getEmail() +"','" + newEmpleado.getTitulo() + "',"
                    +           " '" + newEmpleado.getDireccion()+"','" + newEmpleado.getTipo() + "',"
                    +           newEmpleado.getCodigoSede() + ")";
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
    
    
    public int guardarSede(Sede sede){
        String sql = "INSERT INTO sedes(nombre, direccion) VALUES ('" + sede.getNombre()+
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
    public int obtenerMaxCodigoSede(){
        String sql = "SELECT MAX(cod_sede) FROM Sedes";
        int result = 0;
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);
            while(tabla.next()){
                result = tabla.getInt(1);
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
             sql_select = "SELECT cod_sede, nombre FROM Sedes WHERE cod_sede IN (SELECT cod_sede FROM Sedes EXCEPT SELECT cod_sede FROM Empleados WHERE tipo='Gerente')";
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
               
                int codigoSede = tabla.getInt(1);
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
    public int buscarLogin(String username){
        String sql_select;
        int existe = 0;
        sql_select = "SELECT count(*) FROM empleados where identificacion = '"+username+"'";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                
                existe = tabla.getInt(1);
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return existe;
    }
    
    
    //Se encarga de obtener la información del usuario que se acaba de loggear
    public ArrayList<String> obtenerInfoDelLogin(String codUser){
        
        ArrayList<String> informacion = new ArrayList<>();
        
        //Se busca la informacion en la tabla empleados
        
        String sql_select, codigo="", nombre="", cargo ="", password="";
        sql_select = "SELECT nombre,tipo,password FROM empleados where identificacion = '"+codUser+"'";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                codigo = codUser;
                nombre = tabla.getString(1);
                cargo = tabla.getString(2);
                password = tabla.getString(3);
                
                //Se agrega al array que se retornará
                informacion.add(codigo); //indice 0
                informacion.add(nombre); //indice 1
                informacion.add(cargo); //indice 2
                informacion.add(password); //indice 3
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return informacion;
    }
    
    
    //Guarda una pieza en la BD
    public int guardarPieza(Pieza pieza){
        String sql = "INSERT INTO Piezas(nombre, precio) VALUES ('"+pieza.getNombre()+"',"+ pieza.getPrecio() +");";
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
    
    //Guarda un auto en la BD
    public int guardarAuto(Auto auto){
        String sql = "INSERT INTO automoviles(marca, modelo, precio, color, nombre) VALUES ('" +
                auto.getMarca()+"','"+ auto.getModelo()+"',"+ auto.getPrecio()+",'"+auto.getColor()+"','"+ auto.getNombre()+"');";
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
    
    
    //Obtiene la información de un usuario que se va a modificar
    public ArrayList<String> obtenerInfoUsuarioModificar(String identificacion){
        
        String sql_select = "SELECT nombre, password, edad, estado, telefono, email, titulo, direccion, tipo, cod_sede FROM empleados WHERE identificacion = '"+identificacion+"';";
        ArrayList<String> informacion = new ArrayList<>();
        
        //Se busca la informacion en la tabla empleados
        
        String nombre="",  password="", edad="", estado ="", telefono ="", email ="", titulo ="", direccion ="", tipo ="", cod_sede="";
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                nombre = tabla.getString(1);
                password = tabla.getString(2);
                edad = tabla.getString(3);
                estado = tabla.getString(4);
                telefono = tabla.getString(5);
                email = tabla.getString(6);
                titulo = tabla.getString(7);
                direccion = tabla.getString(8);
                tipo = tabla.getString(9);
                cod_sede = tabla.getString(10);
                
                //Se agrega al array que se retornará
                informacion.add(nombre); //indice 0
                informacion.add(password); //indice 1
                informacion.add(edad); //indice 2
                informacion.add(estado); //indice 3
                informacion.add(telefono); //indice 4
                informacion.add(email); //indice 5
                informacion.add(titulo); //indice 6
                informacion.add(direccion); //indice 7
                informacion.add(tipo); //indice 8
                informacion.add(cod_sede); //indice 9
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return informacion;
    }
    
    
    //Modifica la información de un usuario
    public int modificarUsuario(String identificacion, String nombre, String pass, String edad, String estado, String telefono,
            String titulo, String email, String dir, String tipo, String sede){
        
        String sql_update = "UPDATE empleados set nombre='"+nombre+"', password='"+pass+"', edad='"+edad+"',"
                + "estado='"+estado+"', telefono='"+telefono+"', email='"+email+"', titulo='"+titulo+"', "
                + "direccion='"+dir+"', tipo='"+tipo+"' WHERE identificacion ='"+identificacion+"';";
        
        try{
            Connection conexion= newConnection.conectar();
            Statement sentencia = conexion.createStatement();
            int numFilas = sentencia.executeUpdate(sql_update);
            conexion.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
        
        
    }
    
    

}
    

