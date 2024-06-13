package com.example.ecommercepi.controller;

import com.example.ecommercepi.model.Carrinho;
import com.example.ecommercepi.service.CarrinhoService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Tag(name = "Carrinho", description = "Carrinho de compras")
@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping("/products")
    public List<Carrinho> findAll(){
        return this.carrinhoService.findAll();
    }

    @GetMapping("/products/{id}")
    public Carrinho findById(Long id){
        return this.carrinhoService.findById(id);
    }

    @PostMapping("/products")
    public Carrinho save(Carrinho carrinho){
        return this.carrinhoService.save(carrinho);
    }

    @PutMapping("/products/{id}")
    public Carrinho update(Carrinho carrinho){
        return this.carrinhoService.save(carrinho);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        this.carrinhoService.delete(id);
    }
}
