package edu.tallerweb.cuentas;

public class CajaAhorros extends AbstractCuenta {
	
	Integer extraccionNumero = 0;
	Integer extraccionNumeroMaximo = 5;
	Double CostoExtraccion = 6.0;

	public void depositar(final Double monto) {
		
		this.saldo = this.saldo + monto;
		 
	}
	public void extraer(final Double monto) throws CuentaBancariaException {
		
		if (monto>this.saldo) {
			
			throw new CuentaBancariaException("No se poseen fondos suficientes para la extraccion");
		}
		else {
		
			extraccionNumero++;
		if (extraccionNumero > extraccionNumeroMaximo) {
			this.saldo = this.saldo - CostoExtraccion;
		}
		this.saldo = this.saldo - monto;
	}
}
	public Double getSaldo() {		
		return this.saldo;
	}

}
