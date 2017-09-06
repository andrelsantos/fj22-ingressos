package ingresso;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.GerenciadorSessao;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorSessaoTest {

	@Test
	public void deveRetornarFalseQuandoNaoCabe(){
		LocalTime duasEMeia = LocalTime.of(14, 30);
		Filme f1 = new Filme("Harry Potter", Duration.ofMinutes(120),"Aventura");
		
		Sala sala = new Sala("3D");
		
		Sessao s1 = new Sessao(duasEMeia, f1,sala);
		
		List<Sessao> sessoesExistentes = Arrays.asList(new Sessao (LocalTime.of(13,00), new Filme ("filme1",Duration.ofMinutes(120),"Tipo1"),sala),
													new Sessao (LocalTime.of(20,00), new Filme ("filme1",Duration.ofMinutes(90),"Tipo1"),sala),
													new Sessao (LocalTime.of(10,00), new Filme ("filme1",Duration.ofMinutes(150),"Tipo1"),sala));
		
		GerenciadorSessao g = new GerenciadorSessao(sessoesExistentes);
		
		Assert.assertFalse(g.cabe(s1));
	}
	
	@Test
	public void listaVazia(){
		LocalTime duasEMeia = LocalTime.of(14, 30);
		Filme f1 = new Filme("Harry Potter", Duration.ofMinutes(120),"Aventura");
		
		Sala sala = new Sala("3D");
		
		Sessao s1 = new Sessao(duasEMeia, f1,sala);
		
		List<Sessao> sessoesExistentes = Arrays.asList();
		
		GerenciadorSessao g = new GerenciadorSessao(sessoesExistentes);
		
		Assert.assertTrue(g.cabe(s1));
	}
}
