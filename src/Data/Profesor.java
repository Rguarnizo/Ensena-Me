/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public class Profesor extends Persona {
    
    private Usuario usuario;
    private ArrayList<String> listaMateriasDictadas;
    private double cobroPorHora;
    private ArrayList<Clase> listaClases;
    

    public Profesor() {
    }

    public Profesor(Usuario usuario,ArrayList<String> listaMateriasDictadas, double cobroPorHora, ArrayList<Clase> listaClases) {
        this.listaMateriasDictadas = listaMateriasDictadas;
        this.cobroPorHora = cobroPorHora;
        this.listaClases = listaClases;
        this.usuario = usuario;
    }

    public Profesor(ArrayList<String> listaMateriasDictadas, double cobroPorHora, ArrayList<Clase> listaClases, String nombre, String apellido, String direccionMonedero, String contraseña, String correo, long telefono) {
        super(nombre, apellido, direccionMonedero, contraseña, correo, telefono);
        this.listaMateriasDictadas = listaMateriasDictadas;
        this.cobroPorHora = cobroPorHora;
        this.listaClases = listaClases;
    }

    public Profesor(ArrayList<String> listaMateriasDictadas, double cobroPorHora, ArrayList<Clase> listaClases) {
        this.listaMateriasDictadas = listaMateriasDictadas;
        this.cobroPorHora = cobroPorHora;
        this.listaClases = listaClases;
    }

    public Profesor(Usuario usuario, ArrayList<String> listaMateriasDictadas, double cobroPorHora) {
        this.usuario = usuario;
        this.listaMateriasDictadas = listaMateriasDictadas;
        this.cobroPorHora = cobroPorHora;
    }

   
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<String> getListaMateriasDictadas() {
        return this.listaMateriasDictadas;
    }

    public void setListaMateriasDictadas(ArrayList<String> listaMateriasDictadas) {
        this.listaMateriasDictadas = listaMateriasDictadas;
    }

    public double getCobroPorHora() {
        return this.cobroPorHora;
    }

    public void setCobroPorHora(double cobroPorHora) {
        this.cobroPorHora = cobroPorHora;
    }

    public ArrayList<Clase> getListaClases() {
        return this.listaClases;
    }

    public void setListaClases(Clase clase) {
        this.listaClases.add(clase);
    }

    public Profesor listaMateriasDictadas(ArrayList<String> listaMateriasDictadas) {
        this.listaMateriasDictadas = listaMateriasDictadas;
        return this;
    }

    public Profesor cobroPorHora(double cobroPorHora) {
        this.cobroPorHora = cobroPorHora;
        return this;
    }

    public Profesor listaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Profesor)) {
            return false;
        }
        Profesor profesor = (Profesor) o;
        return Objects.equals(listaMateriasDictadas, profesor.listaMateriasDictadas)
                && cobroPorHora == profesor.cobroPorHora && Objects.equals(listaClases, profesor.listaClases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaMateriasDictadas, cobroPorHora, listaClases);
    }

    @Override
    public String toString() {
        return "{" + " listaMateriasDictadas='" + getListaMateriasDictadas() + "'" + ", cobroPorHora='"
                + getCobroPorHora() + "'" + ", listaClases='" + getListaClases() + "'" + "}";
    }

    public void crearProfesor() {
    };

    public void verProfesor() {
    };

    public void actualizarProfesor() {
    };

    public void eliminarProfesor() {
    };

    public void cancelarClase() {
    };

    public void verClases() {
    };
}
