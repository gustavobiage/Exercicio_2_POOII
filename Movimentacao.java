
public class Movimentacao {

	private String tipo;
	private String descricao = "";
	private Conta conta_um;
	private Conta conta_dois;
	private double valor;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta_um() {
		return conta_um;
	}

	public void setConta_um(Conta conta_um) {
		this.conta_um = conta_um;
	}

	public Conta getConta_dois() {
		return conta_dois;
	}

	public void setConta_dois(Conta conta_dois) {
		this.conta_dois = conta_dois;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	void executar_movimentacao() {
		
		if(tipo.equals("saque")) {
			if(conta_um instanceof ContaCorrente) {
				if(conta_um.getSaldo() + ((ContaCorrente) conta_um).getLim_cheque_especial() >= valor && valor <= conta_um.getLim_saque()) {
					conta_um.setSaldo(conta_um.getSaldo() - valor);
					this.descricao = "Houve um saque de R$" + valor + " na conta " + conta_um.getNumero() + ".";
				} else {
					if(!(conta_um.getSaldo() + ((ContaCorrente) conta_um).getLim_cheque_especial() >= valor)) this.descricao = "Houve estouro no limite de cheque especial.";
					if(!(valor <= conta_um.getLim_saque())) this.descricao = "Houve estouro no limite de saque.";
				}
			} else if(conta_um instanceof ContaPoupanca) {
				if(conta_um.getSaldo() >= valor && valor <= conta_um.getLim_saque()) {
					conta_um.setSaldo(conta_um.getSaldo() - valor);
					this.descricao = "Houve um saque de R$" + valor + ".";
				} else {
					if(!(conta_um.getSaldo() >= valor)) this.descricao = "Saldo insuficiente.";
					if(!(conta_um.getLim_saque() >= valor)) this.descricao = "Houve estouro no limite de saque.";
				}
			}
		} else if(tipo.equals("deposito")) {
			conta_um.setSaldo(conta_um.getSaldo() + valor);
			this.descricao = "Houve um deposito de R$" + valor + " na conta " + conta_um.getNumero() + ".";
		} else if(tipo.equals("transferencia")) {
			if(conta_um instanceof ContaCorrente) {
				if(conta_um instanceof ContaCorrente) System.out.println("DONE DONE DONE");

				if(conta_um.getSaldo() + ((ContaCorrente) conta_um).getLim_cheque_especial() >= valor && valor <= conta_um.getLim_saque()) {
					conta_um.setSaldo(conta_um.getSaldo() - valor);
					this.descricao = "Houve uma Transferencia de R$" + valor + " da conta " + conta_um.getNumero() + " para a conta " + conta_dois.getNumero() + ".";
				} else {
					if(!(conta_um.getSaldo() + ((ContaCorrente) conta_um).getLim_cheque_especial() >= valor)) this.descricao = "Houve estouro no limite de cheque especial.";
					if(!(valor <= conta_um.getLim_saque())) this.descricao = "Houve estouro no limite de Transferencia.";
				}
			} else if(conta_um instanceof ContaPoupanca) {

				if(conta_um.getSaldo() >= valor && valor <= conta_um.getLim_saque()) {
					conta_um.setSaldo(conta_um.getSaldo() - valor);
					this.descricao = "Houve uma Transferencia de R$" + valor + " da conta " + conta_um.getNumero() + " para a conta " + conta_dois.getNumero() + ".";
				} else {
					if(!(conta_um.getSaldo() >= valor)) this.descricao = "Saldo insuficiente.";
					if(!(conta_um.getLim_saque() >= valor)) this.descricao = "Houve estouro no limite de Transferencia.";
				}
			}

		}
	}
	
}
