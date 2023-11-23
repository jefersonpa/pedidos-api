package com.example.trabalho.pedido;

import java.util.Date;

import com.example.trabalho.cliente.Cliente;

public class PedidoRequestDTO {
    private Cliente cliente;
    private Date data;

    public PedidoRequestDTO(Cliente cliente, Date data) {
        this.cliente = cliente;
        this.data = data;
    }

    public PedidoRequestDTO(Pedido pedido) {
        this(pedido.getCliente(), pedido.getData());
    }

    // Getter methods (you can generate them using your IDE or write them manually)
    public Cliente getCliente() {
        return cliente;
    }

    public Date getData() {
        return data;
    }
}
