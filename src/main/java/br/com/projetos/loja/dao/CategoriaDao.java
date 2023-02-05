package br.com.projetos.loja.dao;

import javax.persistence.EntityManager;

import br.com.projetos.loja.modelo.Categoria;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}

	public void update(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remove(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);   
	}
}
