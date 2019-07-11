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
    private String materiaDictada;
    private double cobroPorHora;
    private ArrayList<Clase> listaClases;

    public Profesor(Usuario usuario, String materiaDictada, double cobroPorHora, ArrayList<Clase> listaClases, String nombre, String apellido, String direccionMonedero, String contraseña, String correo, long telefono) {
        super(nombre, apellido, direccionMonedero, contraseña, correo, telefono);
        this.usuario = usuario;
        this.materiaDictada = materiaDictada;
        this.cobroPorHora = cobroPorHora;
        this.listaClases = listaClases;
    }

   

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMateriaDictada() {
        return materiaDictada;
    }

    public void setMateriaDictada(String materiaDictada) {
        this.materiaDictada = materiaDictada;
    }

    public double getCobroPorHora() {
        return cobroPorHora;
    }

    public void setCobroPorHora(double cobroPorHora) {
        this.cobroPorHora = cobroPorHora;
    }

    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    @Override
    public String toString() {
        return "Nombre : "+ this.getNombre() + "  Dicta "+ this.materiaDictada+"Cobra: "+ this.cobroPorHora;
        
    }
    
    

    
}
