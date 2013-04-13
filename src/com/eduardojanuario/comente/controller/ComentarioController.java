/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.eduardojanuario.comente.controller;

import java.util.List;

import org.json.simple.JSONObject;

import com.eduardojanuario.comente.dao.ComentarioDao;
import com.eduardojanuario.comente.model.Comentario;
import com.eduardojanuario.comente.utils.Tratador;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ComentarioController {

	private final Result result;
	private Validator validator;
	private ComentarioDao dao;

	public ComentarioController(Result result, Validator validator, ComentarioDao dao) {
		this.result = result;
		this.validator = validator;
		this.dao = dao;
	}

	@Path("/")
	@Get
	public void index() {
		
	}
	
	/**
	 * Trata e retorna o assunto
	 * 
	 */
	@Path("/")
	@Post
	public void assunto(String assunto) {
		
		String url = Tratador.geraUrlParamAmigavel(assunto);
				
		JSONObject retorno = new JSONObject();
		retorno.put("retorno", "ok");
		retorno.put("url", url);
		
		result.use(Results.http()).body(retorno.toString());
	}
	
	@Path("/{assunto}")
	@Get
	public void novo(String assunto) {	
		result.include("assunto", assunto);
	}
	
	@Path("/novo")
	@Post	
	public void adiciona(Comentario comentario) {
		dao.adiciona(comentario);
		
		JSONObject retorno = new JSONObject();
		retorno.put("retorno", "ok");
		
		result.use(Results.http()).body(retorno.toString());
	}
	
	@Path("/lista/{assunto}")
	@Get
	public void listaPorAssunto(String assunto) {
		
	}

}
