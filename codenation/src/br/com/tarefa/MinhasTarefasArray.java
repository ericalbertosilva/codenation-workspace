package br.com.tarefa;

public class MinhasTarefasArray {
	
	public static void main (String[] args) {
		
		System.out.println("Minhas tarefas");
		System.out.println("-----------------");
		
		ArrayTarefas tarefas = new ArrayTarefas(3);
		Tarefa tarefa1 = new Tarefa("Fazer a barba");
		Tarefa tarefa2 = new Tarefa("Estudar");
		Tarefa tarefa3 = new Tarefa("Dormir");
		tarefas.adicionarTarefa(tarefa1);
		tarefas.adicionarTarefa(tarefa2);
		tarefas.adicionarTarefa(tarefa3);
		tarefas.exibirTarefas();
		System.out.println("A tarefa tem " + tarefa1.calculaTamanhoTarefa() + " caracteres" + "\n");
		tarefas.removerTarefa(0);
		//exibir tarefas após remoção
		tarefas.exibirTarefas();
	}
}
