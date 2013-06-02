package edu.tallerweb.cuentas;

public abstract class AbstractCuenta {	
	private Double saldo = 0.0;
	private Double monto;
	
	public abstract void depositar(final Double monto);
	public abstract void extraer(final Double monto);
	
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}

}
