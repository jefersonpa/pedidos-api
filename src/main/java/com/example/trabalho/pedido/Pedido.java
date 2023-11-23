package com.example.trabalho.pedido;

import java.util.Date;

import com.example.trabalho.cliente.Cliente;
import com.example.trabalho.itemDoPedido.ItemDoPedido;

import javax.persistence.*;

@Table(name = "pedido")
@Entity(name = "pedido")
public class Pedido {
	public ItemDoPedido[] getItensDoPedido() {
		return itensDoPedido;
	}
	public void setItensDoPedido(ItemDoPedido[] itensDoPedido) {
		this.itensDoPedido = itensDoPedido;
	}
	public Pedido(){
	   super();
	}
	public Pedido(PedidoRequestDTO data) {
		super();
		this.data = data.getData();
		this.cliente = data.getCliente();
	}
	public Pedido(Long id, Date data) {
		super();
		this.id = id;
		this.data = data;
	}
	public Pedido(Long id, Cliente cliente, Date data) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.data = data;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_pedido")
	private Long id;
	
	@JoinColumn(name = "cod_cliente")
    @ManyToOne
	private Cliente cliente;

	@Transient
	private String cpf;

	@Transient
	private ItemDoPedido[] itensDoPedido;
	
	@Column(name = "data")
	private Date data;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
