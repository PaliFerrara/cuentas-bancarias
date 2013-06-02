package edu.tallerweb.cuentas;
/**
 * La más compleja de las cuentas, ésta permite establecer una
 * cantidad de dinero a girar en descubierto. Es por ello que
 * cada vez que se desee extraer dinero, no sólo se considera
 * el que se posee, sino el límite adicional que el banco
 * estará brindando.
 *
 * Por supuesto esto no es gratis, ya que el banco nos cobrará
 * un 5% como comisión sobre todo el monto en descubierto
 * consumido en la operación.
 *
 * Por ejemplo, si tuviéramos $ 100 en la cuenta, y quisiéramos
 * retirar $ 200 (con un descubierto de $ 150), podremos hacerlo.
 * Pasaremos a deberle al banco $ 105 en total: los $ 100 que
 * nos cubrió, más el 5% adicional sobre el descubierto otorgado.
 */

public class CuentaCorriente  extends AbstractCuenta {

	private final Double descubiertoTotal = 0.0;
	private Double saldototal = 0.0;
	private Double deuda = 0.0;
	private final Double porcentaje = 0.05;
	/**
	 * Toda cuenta corriente se inicia con un límite total
	 * para el descubierto.
	 * @param descubiertoTotal
	 */
	public CuentaCorriente(final Double descubiertoTotal) {
		this.saldototal = this.getSaldo() + this.descubiertoTotal;
	}
	/**
	 * Todo depósito deberá cubrir primero el descubierto,
	 * si lo hubiera, y luego contar para el saldo de la
	 * cuenta.
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) throws CuentaBancariaException {

		if (monto <= descubiertoTotal || monto < 0.0) {
			throw new CuentaBancariaException("error con el monto de la transaccion");
		}
		else {

		this.setSaldo(this.getSaldo() + monto);
		}
		}
	/**
	 * Se cobrará el 5% de comisión sobre el monto girado
	 * en descubierto.
	 * Por supuesto, no puede extraerse más que el total
	 * de la cuenta, más el descubierto (comisión incluída)
	 * @param monto a extraer
	 */
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
	public void setDeuda(final Double deuda) {
		this.deuda = deuda;
	}
}
