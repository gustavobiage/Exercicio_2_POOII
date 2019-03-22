import java.util.ArrayList;


public class Conta {
	private Cliente cliente;
	private Agencia agencia;
	private String numero;
	private double lim_saque = 5000;
	private double saldo;
	private ArrayList<Movimentacao> movimentacao_list = new ArrayList();

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getLim_saque() {
		return lim_saque;
	}

	public void setLim_saque(double lim_saque) {
		this.lim_saque = lim_saque;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Movimentacao> getMovimentacao_list() {
		return movimentacao_list;
	}

	public void setMovimentacao_list(ArrayList<Movimentacao> movimentacao_list) {
		this.movimentacao_list = movimentacao_list;
	}

	String gerar_extrato() {
		String str = "Estrato da conta " + this.numero + ":\n";

		for(int i = 0; i < movimentacao_list.size(); i++) {
			str += "	" + movimentacao_list.get(i).getDescricao() + "\n";
		}
		
		return str;
	}
	
	
}
