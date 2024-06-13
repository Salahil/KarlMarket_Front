package com.example.ecommercepi.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SENAI_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(name = "DESC_NOME")
    private String nome;

    @Column(name = "INFO_PRODUTO")
    private String info;

    @Column(name = "QTD_PRODUTO")
    private Integer quantidade;

    @Column(name = "valor")
    private Double valor;

    public Produto(Long id, String nome, String info, Integer quantidade, Double valor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.info = info;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Long getId() {
        return idProduto;
    }

    public void setId(Long id) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

