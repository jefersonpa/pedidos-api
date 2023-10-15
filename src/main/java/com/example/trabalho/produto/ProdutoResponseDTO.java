package com.example.trabalho.produto;

public record ProdutoResponseDTO(Long id, String descricao) {
	public ProdutoResponseDTO(Produto produto) {
		this(produto.getId(), produto.getDescricao());
	}
}