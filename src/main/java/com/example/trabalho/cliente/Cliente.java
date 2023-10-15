package com.example.trabalho.cliente;

import jakarta.persistence.*;

@Table(name = "cliente")
@Entity(name = "cliente")
public class Cliente {
	public Cliente(){
	   super();
	}
	public Cliente(ClienteRequestDTO data) {
		super();
		this.nome = data.nome();
		this.cpf = data.cpf();
		this.sobrenome = data.sobrenome();
	}
	public Cliente(Long cod_cliente, String nome, String cpf, String sobrenome) {
		super();
		this.cod_cliente = cod_cliente;
		this.nome = nome;
		this.cpf = cpf;
		this.sobrenome = sobrenome;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cliente")
	private Long cod_cliente;
	@Column(name = "nome_cliente")
	private String nome;
	@Column(name = "cpf_cliente")
	private String cpf;
	@Column(name = "sobrenome_cliente")
	private String sobrenome;

	public Long getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(Long cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
