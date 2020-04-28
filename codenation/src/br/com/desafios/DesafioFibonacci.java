package br.com.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioFibonacci {
	
	public static void main (String[] args) {
		
		//imprime a sequência de Fibonacci
		System.out.println("A sequência de fibonacci é: " + fibonacci());
		
		Scanner lerTeclado = new Scanner(System.in);
		int numeroPesquisado;
		System.out.printf("Informe um número para realizar a pesquisa:");
		numeroPesquisado = lerTeclado.nextInt();
		isFibonacci(numeroPesquisado);	
		lerTeclado.close();
			
	}
	
	//método que retorna a sequência de Fibonacci
	public static List<Integer> fibonacci(){
		
		List<Integer> sequenciaFibonacci = new ArrayList<>();
		sequenciaFibonacci.add(0);
		sequenciaFibonacci.add(1);
		int proximoNumero = sequenciaFibonacci.get(0) + sequenciaFibonacci.get(1);
		int tamanhoSequencia = 2;
		
		while (proximoNumero < 378) {
			sequenciaFibonacci.add(proximoNumero);
			proximoNumero = sequenciaFibonacci.get(tamanhoSequencia) + sequenciaFibonacci.get(tamanhoSequencia-1);
			tamanhoSequencia++;		
		}
												
		return sequenciaFibonacci;
	}
		
	//método que recebe um Integer como parâmetro e checa se existe na sequência de Fibonacci
	public static void isFibonacci(int n) {
		
		if (fibonacci().contains(n)) {
			
			System.out.println("O número: " + n + " faz parte da sequência de Fibonacci!");
			
		} else {
			
			System.out.println("O número: " + n + " não faz parte da sequência de Fibonacci!");
			
		}
		
	}
	
}
