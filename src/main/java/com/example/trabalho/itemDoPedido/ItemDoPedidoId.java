package com.example.trabalho.itemDoPedido;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Embeddable
public class ItemDoPedidoId implements Serializable {
    private Long cod_pedido;
    private Long cod_produto;
 
    public ItemDoPedidoId() {
    }
 
    public ItemDoPedidoId(Long cod_pedido, Long cod_produto) {
        this.cod_pedido = cod_pedido;
        this.cod_produto = cod_produto;
    }

	public Long getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(Long cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public Long getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Long cod_produto) {
		this.cod_produto = cod_produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_produto, cod_pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDoPedidoId other = (ItemDoPedidoId) obj;
		return Objects.equals(cod_produto, other.cod_produto) && Objects.equals(cod_pedido, other.cod_pedido);
	}     
}