package com.eduardojanuario.comente.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String assunto;

	private String email;

	private String comentario;

	public Integer getId() {
		return id;
	}

	public Comentario setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getAssunto() {
		return assunto;
	}

	public Comentario setAssunto(String assunto) {
		this.assunto = assunto;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Comentario setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getComentario() {
		return comentario;
	}

	public Comentario setComentario(String comentario) {
		this.comentario = comentario;
		return this;
	}
}
