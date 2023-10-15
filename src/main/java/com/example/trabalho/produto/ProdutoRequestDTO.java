package com.example.trabalho.produto;

public record ProdutoRequestDTO(String descricao) {
	public ProdutoRequestDTO(Produto produto) {
		this(produto.getDescricao());
	}
}