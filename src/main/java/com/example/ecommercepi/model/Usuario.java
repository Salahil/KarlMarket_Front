package com.example.ecommercepi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long idUsuario;
    private  String name;
    private String email;
    private String cpf;
    private String endereco;
    private String senha;
    public TipoUsuario tipo;

    private Usuario(String name, String email, String cpf, String endereco, String senha, TipoUsuario tipo) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario() {

    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
