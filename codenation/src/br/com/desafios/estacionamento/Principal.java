package br.com.desafios.estacionamento;

public class Principal {

	public static void main(String[] args) {
		
		Estacionamento estacionamento = new Estacionamento();
		
		Motorista eric = Motorista.builder()
				.withNome("Eric")
				.withIdade(40)
				.withPontos(5)
				.withHabilitacao("34573849")
				.build();
		
				 
		Carro carroPreto = Carro.builder()
				.withMotorista(eric)
				.withCor(Cor.PRETO)
				.withPlaca("NUQ-6602")
				.build();
		
		estacionamento.estacionar(carroPreto);
		
		for (int i=0; i <= 10; i++) {
			
			Motorista motorista = Motorista.builder()
					.withNome("Motorista " + i)
					.withIdade(40)
					.withPontos(5)
					.withHabilitacao("34573849"+i)
					.build();
			
			Carro carro = Carro.builder()
					.withMotorista(motorista)
					.withCor(Cor.BRANCO)
					.withPlaca("NUQ-660"+i)
					.build();
			
			estacionamento.estacionar(carro);
		}
		 System.out.println(estacionamento);
	     System.out.println(estacionamento.carrosEstacionados());		
	}
}
