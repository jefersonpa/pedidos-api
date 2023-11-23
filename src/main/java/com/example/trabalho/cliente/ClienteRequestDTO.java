package com.example.trabalho.cliente;

public class ClienteRequestDTO {
    private String nome;
    private String cpf;
    private String sobrenome;

    public ClienteRequestDTO(String nome, String cpf, String sobrenome) {
        this.nome = nome;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
    }

    public ClienteRequestDTO(Cliente cliente) {
        this(cliente.getNome(), cliente.getCpf(), cliente.getSobrenome());
    }

    // Getter methods (you can generate them using your IDE or write them manually)
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
