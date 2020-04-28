package br.com.estruturas.condicional;

import java.util.Scanner;

public class EstruturaCondicional {

  
    public static void main(String[] args) {
        
    	Scanner lerNome = new Scanner(System.in);
    	String nomeDigitado;
    	System.out.printf("Digite um nome:");
    	nomeDigitado = lerNome.next();
        validarNome(nomeDigitado);
        //lerNome.close();
        
        Scanner lerIdade = new Scanner(System.in);
        int idadeDigitada;
        System.out.printf("Digite a idade:");
        idadeDigitada = lerIdade.nextInt();
        validarIdade(idadeDigitada);
        //lerIdade.close();
        
        Scanner lerFruta = new Scanner(System.in);
        String frutaDigitada;
        System.out.printf("Digite a fruta:");
        frutaDigitada = lerFruta.next();
        selecionarFruta(frutaDigitada);
        
        lerNome.close();
        lerIdade.close();
        lerFruta.close();
       
    }
    
    public static void validarNome(String nome){
        if (nome!=null){
            System.out.println("O nome informado foi " + nome);
        } else {
            System.out.println("Obrigatorio informar um nome!");
        }
    }
    
    public static void validarIdade (int idade){
        if (idade < 12){
            System.out.println("Grupo infantil"); 
        }else if (idade < 18){
            System.out.println("Grupo juvenil");
        }else {
            System.out.println("Grupo adulto");
        }
    }
    
    public static void imprimirFrutaSelecionada (String fruta){
        System.out.println("A fruta selecionada foi " + fruta);
    }
    
    public static void selecionarFruta (String fruta){
        switch (fruta){
            case "Maça":
                imprimirFrutaSelecionada(fruta);
                break;
            case "Morango":
                imprimirFrutaSelecionada(fruta);
                break;
            default:
                System.out.println("Fruta não disponível");
        }
    }
    
}
