/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Clase;
import Data.Usuario;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public class Login {
    
    public static String usuarioLogeado;
    public static TreeMap<String, Usuario> listaUsuarios = new TreeMap<>();

    public static boolean iniciarSesion(String correo, String contraseña) {
        if (listaUsuarios.containsKey(correo) == false) {
            return false;
        } else if (listaUsuarios.get(correo).getContraseña().equals(contraseña)) {
            usuarioLogeado = correo;
            return true;
        }
        else
            return false;
    }
    public static boolean verificarSesion(String correo, String contraseña)
    {
        if(usuarioLogeado.equals(correo) && listaUsuarios.get(correo).getContraseña().equals(contraseña))
        {
            return true;
        }
        else
            return false;
    }
}
