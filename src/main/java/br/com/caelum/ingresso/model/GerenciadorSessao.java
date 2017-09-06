package br.com.caelum.ingresso.model;

import java.time.LocalTime;
import java.util.List;

public class GerenciadorSessao {

	private List<Sessao> sessoes;
	
	public GerenciadorSessao(List<Sessao> sessoesExistentes){
		this.sessoes = sessoesExistentes;
	}
	
	public boolean cabe(Sessao s){
		for(Sessao sessao:sessoes){
			if(!horarioValido(s,sessao)){
				return false;
			}
		}
		
		return true;
	}

	private boolean horarioValido(Sessao s1, Sessao s2) {
		LocalTime h1 = s1.getHorario();
		LocalTime h2 = s2.getHorario();
		
		boolean ehAntes = h1.isBefore(h2);
		if(ehAntes){
			return s1.getHorarioTermino().isBefore(h2);
		}else{
			return s2.getHorarioTermino().isBefore(h1);
		}
		
	}
}
