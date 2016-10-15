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
public class Empleado {
    
    private String codigo;
    private String nombre;
    private String password;
    private String edad;
    private int estado;
    private String telefono;
    private String email;
    private String titulo;
    private String direccion;
    private int codigoSede;
    private String tipo;

    public Empleado(String codigo, String nombre, String password, String edad, int estado, String telefono, String email, String titulo, String direccion, int codigoSede, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.password = password;
        this.edad = edad;
        this.estado = estado;
        this.telefono = telefono;
        this.email = email;
        this.titulo = titulo;
        this.direccion = direccion;
        this.codigoSede = codigoSede;
        this.tipo = tipo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCodigoSede(int codigoSede) {
        this.codigoSede = codigoSede;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getEdad() {
        return edad;
    }

    public int getEstado() {
        return estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCodigoSede() {
        return codigoSede;
    }

    public String getTipo() {
        return tipo;
    }
    
    

}