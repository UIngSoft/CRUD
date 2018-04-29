package com.cest.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.cest.Models.Elemento;

@Repository(value = "elementoDao")
public class JPAElemento implements ElementoDAO {
	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional()
	@SuppressWarnings("unchecked")
	public List<Elemento> getElementos(){
		return em.createQuery("select * from elemento").getResultList();
	}
	
	@Transactional()
	public void guardarElemento(Elemento e) {
		em.merge(e);
	}
}
