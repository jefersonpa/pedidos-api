package com.example.trabalho.pedido;

import java.util.Date;

public class PedidoResponseDTO {
    private Long id;
    private Date data;

    public PedidoResponseDTO(Long id, Date data) {
        this.id = id;
        this.data = data;
    }

    public PedidoResponseDTO(Pedido pedido) {
        this(pedido.getId(), pedido.getData());
    }

    // Getter methods (you can generate them using your IDE or write them manually)
    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

}
