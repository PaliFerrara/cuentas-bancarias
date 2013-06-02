package edu.tallerweb.cuentas;

public class CuentaCorriente  extends AbstractCuenta{

	final Double descubiertoTotal=0.0;
	Double saldototal = 0.0;
	Double deuda = 0.0;
	Double porcentaje = 5.0 / 100.0;
	
	public CuentaCorriente(final Double descubiertoTotal) {
		this.saldototal = this.saldo + this.descubiertoTotal;
	}
	public void depositar(final Double monto) throws CuentaBancariaException {
		
		if (monto<=descubiertoTotal){
			throw new CuentaBancariaException("El deposito no logra cubrir el descubierto");
		}
		else {
		
		this.saldo = this.saldo + monto;
		}
		}
	public void extraer(final Double monto) throws CuentaBancariaException {
		
		if (monto>=saldototal) {
			throw new CuentaBancariaException("Monto a extraer supera el limite de transaccion");
		}
		
		else {
			if (monto<this.saldo){
			
			this.saldo = this.saldo - monto;
			
			
		}
			else {
				
				this.deuda = (monto-this.saldo) * this.porcentaje + (monto - this.saldo);
			
		}			
		}
		}
	public Double getSaldo() {

		return this.saldo;
	}
	public Double getDescubierto() {
		return this.descubiertoTotal;
	}
}
