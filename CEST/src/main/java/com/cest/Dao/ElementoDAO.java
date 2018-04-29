package com.cest.Dao;

import java.util.List;

import com.cest.Models.Elemento;

public interface ElementoDAO {
	
	public List<Elemento> getElementos();
	public void guardarElemento(Elemento e);

}
