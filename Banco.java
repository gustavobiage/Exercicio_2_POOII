import java.util.ArrayList;

public class Banco {
	
	private static int next_id = 0;
	private ArrayList<Conta> conta_lista = new ArrayList();
	private ArrayList<Cliente> cliente_lista = new ArrayList();
	private ArrayList<Agencia> agencia_lista = new ArrayList();

	public ArrayList<Conta> getContaLista() {
		return conta_lista;
	}

	public void setContaLista(ArrayList<Conta> list) {
		this.conta_lista = list;
	}

	public ArrayList<Agencia> getAgencia_lista() {
		return agencia_lista;
	}

	public ArrayList<Cliente> getCliente_lista() {
		return cliente_lista;
	}

	public String listar_clientes() {
		String str = new String();
		int i = 0;
		for(; i < conta_lista.size(); i++) {
			str += (i+1) + ". " + conta_lista.get(i).getNumero() + "\n";
		}

		str += (i+1) + ". Nenhum\n";
		return str;
	}

	void salvar_conta(Conta conta) {
		conta_lista.add(conta);
	}
	
	void criar_conta(int tipo, int agencia_index, int cliente_index) {
		Conta conta = new Conta();
		if(tipo == 1) {
			conta = new ContaCorrente();
		} else if(tipo == 2) {
			conta = new ContaPoupanca();
		}

		conta.setNumero(get_id_format(next_id));
		next_id++;
		this.salvar_conta(conta);
		Cliente cliente = agencia_lista.get(agencia_index).getCliente_list().get(cliente_index);
		conta.setCliente(cliente);
		System.out.print("A conta de numero (" + conta.getNumero() + ") foi criada.\n");

	}
	
	String get_id_format(int id) {

		int n = (""+id).length();

		String str = new String();
		for(int i = n; i < 6; i++) {
			str += "0";
		}
		str += id;

		return str;
	}

	void deletar_conta(String id) {
		for(int i = 0; i < conta_lista.size(); i++) {
			if(conta_lista.get(i).getNumero().equals(id)) {
				int j;
				for(j = i+1; j < conta_lista.size(); j++) {
					conta_lista.add(j-1, conta_lista.get(j));
				}
				if(j < conta_lista.size()) {
					conta_lista.remove(j);
				} else {
					conta_lista.remove(i);
				}
				break;
			}
		}

	}
	
	Conta selecionar_conta(String id) {
		for(int i = 0; i < conta_lista.size(); i++) {
			if(conta_lista.get(i).getNumero().equals(id)) {
				return conta_lista.get(i);
			}
		}

		return null;
	}
	
	void montar_movimentacao(String tipo, Conta c1, Conta c2, double valor) {

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setTipo(tipo);

		movimentacao.setTipo(tipo);
		movimentacao.setConta_um(c1);
		movimentacao.setConta_dois(c2);
		movimentacao.setValor(valor);
		movimentacao.executar_movimentacao();
		c1.getMovimentacao_list().add(movimentacao);
		if(c2 != null) c2.getMovimentacao_list().add(movimentacao);
	}
	
	String getAgencia_lista_menu() {
		String str = new String();

		int i;
		for(i = 0; i < this.agencia_lista.size(); i++) {
			str += (i+1) + ". " + agencia_lista.get(i).getNome() + "\n";
		}

		str += (i+1) + ". Nenhuma das anteriores\n";
		return str;
	}
	
	
}
