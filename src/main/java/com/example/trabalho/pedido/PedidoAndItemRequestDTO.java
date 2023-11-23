package com.example.trabalho.pedido;

import com.example.trabalho.itemDoPedido.ItemDoPedido;

public class PedidoAndItemRequestDTO {
    private String cpf;
    private ItemDoPedido[] itensDoPedido;
    private Long cod_pedido;

    public PedidoAndItemRequestDTO(String cpf, ItemDoPedido[] itensDoPedido, Long cod_pedido) {
        this.cpf = cpf;
        this.itensDoPedido = itensDoPedido;
        this.cod_pedido = cod_pedido;
    }

    public PedidoAndItemRequestDTO(Pedido pedido, ItemDoPedido itemDoPedido) {
        this(pedido.getCpf(), pedido.getItensDoPedido(), itemDoPedido.getItemDoPedidoId().getCod_pedido());
    }

    // Getter methods (you can generate them using your IDE or write them manually)
    public String getCpf() {
        return cpf;
    }

    public ItemDoPedido[] getItensDoPedido() {
        return itensDoPedido;
    }

    public Long getCod_pedido() {
        return cod_pedido;
    }
}
