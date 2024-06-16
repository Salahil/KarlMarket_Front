package com.example.ecommercepi.controller;

import com.example.ecommercepi.model.Produto;
import com.example.ecommercepi.service.ProdutoService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//@Tag(name = "Produto", description = "Controle de criação e manutenção de produto")
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.save(produto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoProduto.getIdProduto())
                .toUri();
        return ResponseEntity.created(location).body(novoProduto);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
//        Produto updatedProduto = produtoService.updateProduto(id, produtoDetails);
//        return ResponseEntity.ok(updatedProduto);
//    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteProduto(@PathVariable Long id) {
//        produtoService.deleteProduto(id);
//    }
}
