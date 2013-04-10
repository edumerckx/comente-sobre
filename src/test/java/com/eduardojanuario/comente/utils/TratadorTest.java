package com.eduardojanuario.comente.utils;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TratadorTest {

	@Test
	public void testGeraUrlParamAmigavel() {
		
		String param = "métodos ágeis";
		String resultado = Tratador.geraUrlParamAmigavel(param);
		
		Assert.assertEquals("metodos-ageis", resultado);
	}

}
