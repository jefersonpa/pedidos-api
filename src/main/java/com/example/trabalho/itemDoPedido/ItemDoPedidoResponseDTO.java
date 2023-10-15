package com.example.trabalho.itemDoPedido;

public record ItemDoPedidoResponseDTO(ItemDoPedidoId itemDoPedidoId, Integer qtdade, String descricao) {
	public ItemDoPedidoResponseDTO(ItemDoPedido itemDoPedido) {
		this(itemDoPedido.getItemDoPedidoId(), itemDoPedido.getQtdade(), itemDoPedido.getDescricao());
	}
}