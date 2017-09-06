package br.com.caelum.ingresso.validacao;

import java.time.Duration;
import java.time.LocalTime;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;

public class GerenciadorDeSessaoTest {

	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario() {
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI");
		LocalTime horario = LocalTime.parse("10:00:00");
		
		Sala sala = new Sala("");
		
	}
	
}
