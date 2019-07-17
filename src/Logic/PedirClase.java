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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.TableModel;

/**
 *
 * @author mateo
 */
public class PedirClase implements Serializable {
    
    public static void pedirClase(int hora, String lugar, Profesor profesorQueDicta, Usuario usuarioQueRecibe, int columna)
    {
        Date fecha = new Date();
        int año = fecha.getYear();
        int mes = fecha.getMonth();
        
        Date fechaCita= new Date(año,mes,columna,hora,00);
        Clase clase = new Clase(fechaCita, lugar, profesorQueDicta, usuarioQueRecibe);
        
        Crud.listaClasesProfesor.add(clase);
        Crud.listaClasesUsuario.add(clase);
        Logic.Login.listaUsuarios.get(Login.usuarioLogeado).setListaClases(Crud.listaClasesUsuario);
        profesorQueDicta.setListaClasesProfesor(Crud.listaClasesProfesor);
               
    }
    public static void actualizarHorario(Profesor profesorQueDicta, TableModel horario)
    {
        profesorQueDicta.setHorario(horario);
    }
}
