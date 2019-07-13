package Data;

import java.io.Serializable;

public class TransaccionEntrada implements Serializable {
	public String idTransaccionSalida;
	public TransaccionSaliente UTXO; //Contiene transacciones no gastadas
	
	public TransaccionEntrada(String idTransaccionSalida) {
		this.idTransaccionSalida = idTransaccionSalida;
	}
}