import java.util.ArrayList;


public class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	
	private ArrayList<Conta> conta_list = new ArrayList();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Conta> getConta_list() {
		return conta_list;
	}

	public void setConta_list(ArrayList<Conta> conta_list) {
		this.conta_list = conta_list;
	}

	public static String criarCliente(String nome, String end, String tel, String email, Agencia ag, Banco banco, int tipo, String d1, String d2) {
		
		Cliente cliente = new Cliente();
		
		if(tipo == 1) {
			cliente = new PessoaJuridica();
			((PessoaJuridica)cliente).setCnpj(d1);
		} else {
			cliente = new PessoaFisica();
			((PessoaFisica)cliente).setCpf(d1);
			((PessoaFisica)cliente).setEstadoCivil(d2);
		}
		
		cliente.nome = nome;
		cliente.endereco = end;
		cliente.telefone = tel;
		cliente.email = email;

		ag.getCliente_list().add(cliente);
		banco.getCliente_lista().add(cliente);

		return "Cliente de nome " + cliente.nome + "foi cadastrado.";
	}
}
