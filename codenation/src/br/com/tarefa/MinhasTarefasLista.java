package br.com.tarefa;

public class MinhasTarefasLista {
	
	public static void main (String[] args) {
		
		System.out.println("Minhas tarefas");
		System.out.println("-----------------");
		
		ListaTarefas listaTarefas = new ListaTarefas();
		Tarefa tarefa1 = new Tarefa("Assistir TV");
		Tarefa tarefa2 = new Tarefa("Ler um livro");
		Tarefa tarefa3 = new Tarefa("Namorar");
		listaTarefas.adicionarTarefa(tarefa1);
		listaTarefas.adicionarTarefa(tarefa2);
		listaTarefas.adicionarTarefa(tarefa3);
		listaTarefas.exibirTarefas();
		
		listaTarefas.removerTarefa(4);
		listaTarefas.removerTarefa(tarefa1);
		listaTarefas.exibirTarefas();
		
		listaTarefas.buscarTarefa("Jogar bola");
		
		listaTarefas.adicionarTarefa("Jogar bola");
		listaTarefas.exibirTarefas();
	}
}
