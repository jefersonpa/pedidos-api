package com.example.trabalho.produto;

public class ProdutoRequestDTO {
    private String descricao;

    public ProdutoRequestDTO(String descricao) {
        this.descricao = descricao;
    }

    public ProdutoRequestDTO(Produto produto) {
        this(produto.getDescricao());
    }

    // Getter method (you can generate it using your IDE or write it manually)
    public String getDescricao() {
        return descricao;
    }
}
