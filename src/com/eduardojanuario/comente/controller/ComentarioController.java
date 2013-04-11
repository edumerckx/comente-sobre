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

import java.net.URI;
import java.net.URISyntaxException;
import java.text.Normalizer;
import java.text.Normalizer.Form;

import org.json.simple.JSONObject;

import com.eduardojanuario.comente.utils.Tratador;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ComentarioController {

	private final Result result;

	public ComentarioController(Result result) {
		this.result = result;
	}

	@Path("/")
	@Get
	public void index() {
		
	}
	
	/**
	 * 
	 */
	@Path("/")
	@Post
	public void novo(String assunto) {
		
		String url = Tratador.geraUrlParamAmigavel(assunto);
		
		System.out.println(url);
				
		JSONObject retorno = new JSONObject();
		retorno.put("retorno", "ok");
		retorno.put("url", url);
		
		result.use(Results.http()).body(retorno.toString());
	}

}
