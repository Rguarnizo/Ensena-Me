/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Profesor;
import Data.Usuario;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author mateo
 */
public class Crud {
    
    public static ArrayList<Profesor> listaProfesores = new ArrayList<>();

    public static void registrarUsuario(String nombre, String apellido, String contraseña, String correo, long telefono, String carrera, int semestre, String facultad)
    {
        Login.listaUsuarios.put(correo, new Usuario(nombre, apellido, "null", contraseña, correo, telefono, carrera, semestre, facultad, null, false));
    }
    public static void registrarProfesor(String materiaDictada, double cobroPorHora, String correo, String contraseña, TableModel horario)
    {
       Usuario usuario = new Usuario();
       usuario = Logic.Login.listaUsuarios.get(correo);
       Profesor profesor = new Profesor(usuario,materiaDictada,cobroPorHora,null,horario,usuario.getNombre(),usuario.getApellido(),"null",contraseña,correo,usuario.getTelefono());
       profesor.getUsuario().setEsProfesor(true);
       listaProfesores.add( profesor);
    }
}
