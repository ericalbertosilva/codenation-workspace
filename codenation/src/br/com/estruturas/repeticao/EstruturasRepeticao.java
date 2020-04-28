package br.com.estruturas.repeticao;

public class EstruturasRepeticao {

	public static void main(String[] args) {
		
		System.out.println("-------------Uso do for---------------" + "\n");
		imprimirNumerosFor(10);
		
		System.out.println("--------------Uso while----------------" + "\n");
		imprimirNumerosWhile(10);
		
		System.out.println("--------------Uso do while----------------" + "\n");
		imprimirNumerosDoWhile(10);

	}
	
	public static void imprimirNumerosFor (int limite) {
		for (int i = 0; i < limite; i++) {
			System.out.println("O número é " + i);
		}
	}
	
	public static void imprimirNumerosWhile (int numero) {
		while (numero < 100) {
			System.out.println("O número " + numero + " é menor do que 100, vamos dobrar");
			numero *=2;
		}
		System.out.println("O número agora é " + numero);
	}
	
	//No do while a condição é executada pelo menos uma vez
	public static void imprimirNumerosDoWhile (int numero) {
		do {
			System.out.println("O número é " + numero + ", vamos dobrar");
			numero *=2;
		} while (numero < 100);
		System.out.println("O número agora é " + numero);
		
	}

}
