package com.rcavalcanti.meusimoveis.exception;

public class ErroAutenticacao extends RuntimeException {

	private static final long serialVersionUID = -699095948206365436L;

	public ErroAutenticacao(String mensagem) {
		super(mensagem);
	}

}
