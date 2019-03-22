
public class PessoaFisica extends Cliente {
	
	public PessoaFisica() {
		
	}
	private String cpf;
	private String estado_civil;
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setEstadoCivil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
}
