package br.com.desafios;

import java.util.Scanner;

public class CalculadoraSalario {
	
	public static void main (String[] args) {
		
		Scanner entrada  = new Scanner(System.in);
		System.out.print("Informe o salário bruto em reais:");
		double salarioBruto = entrada.nextDouble();
		System.out.printf("O salário bruto é %2f", salarioBruto);
		double salarioInss = salarioBruto - calcularInss(salarioBruto);
		System.out.printf("\nO O desconto de INSS é de %2f", calcularInss(salarioBruto));
		System.out.printf("\nO desconto de IRRF é de %2f", calcularIrrf(salarioInss));
		double salarioBase = salarioInss - calcularIrrf(salarioInss);
		System.out.printf("\nO salário líquido é de %d", calcularSalarioLiquido(salarioBase));
		
	}
	
	private static double calcularInss(double salarioBruto) {
		
		double descontoInss = 0.00;
		
		if (salarioBruto <= 1500.00) {
			descontoInss = (salarioBruto * 0.08);
		} else if ((salarioBruto >= 1500.01) && (salarioBruto <= 4000.00)) {
			descontoInss = salarioBruto * 0.09;
		} else {
			descontoInss = salarioBruto * 0.11;
		}		
		return descontoInss;		
	}
	
	private static double calcularIrrf (double salarioInss) {
		
		double descontoIrrf = 0.00;
		
		if (salarioInss <= 3000.00) {
			return descontoIrrf;
		} else if ((salarioInss >= 3000.01) && (salarioInss <=6000.00)) {
			descontoIrrf = (salarioInss * 0.075);		
		} else {
			descontoIrrf = (salarioInss * 0.15);
		}
		return descontoIrrf;
	}
	
	public static long calcularSalarioLiquido (double salarioBase) {
		
		double salarioLiquido = 0.00;
		
		if (salarioBase <= 1039.00) {
			return 0;
		} else {
			salarioLiquido = salarioBase;
		}
		return Math.round(salarioBase);
	}

}
