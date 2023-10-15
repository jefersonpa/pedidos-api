package com.example.trabalho.pedido;


import java.util.Date;

import com.example.trabalho.cliente.Cliente;

public record PedidoRequestDTO(Cliente cliente, Date data) {
	public PedidoRequestDTO(Pedido pedido) {
		this(pedido.getCliente(), pedido.getData());
	}
}