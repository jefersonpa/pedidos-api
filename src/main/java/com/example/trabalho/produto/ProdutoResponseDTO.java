package com.example.trabalho.produto;

public class ProdutoResponseDTO {
    private Long id;
    private String descricao;

    public ProdutoResponseDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getDescricao());
    }

    // Getter methods (you can generate them using your IDE or write them manually)
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
