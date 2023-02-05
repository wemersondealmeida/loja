package br.com.projetos.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.projetos.loja.dao.CategoriaDao;
import br.com.projetos.loja.dao.ProdutoDao;
import br.com.projetos.loja.modelo.Categoria;
import br.com.projetos.loja.modelo.Produto;
import br.com.projetos.loja.util.JPAUtil;

public class CadastroDeProdutos {
	public static void main(String[] args) {
		cadastrarProduto();
	
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1L);
		
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		 
		todos.forEach(q -> System.out.println(p.getNome()));
		
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Iphone 11");
		System.out.println("preço do produto " + precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Iphone 11", "massa", new BigDecimal(800), celulares);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}
