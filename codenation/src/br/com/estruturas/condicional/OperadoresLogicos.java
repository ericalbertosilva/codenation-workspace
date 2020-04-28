package br.com.estruturas.condicional;

public class OperadoresLogicos {

	public static void main(String[] args) {
		
		//validarTexto(null);
		validarTexto("Eric");
		testarNumeros(1,2);		
		System.out.println(estaAptoHabilitacao("B",25));
		
	}
	
	public static void validarTexto (String texto) {
		if (texto==null) {
			System.out.println("O Texto está vazio!");
		} else {
			System.out.println("O Texto não está vazio!");
		}
	}
	
	public static void testarNumeros (int n1, int n2) {
		if (n1 == n2) {
			System.out.println("Os números são iguais");
		} else if (n1 < n2) {
			System.out.println(n1 + " é menor do que " + n2);
		} else if (n1 > n2) {
			System.out.println(n1 + " é maior do que " + n2);
		}
	}
	
	public static boolean estaAptoHabilitacao (String categoria, int idade) {
		return (categoria.equals("B") || categoria.contentEquals("AB")) && idade>=25;
	}

}
