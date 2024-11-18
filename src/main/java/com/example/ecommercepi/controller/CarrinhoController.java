package com.example.ecommercepi.controller;

import com.example.ecommercepi.model.Carrinho;
import com.example.ecommercepi.service.CarrinhoService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import java.util.List;

//@Tag(name = "Carrinho", description = "Carrinho de compras")
@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public List<Carrinho> getAllCarrinhos() {
        return carrinhoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> getCarrinhoById(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.findById(id);
        return ResponseEntity.ok(carrinho);
    }

    @PostMapping
    public ResponseEntity<Carrinho> createCarrinho(@RequestBody Carrinho carrinho) {
        Carrinho novoCarrinho = carrinhoService.save(carrinho);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoCarrinho.getIdCarrinho())
                .toUri();
        return ResponseEntity.created(location).body(novoCarrinho);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Carrinho> updateCarrinho(@PathVariable Long id, @RequestBody Carrinho carrinhoDetails) {
//        Carrinho updatedCarrinho = carrinhoService.updateCarrinho(id, carrinhoDetails);
//        return ResponseEntity.ok(updatedCarrinho);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteCarrinho(@PathVariable Long id) {
//        carrinhoService.deleteCarrinho(id);
//    }
}
