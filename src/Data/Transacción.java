/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public class Transaccion {
    private PrivateKey remitente;
    private PublicKey destinatario;
    private String idTransaccion;
    private double valor;

    public void generarLlaves() {

    }

    public void obtenerBalance() {

    }

    public void enviarFondos(PublicKey remitente, double valor) {

    }

    public Transaccion() {
    }

    public Transaccion(PrivateKey remitente, PublicKey destinatario, String idTransaccion, double valor) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.idTransaccion = idTransaccion;
        this.valor = valor;
    }

    public PrivateKey getRemitente() {
        return this.remitente;
    }

    public void setRemitente(PrivateKey remitente) {
        this.remitente = remitente;
    }

    public PublicKey getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(PublicKey destinatario) {
        this.destinatario = destinatario;
    }

    public String getIdTransaccion() {
        return this.idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Transaccion remitente(PrivateKey remitente) {
        this.remitente = remitente;
        return this;
    }

    public Transaccion destinatario(PublicKey destinatario) {
        this.destinatario = destinatario;
        return this;
    }

    public Transaccion idTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
        return this;
    }

    public Transaccion valor(double valor) {
        this.valor = valor;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(remitente, destinatario, idTransaccion, valor);
    }

    @Override
    public String toString() {
        return "{" + " remitente='" + getRemitente() + "'" + ", destinatario='" + getDestinatario() + "'"
                + ", idTransaccion='" + getIdTransaccion() + "'" + ", valor='" + getValor() + "'" + "}";
    }

}
