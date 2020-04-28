package diversos;

import java.util.Scanner;
import java.util.InputMismatchException;


public class ExemploDivisaoException {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean continua = true;
		
		do {
			try {
				System.out.print("Numerador:");
				int numerador = sc.nextInt();
				
				System.out.print("Denominador:");
				int denominador = sc.nextInt();
				
				int resultado = calculaDivisao(numerador,denominador);
				
				System.out.printf("O resultado é: %d",resultado);
				
				continua = false;
								
			} catch (InputMismatchException erro1) {
				System.err.println("Não é permitido inserir letras, informa apenas números inteiros!");
				sc.nextLine();
			} catch (ArithmeticException erro2) {
		        System.err.println("O número do divisor deve ser diferente de 0!");
			} finally {
		        System.out.println("\nExecução do Finally!");   
			}
		}while(continua); 
	}	
	
	public static int calculaDivisao(int numerador, int denominador) throws ArithmeticException {
		return (numerador/denominador);
	}
		
}
