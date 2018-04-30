package com.cest.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cest.Models.Elemento;

@Repository(value = "elementoDao")
public class JPAElemento implements ElementoDAO {
	public EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Elemento> getElementos(){
		return em.createQuery("select * from elemento").getResultList();
	}
	
	@Transactional(readOnly=false)
	public void guardarElemento(Elemento e) {
		em.merge(e);
	}
}
