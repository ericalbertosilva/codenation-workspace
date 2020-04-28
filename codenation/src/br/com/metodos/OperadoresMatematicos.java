package br.com.metodos;

public class OperadoresMatematicos {

	public static void main(String[] args) {
		
		System.out.println(somar(3,4));
		System.out.println(subtrair(3,4));
		System.out.println(multiplicar(3,4));
		System.out.println(dividir(12,4));
		System.out.println(modulo(15,4));
		System.out.println(incremento(10));

	}
	
	public static int somar (int n1, int n2) {
		return n1 + n2;
	}
	
	public static int subtrair (int n1, int n2) {
		return n1 - n2;
	}
	
	public static int multiplicar (int n1, int n2) {
		return n1 * n2;
	}
	
	public static int dividir (int n1, int n2) {
		return n1 / n2;
	}
	
	public static int modulo (int n1, int n2) {
		return n1 % n2;
	}
	
	public static int incremento (int n1) {
		return n1*=10;
	}
	
	public static void incremento2 (int n1) {
		n1++;
		++n1;
		n1+=2;
		
	}
	public static void decremento (int n1) {
		n1--;
		--n1;
		n1-=2;
	}

}
