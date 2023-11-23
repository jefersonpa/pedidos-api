package com.example.trabalho.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.example.trabalho.cliente.ClienteRequestDTO;
import com.example.trabalho.cliente.ClienteResponseDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ClienteController {
	@Autowired
    private ClienteRepository repository;

	@GetMapping(value = "/clientes")
	public List<ClienteResponseDTO> getAll() {
		List<ClienteResponseDTO> clienteList = repository.findAll().stream().map(ClienteResponseDTO::new).collect(Collectors.toList());
		return clienteList;
	}
	
	@GetMapping("/clientes/{id}")
	public ClienteResponseDTO getById(@PathVariable("id") Long id) {
		ClienteResponseDTO clienteList = new ClienteResponseDTO(repository.getById(id));
		return clienteList;
	}
	
	@PostMapping(value = "/clientes")
	public ResponseEntity<?> save(@RequestBody ClienteRequestDTO data) {
		Cliente clienteData = new Cliente(data);
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			Cliente response = repository.save(clienteData);
    		map.put("data", response);
    		map.put("status", 1);
    		map.put("message", "Cliente criado com sucesso!");
    		return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (Exception e) {
    		map.put("error", e.getCause());
    		map.put("status", 1);
    		map.put("message", e.getMessage());
    		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody ClienteRequestDTO cliente) {
		Cliente clienteData = repository.getById(id);
		if (clienteData != null) {
			clienteData.setNome(cliente.getNome());
			clienteData.setSobrenome(cliente.getSobrenome());
			clienteData.setCpf(cliente.getCpf());
		}
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			Cliente response = repository.save(clienteData);
    		map.put("data", response);
    		map.put("status", 1);
    		map.put("message", "Cliente editado com sucesso!");
    		return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (Exception e) {
    		map.put("error", e.getCause());
    		map.put("status", 1);
    		map.put("message", e.getMessage());
    		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Long id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			repository.deleteById(id);
    		map.put("status", 1);
    		map.put("message", "Cliente deletado com sucesso!");
    		return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (Exception e) {
    		map.put("error", e.getCause());
    		map.put("status", 1);
    		map.put("message", e.getMessage());
    		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
