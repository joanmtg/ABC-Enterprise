/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

/**
 *
 * @author Juan Pablo
 */
public class Sede {
    
    private String nombre;
    private int idSede;
    private String direccion;
        
    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int getIdSede() {
        return idSede;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
    
}