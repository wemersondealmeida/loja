package br.com.projetos.loja.testes;

import java.math.BigDecimal;

import br.com.projetos.loja.modelo.Produto;

public class CadastroDeProdutos {
	public static void main(String[] args) {
		Produto celular = new Produto();
		
		celular.setNome("Iphone 11");
		celular.setDescricao("massa");
		celular.setPreco(new BigDecimal(800));
		
		
				
				
	}
}
