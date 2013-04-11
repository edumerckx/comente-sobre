package com.eduardojanuario.comente.utils;

import org.junit.Assert;
import org.junit.Test;

public class TratadorTest {

	/**
	 * Teste para palavras com acentuação
	 */
	@Test
	public void testGeraUrlParamAmigavelAcentos() {
		
		String param = "métodos ágeis";
		String resultado = Tratador.geraUrlParamAmigavel(param);
		
		Assert.assertEquals("metodos-ageis", resultado);
	}
	
	
	/**
	 * Teste para palavras com caracteres especiais como 'ç'
	 */
	@Test
	public void testGeraUrlParamAmigavelCaracteresEspeciais() {
		
		String param = "cachaça uma má ideia";
		String resultado = Tratador.geraUrlParamAmigavel(param);
		
		Assert.assertEquals("cachaca-uma-ma-ideia", resultado);
	}

}
