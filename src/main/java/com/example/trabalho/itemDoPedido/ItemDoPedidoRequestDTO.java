package com.example.trabalho.itemDoPedido;

public class ItemDoPedidoRequestDTO {
    private ItemDoPedidoId itemDoPedidoId;
    private Integer qtdade;

    public ItemDoPedidoRequestDTO(ItemDoPedidoId itemDoPedidoId, Integer qtdade) {
        this.itemDoPedidoId = itemDoPedidoId;
        this.qtdade = qtdade;
    }

    public ItemDoPedidoRequestDTO(ItemDoPedido itemDoPedido) {
        this(itemDoPedido.getItemDoPedidoId(), itemDoPedido.getQtdade());
    }

    // Getter methods (you can generate them using your IDE or write them manually)
    public ItemDoPedidoId getItemDoPedidoId() {
        return itemDoPedidoId;
    }

    public Integer getQtdade() {
        return qtdade;
    }
}
