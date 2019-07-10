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
public class Monedero {
    private PrivateKey llavePrivada;
    private PublicKey llavePublica;
    private long balance;

    public void generarLlaves()
    {

    }
    public void obtenerBalance()
    {

    }
    public void enviarFondos(PublicKey remitente, double valor)
    {

    }

    public Monedero() {
    }

    public Monedero(PrivateKey llavePrivada, PublicKey llavePublica, long balance) {
        this.llavePrivada = llavePrivada;
        this.llavePublica = llavePublica;
        this.balance = balance;
    }

    public PrivateKey getLlavePrivada() {
        return this.llavePrivada;
    }

    public void setLlavePrivada(PrivateKey llavePrivada) {
        this.llavePrivada = llavePrivada;
    }

    public PublicKey getLlavePublica() {
        return this.llavePublica;
    }

    public void setLlavePublica(PublicKey llavePublica) {
        this.llavePublica = llavePublica;
    }

    public long getBalance() {
        return this.balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Monedero llavePrivada(PrivateKey llavePrivada) {
        this.llavePrivada = llavePrivada;
        return this;
    }

    public Monedero llavePublica(PublicKey llavePublica) {
        this.llavePublica = llavePublica;
        return this;
    }

    public Monedero balance(long balance) {
        this.balance = balance;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Monedero)) {
            return false;
        }
        Monedero monedero = (Monedero) o;
        return Objects.equals(llavePrivada, monedero.llavePrivada) && Objects.equals(llavePublica, monedero.llavePublica) && balance == monedero.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(llavePrivada, llavePublica, balance);
    }

    @Override
    public String toString() {
        return "{" +
            " llavePrivada='" + getLlavePrivada() + "'" +
            ", llavePublica='" + getLlavePublica() + "'" +
            ", balance='" + getBalance() + "'" +
            "}";
    }


}
