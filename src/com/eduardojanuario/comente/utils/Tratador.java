package com.eduardojanuario.comente.utils;

public class Tratador {

	/**
	 * Remove os acentos e troca os 'espaços' por '-'
	 * 
	 * @param param - string que será alterada
	 * @return
	 */
	public static String geraUrlParamAmigavel(String param) {
		
		String retorno = param;
		retorno = retorno.replaceAll("[èéêëÈÉÊË]","e");
		retorno = retorno.replaceAll("[ûùúüÛÙÚÜ]","u");
		retorno = retorno.replaceAll("[ïîíìÏÎÍÌ]","i");
		retorno = retorno.replaceAll("[ãäáàâÁÀÂÃÄ]","a");
		retorno = retorno.replaceAll("[ôõóòöÔÓÒÕÖ]","o");
		retorno = retorno.replaceAll("[Çç]", "c");
		retorno = retorno.replaceAll("[Ññ]", "n");
		retorno = retorno.replaceAll(" ", "-");
    	
		return retorno;
	}
}
