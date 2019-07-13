/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Bloque;
import Data.Profesor;
import Data.Usuario;
import static Logic.Login.listaUsuarios;
import static UI.EduPay.blockchain;
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
    
    public static void registrarUsuario(String nombre, String apellido, String contraseña, String correo, long telefono, String carrera, int semestre, String facultad) throws IOException
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
    
    public static void guardarUsuarios(){
        
       try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Usuarios.txt"));
            salida.writeObject(listaUsuarios);
            for (Usuario usu : listaUsuarios.values()) {
                System.out.println("Ha sido guardado el usuario: " + usu.getCorreo());
           }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UI.Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void guardarProfesores(){
        
         try {
            ObjectOutputStream salidaProfesores = new ObjectOutputStream(new FileOutputStream("Profesores.txt"));
            salidaProfesores.writeObject(listaProfesores);
            for (Profesor profe : listaProfesores) {
            System.out.println("Se ha guardado el profesor: " +  profe.getUsuario());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UI.Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void guardarBloques(){
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
    }
        public static boolean verificarEsProfesor(){
        String correo= Login.usuarioLogeado;
        for(Profesor profe : listaProfesores)
        {
            if(profe.getUsuario().getCorreo().equals(correo))
            {
                if(profe.getUsuario().getEsProfesor())
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
    
}
