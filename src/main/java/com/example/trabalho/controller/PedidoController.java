package com.example.trabalho.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalho.cliente.Cliente;
import com.example.trabalho.cliente.ClienteRepository;
import com.example.trabalho.itemDoPedido.ItemDoPedido;
import com.example.trabalho.itemDoPedido.ItemDoPedidoId;
import com.example.trabalho.itemDoPedido.ItemDoPedidoRepository;
import com.example.trabalho.pedido.Pedido;
import com.example.trabalho.pedido.PedidoAndItemRequestDTO;
import com.example.trabalho.pedido.PedidoRepository;
import com.example.trabalho.pedido.PedidoRequestDTO;
import com.example.trabalho.pedido.PedidoResponseDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PedidoController {
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Autowired
	private ItemDoPedidoRepository itemDoPedidoRepository;
	
	@GetMapping(value = "/pedidos")
	public List<PedidoResponseDTO> getAll() {
		List<PedidoResponseDTO> pedidoList = repository.findAll().stream().map(PedidoResponseDTO::new).toList();
		return pedidoList;
	}

	@GetMapping("/pedidos/{id}")
	public PedidoResponseDTO getById(@PathVariable("id") Long id) {
		PedidoResponseDTO pedido = new PedidoResponseDTO(repository.getById(id));
		return pedido;
	}

	@GetMapping("/pedidos/cpf/{cpf}")
	public List<PedidoResponseDTO> getByCPF(@PathVariable("cpf") String cpf) {
		List<PedidoResponseDTO> pedidoList = repository.getByCPF(cpf).stream().map(PedidoResponseDTO::new).toList();
		return pedidoList;
	}

	@PostMapping(value = "/pedidos")
	public PedidoResponseDTO save(@RequestBody PedidoRequestDTO data) {
		Pedido pedidoData = new Pedido(data);
		Pedido response = repository.save(pedidoData);
		return new PedidoResponseDTO(response);
	}

	@PutMapping("/pedidos/{id}")
	public PedidoResponseDTO edit(@PathVariable("id") Long id, @RequestBody PedidoRequestDTO pedido) {
		Pedido pedidoData = repository.getById(id);
		if (pedidoData != null) {
			pedidoData.setData(pedido.data());
		}

		Pedido response = repository.save(pedidoData);
		return new PedidoResponseDTO(response);
	}

	@DeleteMapping("/pedidos/{id}")
	public void remove(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}

    @PostMapping("/pedidos/create")
    public ResponseEntity<?> createPedidoAndItem(@RequestBody PedidoAndItemRequestDTO request) {
        try {
            Cliente cliente = clienteRepository.findByCpf(request.cpf());

            if (cliente == null) {
                System.out.println("Cliente " + request.cpf() + " não encontrado: ");
                return ResponseEntity.badRequest().body("Cliente " + request.cpf() + " não encontrado!");
            }
        	
            Pedido pedido = new Pedido();
            Date currentDate = new Date();
            pedido.setData(currentDate);
            pedido.setCliente(cliente);
            Pedido response = repository.save(pedido);
                 
            ItemDoPedido[] itens = request.itensDoPedido();
			try {
	            for (int i = 0; i < itens.length; i++) {
				    itemDoPedidoRepository.saveItem(response.getId(), itens[i].getCod_produto(), itens[i].getQtdade());
				}
			} catch (Exception e) {
	            System.out.println("Erro ao criar o item do pedido!");
	            return ResponseEntity.badRequest().body("Erro ao criar o item do pedido: " + e.getMessage());
			}

            System.out.println("Produto adicionado com sucesso!");
    		Map<String, Object> map = new LinkedHashMap<String, Object>();
    		map.put("status", 1);
    		map.put("message", "Record is Saved Successfully!");
    		return new ResponseEntity<>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating pedido: " + e.getMessage());
        }
    }
}
