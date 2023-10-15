package com.example.trabalho.cliente;

public record ClienteResponseDTO(Long cod_cliente, String nome, String cpf, String sobrenome) {
	public ClienteResponseDTO(Cliente cliente) {
		this(cliente.getCod_cliente(), cliente.getNome(), cliente.getCpf(), cliente.getSobrenome());
	}
}