/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Clase;
import Data.Profesor;
import Data.Usuario;
import static Logic.Login.listaUsuarios;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author mateo
 */
public class Crud {

    public static ArrayList<Profesor> listaProfesores = new ArrayList<>();

    public static void registrarUsuario(String nombre, String apellido, String contraseña, String correo, long telefono, String carrera, int semestre, String facultad) throws IOException {

        Login.listaUsuarios.put(correo, new Usuario(nombre, apellido, "null", contraseña, correo, telefono, carrera, semestre, facultad, new ArrayList<Clase>(), false));

    }

    public static void actualizarUsuario(String nombre, String apellido, String contraseña, String correo, long telefono, String carrera, int semestre, String facultad, boolean esProfesor) throws IOException {

        Usuario usuario = new Usuario(nombre, apellido, "null", contraseña, correo, telefono, carrera, semestre, facultad, listaUsuarios.get(correo).getListaClases(), esProfesor);
        Login.listaUsuarios.put(correo, usuario);

        String materiaDictada = "";
        double cobroPorHora = 0;
        TableModel horario = null;
        ArrayList<Clase> clases = null;

        for (int i = 0; i < listaProfesores.size(); i++) {
            if (listaProfesores.get(i).getCorreo().equals(correo)) {
                materiaDictada = listaProfesores.get(i).getMateriaDictada();
                cobroPorHora = listaProfesores.get(i).getCobroPorHora();
                horario = listaProfesores.get(i).getHorario();
                clases = listaProfesores.get(i).getListaClases();
            }

        }
        for(int i=0; i<listaProfesores.size();i++)
        {
                ArrayList<Clase> listaClasesProfesor= listaProfesores.get(i).getListaClases();
                for(int j=0; j<listaClasesProfesor.size();j++)
                {
                    listaClasesProfesor.get(j).setEstudianteQueRecibe(usuario);
                }
            
        }

        if (esProfesor) {
           
            
            for (Usuario usu : listaUsuarios.values()) {
                ArrayList<Clase> listaClasesUsuario= usu.getListaClases();
                for(int i=0; i< listaClasesUsuario.size();i++)
                {
                    if(listaClasesUsuario.get(i).getProfesorQueDicta().getCorreo().equals(correo))
                    {
                        listaClasesUsuario.get(i).setProfesorQueDicta(new Profesor(usuario, materiaDictada, cobroPorHora, clases, horario, nombre, apellido, "null", contraseña, correo, telefono));
                    }
                }
                
            }
            for (int i = 0; i < listaProfesores.size(); i++) {
                if (listaProfesores.get(i).getCorreo().equals(correo)) {
                    listaProfesores.remove(i);
                }
            }
            listaProfesores.add(new Profesor(usuario, materiaDictada, cobroPorHora, clases, horario, nombre, apellido, "null", contraseña, correo, telefono));

        }

        System.out.println(listaUsuarios.get(correo));

    }

    public static void registrarProfesor(String materiaDictada, double cobroPorHora, String correo, String contraseña, TableModel horario) {
        Usuario usuario = new Usuario();
        usuario = Logic.Login.listaUsuarios.get(correo);

        Profesor profesor = new Profesor(usuario, materiaDictada, cobroPorHora, new ArrayList<Clase>(), horario, usuario.getNombre(), usuario.getApellido(), "null", contraseña, correo, usuario.getTelefono());
        profesor.getUsuario().setEsProfesor(true);
        listaProfesores.add(profesor);
    }

    public static void guardarUsuarios() {

        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Usuarios.txt"));
            salida.writeObject(listaUsuarios);
            for (Usuario usu : listaUsuarios.values()) {
                System.out.println("Ha sido guardado el usuario: " + usu.getCorreo()+ "Nombre: " +  usu.getNombre() + " Es profesor?  " + usu.getEsProfesor());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UI.Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void guardarProfesores() {

        try {
            ObjectOutputStream salidaProfesores = new ObjectOutputStream(new FileOutputStream("Profesores.txt"));
            salidaProfesores.writeObject(listaProfesores);
            for (Profesor profe : listaProfesores) {
                System.out.println("Se ha guardado el profesor: " + profe.getUsuario());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UI.Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void guardarBloques() {
        /*
        try {
            ObjectOutputStream salidaBloques = new ObjectOutputStream(new FileOutputStream("Bloques.txt"));
            salidaBloques.writeObject(blockchain);
            for (Bloque bloque : blockchain) {
                System.out.println(bloque.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UI.Login.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
    }

    public static boolean verificarEsProfesor() {
        String correo = Login.usuarioLogeado;
        for (Profesor profe : listaProfesores) {
            if (profe.getUsuario().getCorreo().equals(correo)) {
                if (profe.getUsuario().getEsProfesor()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean usuarioRegistrado(String correo) {

        boolean verif = false;
        for (Usuario usuario : Login.listaUsuarios.values()) {
            if (correo.equals(usuario.getCorreo())) {
                verif = true;
            }
        }
        return verif;
    }

}
