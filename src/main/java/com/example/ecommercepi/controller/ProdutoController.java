package com.example.ecommercepi.controller;

import com.example.ecommercepi.model.Produto;
import com.example.ecommercepi.service.ProdutoService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Tag(name = "Produto", description = "Controle de criação e manutenção de produto")
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping("/products")
    public List<Produto> findAll(){
        return this.produtoService.findAll();
    }

    @GetMapping("/products/{id}")
    public Produto findById(@PathVariable("id") Long id){
        return this.produtoService.findById(id);
    }


    @PostMapping("/products")
    public Produto save(@RequestBody Produto produto){
        return this.produtoService.save(produto);
    }

    @PutMapping("/products/{id}")
    public Produto update(@RequestBody Produto produto){
        return this.produtoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.produtoService.delete(id);
    }
}
