package com.example.ecommercepi.service;


import com.example.ecommercepi.model.Produto;
import com.example.ecommercepi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return this.repository.findAll();
    }

    public Produto findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto save(Produto item){
        return this.repository.save(item);
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }
}
