package edu.tallerweb.cuentas;

public abstract class AbstractCuenta {
	private Double saldo = 0.0;
	private Double monto = 0.0;

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
	/**
	 * Agrega a la cuenta el monto determinado
	 * @param monto a depositar
	 */
	/**
	 * Retira de la cuenta el monto determinado
	 * @param monto a extraer
	 */
}
