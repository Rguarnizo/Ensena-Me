/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Usuario;

/**
 *
 * @author mateo
 */
public class Crud {
    
    public static void registrarUsuario(String nombre, String apellido, String contraseña, String correo, long telefono, String carrera, int semestre, String facultad)
    {
        Login.listaUsuarios.put(correo, new Usuario(nombre, apellido, "null", contraseña, correo, telefono, carrera, semestre, facultad, null, false));
    }
}
