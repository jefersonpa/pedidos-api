package com.example.trabalho.cliente;

public record ClienteRequestDTO(String nome, String cpf, String sobrenome) {
	public ClienteRequestDTO(Cliente cliente) {
		this(cliente.getNome(), cliente.getCpf(), cliente.getSobrenome());
	}
}