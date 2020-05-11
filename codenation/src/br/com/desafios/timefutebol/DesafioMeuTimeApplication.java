package br.com.desafios.timefutebol;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private Hashtable<Long, Time> times = new Hashtable<Long, Time>();
	private Hashtable<Long, Jogador> jogadores = new Hashtable<Long, Jogador>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(times.containsKey(id))
			throw new IdentificadorUtilizadoException();

		times.put(id, new Time(nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(!times.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		if(jogadores.containsKey(id))
			throw new IdentificadorUtilizadoException();

		jogadores.put(id, new Jogador(idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		if(!jogadores.containsKey(idJogador))
			throw new JogadorNaoEncontradoException();

		Long idTime = jogadores.get(idJogador).getIdTime();
		times.get(idTime).setCapitaoId(idJogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		if(!times.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		if(times.get(idTime).getIdCapitao() == null)
			throw new CapitaoNaoInformadoException();
		return times.get(idTime).getIdCapitao();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		if(!jogadores.containsKey(idJogador))
			throw new JogadorNaoEncontradoException();
		return jogadores.get(idJogador).getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		if(!times.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		return times.get(idTime).getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if(!times.containsKey(idTime))
			throw new TimeNaoEncontradoException();

		return jogadores.entrySet().stream()
				.filter(map -> map.getValue().getIdTime().equals(idTime))
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toList()).stream()
				.map(Entry::getKey)
				.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if(!times.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		if(jogadores.entrySet().stream().filter(m -> m.getValue().getIdTime().equals(idTime)).count() == 0)
			throw new JogadorNaoEncontradoException();

		Map<Long, Integer> jogadoresTime = jogadores.entrySet().stream()
				.filter(map -> map.getValue().getIdTime().equals(idTime))
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getNivelHabilidade()));

		int bestScore = jogadoresTime.entrySet().stream()
				.collect(Collectors.toList()).stream()
				.max(Comparator.comparing(map -> map.getValue()))
				.get().getValue();

		return jogadoresTime.entrySet().stream()
				.filter(map -> map.getValue().equals(bestScore))
				.sorted(Map.Entry.comparingByKey())
				.findFirst().get().getKey();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		if(!times.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		if(jogadores.entrySet().stream().filter(m -> m.getValue().getIdTime().equals(idTime)).count() == 0)
			throw new JogadorNaoEncontradoException();

		Map<Long, LocalDate> jogadoresTime = jogadores.entrySet().stream()
				.filter(map -> map.getValue().getIdTime().equals(idTime))
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getDataNascimento()));

		LocalDate mostOldDate = jogadoresTime.entrySet().stream()
				.collect(Collectors.toList()).stream()
				.min(Comparator.comparing(map -> map.getValue()))
				.get().getValue();

		return jogadoresTime.entrySet().stream()
				.filter(map -> map.getValue().equals(mostOldDate))
				.sorted(Map.Entry.comparingByKey())
				.findFirst().get().getKey();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		if(times.size() == 0)
			return new ArrayList<>();
		List<Long> timesID = times.keySet().stream().collect(Collectors.toList());
		Collections.sort(timesID);
		return timesID;
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		if(!times.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		if(jogadores.entrySet().stream().filter(m -> m.getValue().getIdTime().equals(idTime)).count() == 0)
			throw new JogadorNaoEncontradoException();

		Map<Long, BigDecimal> score = jogadores.entrySet().stream()
				.filter(map -> map.getValue().getIdTime().equals(idTime))
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getSalario()));

		Map<Long, BigDecimal> sortedMap = score.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		return sortedMap.entrySet().stream()
				.collect(Collectors.toList())
				.stream()
				.map(Map.Entry::getKey)
				.findFirst().get();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if(!jogadores.containsKey(idJogador))
			throw new JogadorNaoEncontradoException();

		return jogadores.get(idJogador).getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		Map<Long, Integer> score = jogadores.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getNivelHabilidade()));

		Map<Long, Integer> sortedMap = score.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		List<Long> topJogadores = sortedMap.entrySet().stream()
				.collect(Collectors.toList())
				.stream()
				.map(Map.Entry::getKey)
				.limit(top)
				.collect(Collectors.toList());
		return topJogadores;
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		if(!times.containsKey(timeDaCasa))
			throw new TimeNaoEncontradoException();
		if(!times.containsKey(timeDeFora))
			throw new TimeNaoEncontradoException();

		String corCamisa = times.get(timeDeFora).getCorUniformePrincipal();
		if(corCamisa.equals(times.get(timeDaCasa).getCorUniformePrincipal()))
			return times.get(timeDeFora).getCorUniformeSecundario();
		else
			return corCamisa;
	}
}