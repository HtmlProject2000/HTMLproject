package bdConnect_e_DAOs;


public class evento {
	String nome, descricao, categoria, elaborador, local,data;
	int pontuacao;
	int qndPrevistaPessoas;

	public evento(String nome, String descricao, String categoria, String elaborador, String local, int pontuacao,
			String data, int qndPrevistaPessoas) {
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.elaborador = elaborador;
		this.local = local;
		this.pontuacao = pontuacao;
		this.data = data;
		this.qndPrevistaPessoas = qndPrevistaPessoas;
	}

	public String getNome() {
		return nome;
	}	
	
	public String getDescricao() {
		return descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getElaborador() {
		return elaborador;
	}

	public String getLocal() {
		return local;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public String getData() {
		return data;
	}

	public int getQtPessoas() {
		return qndPrevistaPessoas;
	}
}
