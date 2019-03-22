
public class ContaCorrente extends Conta {
	double lim_cheque_especial;
	double lim_saldo_final = 0 + lim_cheque_especial;
	
	
	public double getLim_cheque_especial() {
		return lim_cheque_especial;
	}
	public void setLim_cheque_especial(double lim_cheque_especial) {
		this.lim_cheque_especial = lim_cheque_especial;
	}
	public double getLim_saldo_final() {
		return lim_saldo_final;
	}
	public void setLim_saldo_final(double lim_saldo_final) {
		this.lim_saldo_final = lim_saldo_final;
	}
	
	
}
