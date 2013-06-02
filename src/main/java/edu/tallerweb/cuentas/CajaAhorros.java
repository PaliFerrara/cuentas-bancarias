package edu.tallerweb.cuentas;

public class CajaAhorros extends AbstractCuenta {

	private Integer extraccionNumero = 0;
	private Integer extraccionNumeroMaximo = 5;
	private Double costoExtraccion = 6.0;

	public void depositar(final Double monto) throws CuentaBancariaException {

		if	(monto < 0){
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

			extraccionNumero++;
		if (extraccionNumero > extraccionNumeroMaximo) {
			this.setSaldo(this.getSaldo() - costoExtraccion);
		}
		this.setSaldo(this.getSaldo() - monto);
	}
	}
	/*public Double getSaldo() {
		return this.getSaldo();
	}*/

	}
