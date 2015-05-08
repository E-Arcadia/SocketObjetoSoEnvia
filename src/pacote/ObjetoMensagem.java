package pacote;

import java.io.Serializable;

public class ObjetoMensagem implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String mensagem;
	private Acao acao;

	public ObjetoMensagem() {
	}
	
	public ObjetoMensagem(String nome) {
		this.nome = nome;
	}
	
	public void setMensagemAcao(String msg, Acao acao){
		this.mensagem = msg;
		this.acao = acao;
	}
	
	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getMensgem() {
		return mensagem;
	}

	public void setMensgem(String msg) {
		this.mensagem = msg;
	}

	public Acao getAction() {
		return acao;
	}

	public void setAction(Acao action) {
		this.acao = action;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acao == null) ? 0 : acao.hashCode());
		result = prime * result
				+ ((mensagem == null) ? 0 : mensagem.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjetoMensagem other = (ObjetoMensagem) obj;
		if (acao != other.acao)
			return false;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjetoMensagem [nome=" + nome + ", mensagem=" + mensagem
				+ ", acao=" + acao + "]";
	}


	public enum Acao {
		CONECTADO, DESCONECTADO, NOVA_MENSAGEM
	}
}
