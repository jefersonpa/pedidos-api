package com.example.trabalho.pedido;

import java.util.Date;


public record PedidoResponseDTO(Long id, Date data) {
	public PedidoResponseDTO(Pedido pedido) {
		this(pedido.getId(), pedido.getData());
	}
}