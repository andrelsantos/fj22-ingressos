package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.descontos.DescontoDeTrintaPorCentoParaBancos;
import br.com.caelum.ingresso.model.descontos.DescontoEstudante;
import br.com.caelum.ingresso.model.descontos.SemDesconto;

public class DescontoTest {
	
	@Test
	public void deveConcederDescontoDe30PorCentoParaIngressosDeClienteDeBanco(){
		Ingresso ingresso = new Ingresso(criaSessao(),new DescontoDeTrintaPorCentoParaBancos());
		
		BigDecimal precoEsperado = new BigDecimal("22.75");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	public void deveConcederDescontoDe50PorCentoParaIngressosDeEstudante(){
		Ingresso ingresso = new Ingresso(criaSessao(),new DescontoEstudante());
		
		BigDecimal precoEsperado = new BigDecimal("16.25");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal(){
		Ingresso ingresso = new Ingresso(criaSessao(),new SemDesconto());
		
		BigDecimal precoEsperado = new BigDecimal("32.5");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	

	private Sessao criaSessao(){
		Sala sala = new Sala("Eldorado - IMAX", new BigDecimal ("20.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120),"SCI-FI", new BigDecimal("12.0"));
		Sessao sessao = new Sessao(LocalTime.now(),filme,sala);
		return sessao;
	}
	
}
