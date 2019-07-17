/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public class Usuario extends Persona implements Serializable {

    private String carrera;
    private int semestre;
    private String facultad;
    private ArrayList<Clase> listaClases = new ArrayList<>();
    private boolean esProfesor;
    public EduCoins monedero;
    
    
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String direccionMonedero, String contraseña, String correo, long telefono,String carrera, int semestre, String facultad, ArrayList listaClases, boolean esProfesor) {
        super(nombre, apellido, direccionMonedero, contraseña, correo, telefono);
        this.carrera = carrera;
        this.semestre = semestre;
        this.facultad = facultad;
        this.listaClases = listaClases;
        this.esProfesor = esProfesor;
        monedero=new EduCoins(1);
    }

    public EduCoins getMonedero() {
        return monedero;
    }

    public void setMonedero(EduCoins monedero) {
        this.monedero = monedero;
    }
    


    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return this.semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getFacultad() {
        return this.facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public ArrayList getListaClases() {
        return this.listaClases;
    }

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    
    public boolean isEsProfesor() {
        return this.esProfesor;
    }

    public boolean getEsProfesor() {
        return this.esProfesor;
    }

    public void setEsProfesor(boolean esProfesor) {
        this.esProfesor = esProfesor;
    }

    public Usuario carrera(String carrera) {
        this.carrera = carrera;
        return this;
    }

    public Usuario semestre(int semestre) {
        this.semestre = semestre;
        return this;
    }

    public Usuario facultad(String facultad) {
        this.facultad = facultad;
        return this;
    }

    public Usuario listaClases(ArrayList listaClases) {
        this.listaClases = listaClases;
        return this;
    }

    public Usuario esProfesor(boolean esProfesor) {
        this.esProfesor = esProfesor;
        return this;
    }

    @Override
    public String toString() {
        return " Usuario: " + this.getCorreo() + " Contraseña: " +  this.getContraseña() +" Nombre: " + this.getNombre() +" facultad: " + this.getFacultad() + "  Balance EduCoins: " + this.monedero.getSaldo();
    }

    
}
