// Modelo 2 de Respostas baseado Conta Corrente

public class Cliente {

	// Trocou-se Integer por int
	private int agencia;

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
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

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	private int conta;

	private String cpf;

	private String nome;

	private String nascimento;

	private String endereco;

	private String telefone;
	
	//Trocou-se Float float
	private float saldo;

	private String senha;

	public void MostrarCliente() {
		System.out.println("Agência : "+ agencia);		
		System.out.println("Conta : "+ conta);
		System.out.println("Cpf : "+ cpf);
		System.out.println("Nome : "+ nome);
		System.out.println("Nascimento : "+ nascimento);
		System.out.println("Endereco : "+  endereco);
		System.out.println("Telefone : "+ telefone);		
		System.out.println("Saldo:"+ saldo);
		System.out.println("Senha:"+ senha);
		
	

	}

}
