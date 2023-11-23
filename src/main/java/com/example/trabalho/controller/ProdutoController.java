package com.example.trabalho.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalho.produto.Produto;
import com.example.trabalho.produto.ProdutoRepository;
import com.example.trabalho.produto.ProdutoRequestDTO;
import com.example.trabalho.produto.ProdutoResponseDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProdutoController {
	@Autowired
    private ProdutoRepository repository;

	@GetMapping(value = "/produtos")
	public List<ProdutoResponseDTO> getAll() {
		List<ProdutoResponseDTO> produtoList = repository.findAll().stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
		return produtoList;
	}
	
	@GetMapping("/produtos/{id}")
	public ProdutoResponseDTO getById(@PathVariable("id") Long id) {
		ProdutoResponseDTO produtoList = new ProdutoResponseDTO(repository.getById(id));
		return produtoList;
	}
	
	@PostMapping(value = "/produtos")
	public ProdutoResponseDTO save(@RequestBody ProdutoRequestDTO data) {
		Produto produtoData = new Produto(data);
		Produto response = repository.save(produtoData);
		return new ProdutoResponseDTO(response);
	}
	

	@PutMapping("/produtos/{id}")
	public ProdutoResponseDTO edit(@PathVariable("id") Long id, @RequestBody ProdutoRequestDTO produto) {
		Produto produtoData = repository.getById(id);
		if (produtoData != null) {
			produtoData.setDescricao(produto.getDescricao());
		}
		
		Produto response = repository.save(produtoData);
		return new ProdutoResponseDTO(response);
	}

	@DeleteMapping("/produtos/{id}")
	public void remove(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}
