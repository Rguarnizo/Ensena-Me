/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Date;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public class Clase {

    private Date fecha;
    private String lugar ;
    private Profesor profesorQueDicta;
    private Usuario estudianteQueRecibe;

    public Clase() {
    }

    public Clase(Date fecha, String lugar, Profesor profesorQueDicta, Usuario estudianteQueRecibe) {
        this.fecha = fecha;
        this.lugar = lugar;
        this.profesorQueDicta = profesorQueDicta;
        this.estudianteQueRecibe = estudianteQueRecibe;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return this.lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Profesor getProfesorQueDicta() {
        return this.profesorQueDicta;
    }

    public void setProfesorQueDicta(Profesor profesorQueDicta) {
        this.profesorQueDicta = profesorQueDicta;
    }

    public Usuario getEstudianteQueRecibe() {
        return this.estudianteQueRecibe;
    }

    public void setEstudianteQueRecibe(Usuario estudianteQueRecibe) {
        this.estudianteQueRecibe = estudianteQueRecibe;
    }

    public Clase fecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public Clase lugar(String lugar) {
        this.lugar = lugar;
        return this;
    }

    public Clase profesorQueDicta(Profesor profesorQueDicta) {
        this.profesorQueDicta = profesorQueDicta;
        return this;
    }

    public Clase estudianteQueRecibe(Usuario estudianteQueRecibe) {
        this.estudianteQueRecibe = estudianteQueRecibe;
        return this;
    }


    @Override
    public String toString() {
        return "{" + " fecha='" + getFecha() + "'" + ", lugar='" + getLugar() + "'" + ", profesorQueDicta='"
                + getProfesorQueDicta() + "'" + ", estudianteQueRecibe='" + getEstudianteQueRecibe() + "'" + "}";
    }

    public void cancelarClase() {

    };
}
