package br.com.desafios.mediamodamediana;

//import java.util.Random;
import java.util.Scanner;

public class PrincipalMediaModaMediana {

	public static void main(String[] args) {
		
		MediaModaMediana mediaModaMediana = new MediaModaMediana();
		
		Scanner ler = new Scanner(System.in);
		System.out.printf("Digite o tamanho do vetor de inteiros:");
		int tamanhoVetorInteiros = ler.nextInt(); 	
		int[] vetorInteiros = new int[tamanhoVetorInteiros];
		//Random r = new Random();
		
		for (int i=0; i < tamanhoVetorInteiros; i++) {
			//vetorInteiros[i] = r.nextInt(100);
			System.out.print("Digite o elemento " + i + " do vetor:");
			int numero = ler.nextInt();
			vetorInteiros[i] = numero;
		}
		ler.close();
		System.out.println("A média é: " + mediaModaMediana.average(vetorInteiros));
		System.out.println("A moda é: " + mediaModaMediana.mode(vetorInteiros));
		System.out.println("A mediana é: " + mediaModaMediana.median(vetorInteiros));
		
	}

}
