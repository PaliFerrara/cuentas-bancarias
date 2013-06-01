package edu.tallerweb.cuentas;

/**
 * Similar a la CuentaSueldo, pero se pide que luego de la
 * quinta extracción de dinero se cobre un costo adicional
 * por extracción de $ 6
 */
public class CajaAhorros extends AbstractCuenta {
	
	Integer extraccion=0;
	Double CostoExtraccion=6.0;

	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		
		this.saldo = this.saldo+ monto;
		 
	}

	/**
	 * Se cobran $6 adicionales por cada extracción luego de
	 * la quinta.
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) throws CuentaBancariaException {
		
		if(monto>this.saldo){
			
			throw new CuentaBancariaException("No se poseen fondos suficientes para la extraccion");
		}
		else{
		
		extraccion++;
		if(extraccion>5){
			this.saldo=this.saldo-CostoExtraccion;
		}
		this.saldo = this.saldo-monto;
	}
}

	/**
	 * Permite saber el saldo de la cuenta
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		
		return this.saldo;
	}

}
