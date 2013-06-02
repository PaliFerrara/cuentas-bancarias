package edu.tallerweb.cuentas;

public class CajaAhorros extends AbstractCuenta {

	private Integer extraccionNumero = 0;
	private final Integer extraccionNumeroMaximo = 5;
	private final Double costoExtraccion = 6.0;


	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) throws CuentaBancariaException {

		if	(monto < 0.0) {
			throw new CuentaBancariaException("error con el monto de la transaccion");
		}
		else {
		this.setSaldo(this.getSaldo() + monto);
		}
	}
	/**
	 * Se cobran $6 adicionales por cada extracción luego de
	 * la quinta.
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) throws CuentaBancariaException {

		if (monto > this.getSaldo() || monto < 0.0) {

			throw new CuentaBancariaException("error con el monto de la transaccion");
		}
		else {

			extraccionNumero++;
		if (extraccionNumero >= extraccionNumeroMaximo) {
			this.setSaldo(this.getSaldo() - costoExtraccion);
		}
		this.setSaldo(this.getSaldo() - monto);
	}
	}
	/**
	 * Permite saber el saldo de la cuenta
	 * @return el saldo de la cuenta
	 */
	/*public Double getSaldo() {
		return this.getSaldo();
	}*/

	}
