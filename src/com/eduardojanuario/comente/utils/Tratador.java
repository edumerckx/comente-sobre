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
		retorno = retorno.replaceAll("[ÈÉÊË]","E");
	    retorno = retorno.replaceAll("[ÛÙÚÜ]","U");
	    retorno = retorno.replaceAll("[ÏÎÍÌ]","I");
	    retorno = retorno.replaceAll("[ÁÀÂÃÄ]","A");
	    retorno = retorno.replaceAll("[ÔÓÒÕÖ]","O");		
		retorno = retorno.replaceAll("[èéêë]","e");
		retorno = retorno.replaceAll("[ûùúü]","u");
		retorno = retorno.replaceAll("[ïîíì]","i");
		retorno = retorno.replaceAll("[ãäáàâ]","a");
		retorno = retorno.replaceAll("[ôõóòö]","o");
		retorno = retorno.replaceAll(" ", "-");
    	
		return retorno;
	}
}
