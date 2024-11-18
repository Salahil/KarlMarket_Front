package com.example.ecommercepi.service;

import com.example.ecommercepi.model.Carrinho;
import com.example.ecommercepi.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;


    public List<Carrinho> findAll() {
        return this.carrinhoRepository.findAll();
    }

    public Carrinho findById(Long id) {
        return this.carrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    @Transactional
    public Carrinho save(Carrinho carrinho) {
        return this.carrinhoRepository.save(carrinho);
    }

    @Transactional
    public void delete(Long id) {
        this.carrinhoRepository.deleteById(id);
    }
}
