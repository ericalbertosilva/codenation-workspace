package br.com.desafios.mediamodamediana;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MediaModaMediana {
	
	public int average (int[] vetorInteiros) {
		
		int soma = 0;
		int media = 0;
	
		for (int i = 0; i < vetorInteiros.length; i++) {			
			soma += vetorInteiros[i];			
		}
		media = (soma/vetorInteiros.length);		
		return media;
		
	}
	
	public int mode (int[] vetorInteiros) {
		
		int moda = 0;
		int contador = 0;
		int elementoAnterior = vetorInteiros[0];
		
		Map<Integer, Integer> frequenciaNumeros = new HashMap<>();
		Arrays.sort(vetorInteiros);
		
		for (int i=0; i < vetorInteiros.length; i++) {
			if (elementoAnterior == vetorInteiros[i]) {
				contador++;			
			} else {
				contador = 0;
				contador++;
			}
			if (frequenciaNumeros.containsKey(vetorInteiros[i])) {
				frequenciaNumeros.put(vetorInteiros[i], contador);
			} else {
				frequenciaNumeros.put(vetorInteiros[i], contador);			
			} elementoAnterior = vetorInteiros[i];
		}
		contador = 0;
		Set<Map.Entry<Integer, Integer>> entradas = frequenciaNumeros.entrySet();
		for(Map.Entry<Integer, Integer> entrada: entradas){
			if (entrada.getValue() > contador){
				contador = entrada.getValue();
				moda = entrada.getKey();
			}
		}
		return moda;
	
	}
	
	public int median (int[] vetorInteiros) {
		
		int mediana = 0;
		Arrays.sort(vetorInteiros);
		
		//se o número for ímpar
		if ((vetorInteiros.length % 2) != 0) {
			int posicao = (vetorInteiros.length + 1)/2;
			mediana = vetorInteiros[posicao-1];		
		} else {
			int posicao = Math.round((vetorInteiros.length + 1) / 2) - 1;
			mediana = (vetorInteiros[posicao] + vetorInteiros[posicao+1])/2;		
		}
		return mediana;
	}
}
