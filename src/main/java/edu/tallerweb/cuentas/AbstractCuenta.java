package edu.tallerweb.cuentas;

public abstract class AbstractCuenta {	
	 Double saldo = 0.0;
	 Double monto;
	
	public abstract void depositar(final Double monto);	
	public abstract void extraer(final Double monto);

}
