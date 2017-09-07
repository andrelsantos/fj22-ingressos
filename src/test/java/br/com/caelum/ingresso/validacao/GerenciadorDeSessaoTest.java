package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessaoTest {

	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario() {
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		LocalTime horario = LocalTime.now();
		
		Sala sala = new Sala("Eldorado - IMAX", BigDecimal.ONE);
		
		List<Sessao> sessoes =Arrays.asList(new Sessao(horario,filme,sala));
		
		Sessao sessao=new Sessao(horario, filme, sala);
		
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		
		Assert.assertFalse(gerenciador.cabe(sessao));
		
	}
	
}
