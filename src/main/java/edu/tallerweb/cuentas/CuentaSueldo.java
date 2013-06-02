package edu.tallerweb.cuentas;

public class CuentaSueldo extends AbstractCuenta {
	
	public void depositar(final Double monto) {
		
		this.saldo = this.saldo + monto;
	}

	public void extraer(final Double monto) throws CuentaBancariaException {
		
		if (monto > this.saldo){
			
			throw new CuentaBancariaException("No se poseen fondos suficientes para la extraccion");
		}
		else {
			this.saldo = this.saldo-monto;
			}
	}
	public Double getSaldo() {
		return this.saldo;
	}

}
