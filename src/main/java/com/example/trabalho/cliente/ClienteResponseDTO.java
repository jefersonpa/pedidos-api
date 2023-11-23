package com.example.trabalho.cliente;

public class ClienteResponseDTO {
    private Long cod_cliente;
    private String nome;
    private String cpf;
    private String sobrenome;

    public ClienteResponseDTO(Long cod_cliente, String nome, String cpf, String sobrenome) {
        this.cod_cliente = cod_cliente;
        this.nome = nome;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
    }

    public ClienteResponseDTO(Cliente cliente) {
        this(cliente.getCod_cliente(), cliente.getNome(), cliente.getCpf(), cliente.getSobrenome());
    }

    // Getter methods (you can generate them using your IDE or write them manually)
    public Long getCod_cliente() {
        return cod_cliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSobrenome() {
        return sobrenome;
    }
}