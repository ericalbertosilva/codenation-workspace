package br.com.tarefa;

public class Tarefa {
	
	String descricao;
	
	public Tarefa (String descricao) {
		
		this.descricao = descricao;
	}
	
	public void exibirTarefa() {
		
		System.out.println(descricao);
	}
	
	public int calculaTamanhoTarefa() {
		
		return descricao.length();
		
	}

}
