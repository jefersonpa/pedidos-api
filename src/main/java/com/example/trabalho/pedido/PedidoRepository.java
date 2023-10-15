package com.example.trabalho.pedido;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component 
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    public List<Pedido> findAll();
    public Pedido getById(Long id);

    @Query(value = "SELECT p.cod_pedido, p.data, p.cod_cliente \r\n"
    		+ "FROM pedido p\r\n"
    		+ "JOIN cliente c ON c.cod_cliente = p.cod_cliente\r\n"
    		+ "WHERE c.cpf_cliente = :cpf", nativeQuery = true)
    public List<Pedido> getByCPF(@Param("cpf") String cpf);
}
