package com.example.trabalho.itemDoPedido;

public record ItemDoPedidoRequestDTO(ItemDoPedidoId itemDoPedidoId, Integer qtdade) {
	public ItemDoPedidoRequestDTO(ItemDoPedido itemDoPedido) {
		this(itemDoPedido.getItemDoPedidoId(), itemDoPedido.getQtdade());
	}
}