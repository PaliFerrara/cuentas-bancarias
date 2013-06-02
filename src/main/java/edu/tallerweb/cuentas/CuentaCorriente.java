package edu.tallerweb.cuentas;

public class CuentaCorriente  extends AbstractCuenta {

	private final Double descubiertoTotal = 0.0;
	private Double saldototal = 0.0;
	private Double deuda = 0.0;
	private Double porcentaje = 0.05;

	public CuentaCorriente(final Double descubiertoTotal) {
		this.saldototal = this.getSaldo() + this.descubiertoTotal;
	}
	public void depositar(final Double monto) throws CuentaBancariaException {

		if (monto <= descubiertoTotal || monto < 0.0) {
			throw new CuentaBancariaException("error con el monto de la transaccion");
		}
		else {

		this.setSaldo(this.getSaldo() + monto);
		}
		}
	public void extraer(final Double monto) throws CuentaBancariaException {

		if (monto >= saldototal || monto < 0.0) {
			throw new CuentaBancariaException("error con el monto de la transaccion");									
		}

		else {
			if (monto < this.getSaldo()) {

			this.setSaldo(this.getSaldo() - monto);

			}
			else {

				this.setDeuda((monto - this.getSaldo()) * this.porcentaje + (monto - this.getSaldo()));

		}
		}
		}
	/*public Double getSaldo() {

		return this.getSaldo();
	}*/
	public Double getDescubierto() {
		return this.descubiertoTotal;
	}
	public Double getDeuda() {
		return deuda;
	}
	public void setDeuda(Double deuda) {
		this.deuda = deuda;
	}
}
