package com.example.ecommercepi.model;
import jakarta.persistence.*;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdItemPedido;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduto")
    private Produto produto;

    @Column(nullable = false)
    private int quantidade;

    public ItemPedido(Long idItemPedido, Pedido pedido, Produto produto, int quantidade) {
        IdItemPedido = idItemPedido;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemPedido() {

    }


    public Long getIdItemPedido() {
        return IdItemPedido;
    }

    public void setIdItemPedido(Long idItemPedido) {
        IdItemPedido = idItemPedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Double getPrecoTotal(){
        return getProduto().getValor()*getQuantidade();
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
