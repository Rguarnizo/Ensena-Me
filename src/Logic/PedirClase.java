/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Clase;
import Data.Profesor;
import Data.Usuario;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mateo
 */
public class PedirClase implements Serializable {
    
    public static void pedirClase(int hora, String lugar, Profesor profesorQueDicta, Usuario usuarioQueRecibe)
    {
        Date fecha = new Date();
        int año = fecha.getYear();
        int mes = fecha.getMonth();
        int dia = fecha.getDay();
        
        Date fechaCita= new Date(año,mes,dia,hora,00);
        Clase clase = new Clase(fechaCita, lugar, profesorQueDicta, usuarioQueRecibe);
        profesorQueDicta.getListaClases().add(clase);
        usuarioQueRecibe.getListaClases().add(clase);
        System.out.println(clase.toString());
        
        
    }
}
