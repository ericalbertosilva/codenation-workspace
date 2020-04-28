package br.com.tarefa;

public class ArrayTarefas {
	
	Tarefa[] tarefas;
	int contador = 0;
	
	public ArrayTarefas(int tamanho) {
		
		this.tarefas = new Tarefa[tamanho];
	}
	
	public void adicionarTarefa(Tarefa tarefa) {
		
		tarefas[contador] = tarefa;
		contador++;
	}
	
	public void removerTarefa(int posicao) {
		
		tarefas[posicao] = null;
	}
	
	public void exibirTarefas() {
		
		for(Tarefa tarefa : tarefas) {
			
			tarefa.exibirTarefa();
		}
	
	}
	
}
