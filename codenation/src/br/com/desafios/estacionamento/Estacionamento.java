package br.com.desafios.estacionamento;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Estacionamento {

	public static final short LOTACAO_MAXIMA = 10;
	
	private List<Carro> carrosEstacionados = new LinkedList<>();
	
    public void estacionar(Carro carro) {
    	
    	  if (carrosEstacionados.size() >= LOTACAO_MAXIMA) {
              Optional<Carro> remover = carrosEstacionados
                      .stream()
                      .filter(e -> e.getMotorista().getIdade() < 55)
                      .findFirst();
              if (!remover.isPresent()) throw new EstacionamentoException("Limite de vagas do estacionamento excedido!");
              remover.ifPresent(c -> carrosEstacionados.remove(c));
              carrosEstacionados.add(carro);
          } else {
        	  carrosEstacionados.add(carro);
          }
      
    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.stream().anyMatch(c -> c.equals(carro));
    }

	@Override
	public int hashCode() {
		return Objects.hash(carrosEstacionados);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		if (carrosEstacionados == null) {
			if (other.carrosEstacionados != null)
				return false;
		} else if (!carrosEstacionados.equals(other.carrosEstacionados))
			return false;
		return true;
	}
       
}
