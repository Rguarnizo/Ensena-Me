package Data;

import UI.EduPay;
import java.io.Serializable;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Monedero implements Serializable {
	public PrivateKey llavePrivada; 
	public PublicKey llavePublica;
	public HashMap<String,TransaccionSaliente> UTXOs = new HashMap<>();
        private float balance;
	
	public Monedero() {
		generarLlaves();
	}

        public float getBalance() {
            return balance;
        }

        public void setBalance(float balance) {
            this.balance = balance;
        }
		
	public void generarLlaves() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1"); //ECC Curva eliptica criptografica
			keyGen.initialize(ecSpec, random); //Generador llaves
	        KeyPair keyPair = keyGen.genKeyPair();
	        llavePrivada = keyPair.getPrivate();
	        llavePublica = keyPair.getPublic();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public float obtenerBalance() {
		float total = 0;	
        for (Map.Entry<String, TransaccionSaliente> item: EduPay.UTXOs.entrySet()){
        	TransaccionSaliente UTXO = item.getValue();
            if(UTXO.isMine(llavePublica)) { //Verificar si el saldo es mio
            	UTXOs.put(UTXO.id,UTXO); //Agregar a lista de transacciones no usadas
            	total += UTXO.valor ; 
            }
        }
                this.balance = total;
		return total;
	}
	
	public Transaccion enviarFondos(PublicKey destinatario,float valor ) {
		if(obtenerBalance() < valor) {
			JOptionPane.showMessageDialog(null, "No tiene los fondos suficientes para hacer la transaccion. Descartada",
			 " " ,JOptionPane.INFORMATION_MESSAGE);
			System.out.println();
			return null;
		}
		ArrayList<TransaccionEntrada> entradas = new ArrayList<>();
		float total = 0;
		for (Map.Entry<String, TransaccionSaliente> item: UTXOs.entrySet()){
			TransaccionSaliente UTXO = item.getValue();
			total += UTXO.valor;
			entradas.add(new TransaccionEntrada(UTXO.id));
			if(total > valor) break;
		}
		Transaccion nuevaTransaccion = new Transaccion(llavePublica, destinatario , valor, entradas);
		nuevaTransaccion.generarFirma(llavePrivada); 
		for(TransaccionEntrada entrada: entradas){
			UTXOs.remove(entrada.idTransaccionSalida);
		}
		return nuevaTransaccion;
	}
}