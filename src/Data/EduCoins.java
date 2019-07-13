/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public class EduCoins implements Serializable {
    private String nombre;
    private String direccionMonedero;

    public boolean esValido()
    {
        return true;
    }
    public EduCoins() {
    }

    public EduCoins(String nombre, String direccionMonedero) {
        this.nombre = nombre;
        this.direccionMonedero = direccionMonedero;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionMonedero() {
        return this.direccionMonedero;
    }

    public void setDireccionMonedero(String direccionMonedero) {
        this.direccionMonedero = direccionMonedero;
    }

    public EduCoins nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EduCoins direccionMonedero(String direccionMonedero) {
        this.direccionMonedero = direccionMonedero;
        return this;
    }

  
    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", direccionMonedero='" + getDireccionMonedero() + "'" +
            "}";
    }
    

    
}
