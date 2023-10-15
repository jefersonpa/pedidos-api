package com.example.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalho.itemDoPedido.ItemDoPedido;
import com.example.trabalho.itemDoPedido.ItemDoPedidoRepository;
import com.example.trabalho.itemDoPedido.ItemDoPedidoRequestDTO;
import com.example.trabalho.itemDoPedido.ItemDoPedidoResponseDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ItemDoPedidoController {
	@Autowired
    private ItemDoPedidoRepository repository;
	@GetMapping("/item-do-pedido/{cod_pedido}")
	public List<ItemDoPedidoResponseDTO> getByCodPedido(@PathVariable("cod_pedido") Long cod_pedido) {
		List<ItemDoPedidoResponseDTO> itemDoPedidoList = repository.getByCodPedido(cod_pedido).stream().map(ItemDoPedidoResponseDTO::new).toList();
		System.out.print(repository.getByCodPedido(cod_pedido));
		return itemDoPedidoList;
	}
}
