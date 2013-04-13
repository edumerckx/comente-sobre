package com.eduardojanuario.comente.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.eduardojanuario.comente.model.Comentario;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ComentarioDao {

	private EntityManager em;
	
	public ComentarioDao(EntityManager em) {
		this.em = em;
	}
	
	public void adiciona(Comentario comentario) {
		em.persist(comentario);
	}
	
	/**
	 * Lista todos os comentários da base 
	 * 
	 * @return
	 */
	public List<Comentario> listaTodos() {
		Query query = em.createQuery("from Comentario");
		return query.getResultList();
	}
	
	/**
	 * Lista todos os comentários da base para o 
	 * assunto informado
	 * 
	 * @param assunto
	 * @return
	 */
	public List<Comentario> listaPorAssunto(String assunto) {
		Query query = em.createQuery("from Comentario c where c.assunto =:assunto");
		query.setParameter("assunto", "assunto");		
		return query.getResultList();
	}
	
}
