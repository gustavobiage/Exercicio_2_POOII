
public class ContaPoupanca extends Conta{
	double taxa = 0.0005;
	double rendimento;
	
	void gerar_rendimento() {
		rendimento = this.getSaldo() * taxa;
		this.setSaldo(this.getSaldo() + rendimento);
	}
	
}
