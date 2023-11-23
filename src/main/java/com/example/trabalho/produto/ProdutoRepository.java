package com.example.trabalho.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component 
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findAll();
    public Produto getById(Long id);
}
