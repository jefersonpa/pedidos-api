package com.example.trabalho.itemDoPedido;

import javax.persistence.*;

@Table(name = "item_do_pedido")
@Entity(name = "item_do_pedido")
public class ItemDoPedido {
    @EmbeddedId
    private ItemDoPedidoId itemDoPedidoId;

	public ItemDoPedido(){
	   super();
	}
	public ItemDoPedido(ItemDoPedidoRequestDTO data) {
		super();
		this.itemDoPedidoId = data.getItemDoPedidoId();
		this.qtdade = data.getQtdade();
	}
	//public ItemDoPedido(ItemDoPedidoId itemDoPedidoId, Integer qtdade, String descricao) {
	//	super();
	//	this.itemDoPedidoId = itemDoPedidoId;
	//	this.qtdade = qtdade;
	//	this.descricao = descricao;
	//}
	public ItemDoPedido(ItemDoPedidoId itemDoPedidoId, Integer qtdade) {
		super();
		this.itemDoPedidoId = itemDoPedidoId;
		this.qtdade = qtdade;
	}

	@Column(name = "qtdade")
	private Integer qtdade;
	
	@Column(name="descricao", nullable=false, length=30,
	        updatable=false, insertable=false)
	private String descricao;

	@Transient
	private Long cod_produto;
	
	public Long getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(Long cod_produto) {
		this.cod_produto = cod_produto;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ItemDoPedidoId getItemDoPedidoId() {
		return itemDoPedidoId;
	}
	public void setItemDoPedidoId(ItemDoPedidoId itemDoPedidoId) {
		this.itemDoPedidoId = itemDoPedidoId;
	}
	public Integer getQtdade() {
		return qtdade;
	}
	public void setQtdade(Integer qtdade) {
		this.qtdade = qtdade;
	}
	public String getDescricao() {
		return descricao;
	}
}
