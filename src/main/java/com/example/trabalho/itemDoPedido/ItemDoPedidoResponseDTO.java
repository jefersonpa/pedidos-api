package com.example.trabalho.itemDoPedido;

public class ItemDoPedidoResponseDTO {
    private ItemDoPedidoId itemDoPedidoId;
    private Integer qtdade;
    private String descricao;

    public ItemDoPedidoResponseDTO(ItemDoPedidoId itemDoPedidoId, Integer qtdade, String descricao) {
        this.itemDoPedidoId = itemDoPedidoId;
        this.qtdade = qtdade;
        this.descricao = descricao;
    }

    public ItemDoPedidoResponseDTO(ItemDoPedido itemDoPedido) {
        this(itemDoPedido.getItemDoPedidoId(), itemDoPedido.getQtdade(), itemDoPedido.getDescricao());
    }

    // Getter methods (you can generate them using your IDE or write them manually)
    public ItemDoPedidoId getItemDoPedidoId() {
        return itemDoPedidoId;
    }

    public Integer getQtdade() {
        return qtdade;
    }

    public String getDescricao() {
        return descricao;
    }
}
