package br.com.tarefa;

import java.util.ArrayList;

public class ListaTarefas {
	
	
	ArrayList<Tarefa> tarefas = new ArrayList<>();
	
	
	public void adicionarTarefa(Tarefa tarefa) {
		
		if (tarefa != null && tarefa.calculaTamanhoTarefa() <=20) {
			this.tarefas.add(tarefa);
		} else {
			System.out.println("A tarefa é inválida!");
		}		
	}
	
	public void adicionarTarefa(String descricao) {
		
		Tarefa tarefa = new Tarefa(descricao);
		adicionarTarefa(tarefa);
	}
	
	//remoção da tarefa pela posição
	public void removerTarefa(int posicao) {
		
		if (posicao < this.tarefas.size()) {
			this.tarefas.remove(posicao);
		} else {
			System.out.println("A tarefa não existe");
		}
	}
	
	//remoção pela tarefa
	public void removerTarefa(Tarefa tarefa) {
		
		this.tarefas.remove(tarefa);
	}
	
	
	public Tarefa buscarTarefa(String descricao) {
		
		for(Tarefa tarefa: tarefas) {
			if (descricao.equals(tarefa.descricao)){
				return tarefa;
			}
		}
		System.out.println("Tarefa não encontrada");
		return null;
	}
		
		
	public void exibirTarefas() {
		
		for(Tarefa tarefa: tarefas) {
			tarefa.exibirTarefa();
		}
	}

}
