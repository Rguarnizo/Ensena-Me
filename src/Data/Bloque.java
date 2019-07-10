/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public class Bloque {
    private String hash;
    private String hashPrevio;
    private ArrayList<Transaccion> transacciones;
    private long tiempo;

    public Bloque() {
    }

    public Bloque(String hash, String hashPrevio, ArrayList<Transaccion> transacciones, long tiempo) {
        this.hash = hash;
        this.hashPrevio = hashPrevio;
        this.transacciones = transacciones;
        this.tiempo = tiempo;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHashPrevio() {
        return this.hashPrevio;
    }

    public void setHashPrevio(String hashPrevio) {
        this.hashPrevio = hashPrevio;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return this.transacciones;
    }

    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public long getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public Bloque hash(String hash) {
        this.hash = hash;
        return this;
    }

    public Bloque hashPrevio(String hashPrevio) {
        this.hashPrevio = hashPrevio;
        return this;
    }

    public Bloque transacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
        return this;
    }

    public Bloque tiempo(long tiempo) {
        this.tiempo = tiempo;
        return this;
    }


  
    @Override
    public String toString() {
        return "{" +
            " hash='" + getHash() + "'" +
            ", hashPrevio='" + getHashPrevio() + "'" +
            ", transacciones='" + getTransacciones() + "'" +
            ", tiempo='" + getTiempo() + "'" +
            "}";
    }

}
