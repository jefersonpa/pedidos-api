package com.example.trabalho.itemDoPedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
@Component 
public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, ItemDoPedidoId> {
    public List<ItemDoPedido> findAll();
    //public ItemDoPedido getById(Long id);

    @Query(value = "SELECT p.cod_produto, p.descricao, i.cod_pedido, i.qtdade "
    		+ "FROM public.item_do_pedido i "
    		+ "INNER JOIN public.produto p ON i.cod_produto = p.cod_produto "
    		+ "WHERE i.cod_pedido = :cod_pedido", nativeQuery = true)
    public List<ItemDoPedido> getByCodPedido(@Param("cod_pedido") Long cod_pedido);
    
    @Modifying
    @Query(value = "INSERT INTO item_do_pedido("
    		+ "	cod_pedido, cod_produto, qtdade)"
    		+ "	VALUES (:codPedido, :codProduto, :qtdade)", nativeQuery = true)
    @Transactional
    public void saveItem(@Param("codPedido") Long codPedido, @Param("codProduto") Long codProduto, @Param("qtdade") Integer qtdade);
}
