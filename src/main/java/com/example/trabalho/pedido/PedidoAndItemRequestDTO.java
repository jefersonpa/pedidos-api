package com.example.trabalho.pedido;


import java.util.Date;

import com.example.trabalho.itemDoPedido.ItemDoPedido;

public record PedidoAndItemRequestDTO(String cpf, ItemDoPedido[] itensDoPedido, Long cod_pedido) {
	public PedidoAndItemRequestDTO(Pedido pedido, ItemDoPedido itemDoPedido) {
		this(pedido.getCpf(), pedido.getItensDoPedido(), itemDoPedido.getItemDoPedidoId().getCod_pedido());
	}
}