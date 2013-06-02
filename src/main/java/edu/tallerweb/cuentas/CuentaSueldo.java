package edu.tallerweb.cuentas;

public class CuentaSueldo extends AbstractCuenta {

	public void depositar(final Double monto) throws CuentaBancariaException {

		if	(monto < 0) {
			throw new CuentaBancariaException("error con el monto de la transaccion");
						}
		else {
		this.setSaldo(this.getSaldo() + monto);
		}
	}

	public void extraer(final Double monto) throws CuentaBancariaException {

		if (monto > this.getSaldo() || monto < 0) {

			throw new CuentaBancariaException("error con el monto de la transaccion");
												}
		else {
			this.setSaldo(this.getSaldo() - monto);
			}
	}
	/*public Double getSaldo() {
		return this.Saldo;
	}*/

}
