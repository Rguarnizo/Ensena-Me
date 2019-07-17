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
public class EduCoins implements Serializable {
    private int saldo;
    private ArrayList<String> transaciones=new ArrayList<>();
    
    
    public boolean esValido()
    {
        return true;
    }
    public EduCoins() {
    }

    public EduCoins(int saldo) {
        this.saldo = saldo;
    }
    
    public EduCoins(int saldo, ArrayList<String> transaciones) {
        this.saldo = saldo;
        this.transaciones = transaciones;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public ArrayList<String> getTransaciones() {
        return transaciones;
    }

    public void setTransaciones(ArrayList<String> transaciones) {
        this.transaciones = transaciones;
    }

    

    
}
