import java.lang.reflect.Array;
import java.util.ArrayList;


public class Agencia {
	int next_int = 0;

	private String numero;
	private String nome;
	private String endereco;
	private ArrayList<Cliente> cliente_list = new ArrayList();

	public Agencia() {
		this.numero = get_format(next_int++);

	}

	public ArrayList<Cliente> getCliente_list() {
		return cliente_list;
	}

	public int getNext_int() {
		return next_int;
	}

	public void setNext_int(int next_int) {
		this.next_int = next_int;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

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

	public void setCliente_list(ArrayList<Cliente> cliente_list) {
		this.cliente_list = cliente_list;
	}

	public String get_format(int n) {

		String s = n +"";
		s = new String();
		int len = s.length();
		for (int i = len; i < 6 ; i++) {
			s += "0";
		}

		s += n;

		return s;
	}

	public static String criar_agencia(String nome, String end, Banco banco) {
		Agencia agencia = new Agencia();
		banco.getAgencia_lista().add(agencia);
		agencia.nome = nome;
		agencia.endereco = end;

		return "Uma agencia de numero " + agencia.numero + " foi Criada.";
	}


	public String listar_clientes() {
		String str = new String();
		int i = 0;
		for(; i < cliente_list.size(); i++) {
			str += (i+1) + ". " + cliente_list.get(i).getNome() + "\n";
		}

		str += (i+1) + ". Nenhum\n";
		return str;
	}
}
