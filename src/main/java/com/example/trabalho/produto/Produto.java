package com.example.trabalho.produto;

import javax.persistence.*;

@Table(name = "produto")
@Entity(name = "produto")
public class Produto {
	public Produto(){
	   super();
	}
	public Produto(ProdutoRequestDTO data) {
		super();
		this.descricao = data.getDescricao();
	}
	public Produto(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_produto")
	private Long id;
	@Column(name = "descricao")
	private String descricao;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
