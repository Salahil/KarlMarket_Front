package com.example.ecommercepi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "SENAI_CARRINHO")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrinho;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "nome")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy") private LocalDate dataCarrinhos;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ItemCarrinho> items;

    public Carrinho(Long idCarrinho, Usuario usuario, String nome, LocalDate dataCarrinhos, List<ItemCarrinho> items) {
        this.idCarrinho = idCarrinho;
        this.usuario = usuario;
        this.nome = nome;
        this.dataCarrinhos = dataCarrinhos;
        this.items = items;
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCarrinhos() {
        return dataCarrinhos;
    }

    public void setDataCarrinhos(LocalDate dataCarrinhos) {
        this.dataCarrinhos = dataCarrinhos;
    }

    public List<ItemCarrinho> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrinho> items) {
        this.items = items;
    }
}
