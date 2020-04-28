package br.com.desafios;

import java.util.Scanner;

public class DesafioCifraCesar {
	
	public static void main (String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.printf("Digite o texto a ser criptografado:");
		String texto = entrada.nextLine().toLowerCase();
		System.out.println(criptografarTexto(texto));
		System.out.printf("Digite o texto a ser descriptografado:");
		String texto_criptografado = entrada.nextLine().toLowerCase();
		System.out.println(descriptografarTexto(texto_criptografado));
		entrada.close();
	
	}
	
	public static void validarTexto (String texto) {
		
		if (texto.isEmpty()) {
			throw new IllegalArgumentException("O texto não pode ser vazio");
		}
		
	}
	
	public static String criptografarTexto(String texto) {
		
		validarTexto(texto);
		int chave = 3;
		StringBuilder texto_criptografado = new StringBuilder();
		int letraAscii;
		for (int i = 0; i<texto.length(); i++) {
			//trata caracteres numéricos
			if ((texto.charAt(i) >= '0') && (texto.charAt(i) <= '9')) {
				letraAscii = ((int)texto.charAt(i));
			//trata caracter espaço
			} else if ((int)texto.charAt(i) ==  32) {
				letraAscii = 32;	
			} else {
				letraAscii = ((int)texto.charAt(i)+ chave);
			}
			while (letraAscii > 126) {
				letraAscii -=94;
			}
			texto_criptografado.append((char)letraAscii);				
		}
		return texto_criptografado.toString();		
			
	}
	
	public static String descriptografarTexto(String texto) {
			
		    validarTexto(texto);
			int chave = 3;
			StringBuilder texto_descriptografado = new StringBuilder();
			int letraAscii;
			for (int i = 0; i<texto.length(); i++) {
				//trata caracteres numéricos
				if ((texto.charAt(i) >= '0') && (texto.charAt(i) <= '9')) {
					letraAscii = ((int)texto.charAt(i));
				//trata caracter espaço
				} else if ((int)texto.charAt(i) ==  32) {
					letraAscii = 32;	
				} else {
					letraAscii = ((int)texto.charAt(i)- chave);
				}
				while (letraAscii < 32) {
					letraAscii +=94;
				}
				texto_descriptografado.append((char)letraAscii);				
			}
			return texto_descriptografado.toString();		
				
	}
	
}
	
