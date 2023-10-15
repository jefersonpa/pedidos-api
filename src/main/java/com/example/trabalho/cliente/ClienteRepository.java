package com.example.trabalho.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component 
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public List<Cliente> findAll();
    public Cliente getById(Long id);
    public Cliente findByCpf(String cpf);
}
