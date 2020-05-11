package br.com.desafios.timefutebol;

import java.time.LocalDate;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;

public class Time {
	
	private String nome;
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;
	private Long idCapitao;
	
	public Time(String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {		

		this.nome = nome;	
		this.dataCriacao = dataCriacao;
		this.corUniformePrincipal = corUniformePrincipal;
		this.corUniformeSecundario = corUniformeSecundario;
		this.idCapitao = null;
	}
	
	
	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}
	
	public void setCorUniformePrincipal(String corUniformePrincipal) {
		this.corUniformePrincipal = corUniformePrincipal;
	}
	
	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}
	
	public void setCorUniformeSecundario(String corUniformeSecundario) {
		this.corUniformeSecundario = corUniformeSecundario;
	}
	
	public Long getIdCapitao() {
        if(idCapitao == null)
            throw new CapitaoNaoInformadoException();
        return idCapitao;
    }

    public void setCapitaoId(Long idCapitao) {
        this.idCapitao = idCapitao;
    }

}
