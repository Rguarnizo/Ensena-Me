/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String direccionMonedero;
    private String contraseña;
    private String correo;
    private long telefono;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String direccionMonedero, String contraseña, String correo,
            long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccionMonedero = direccionMonedero;
        this.contraseña = contraseña;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccionMonedero() {
        return this.direccionMonedero;
    }

    public void setDireccionMonedero(String direccionMonedero) {
        this.direccionMonedero = direccionMonedero;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return this.telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Persona nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Persona apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Persona direccionMonedero(String direccionMonedero) {
        this.direccionMonedero = direccionMonedero;
        return this;
    }

    public Persona contraseña(String contraseña) {
        this.contraseña = contraseña;
        return this;
    }

    public Persona correo(String correo) {
        this.correo = correo;
        return this;
    }

    public Persona telefono(long telefono) {
        this.telefono = telefono;
        return this;
    }

    

    @Override
    public String toString() {
        return "{" + " nombre='" + getNombre() + "'" + ", apellido='" + getApellido() + "'" + ", direccionMonedero='"
                + getDireccionMonedero() + "'" + ", contraseña='" + getContraseña() + "'" + ", correo='" + getCorreo()
                + "'" + ", telefono='" + getTelefono() + "'" + "}";
    }

}
