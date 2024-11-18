package com.example.ecommercepi.controller;

import com.example.ecommercepi.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import com.example.ecommercepi.model.ItemPedido;
import com.example.ecommercepi.model.Pedido;
import com.example.ecommercepi.service.ItemPedidoService;
import com.example.ecommercepi.service.PedidoService;
import com.example.ecommercepi.service.ProdutoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
        ProdutoService produtoService;
        PedidoService pedidoService;
        ItemPedidoService itemPedidoService;

        public PedidoController(ProdutoService produtoService, PedidoService pedidoService, ItemPedidoService itemPedidoService) {
            this.produtoService = produtoService;
            this.pedidoService = pedidoService;
            this.itemPedidoService = itemPedidoService;
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public @NotNull Iterable<Pedido> list() {

            return this.pedidoService.getAllOrders();
        }

        @PostMapping
        public ResponseEntity<Pedido> create(@RequestBody PedidoForm form) {
            List<ItemPedido> ListaItens = form.getItemPedidos();
            validateProductsExistence(ListaItens);
            Pedido pedido = new Pedido();
            pedido.setStatus("pago");
            pedido = this.pedidoService.create(pedido);

            List<ItemPedido> itemPedidos = new ArrayList<>();
            for (ItemPedido i : ListaItens) {
                itemPedidos.add(itemPedidoService.create(new ItemPedido(pedido, produtoService.findById(i
                        .getProduto()
                        .getId()), i.getQuantidade())));
            }

            pedido.setItens(itemPedidos);

            this.pedidoService.update(pedido);

            String uri = ServletUriComponentsBuilder
                    .fromCurrentServletMapping()
                    .path("/pedidos/{id}")
                    .buildAndExpand(pedido.getIdPedido())
                    .toString();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", uri);

            return new ResponseEntity<>(pedido, headers, HttpStatus.CREATED);
        }

        private void validateProductsExistence(List<ItemPedido> itemPedidos) {
            List<ItemPedido> list = itemPedidos
                    .stream()
                    .filter(op -> Objects.isNull(produtoService.findById(op
                            .getProduto()
                            .getId())))
                    .collect(Collectors.toList());

            if (!CollectionUtils.isEmpty(list)) {
                new ResourceNotFoundException("Product not found");
            }
        }

        public static class PedidoForm {

            private List<ItemPedido> itemPedidos;

            public List<ItemPedido> getItemPedidos() {
                return itemPedidos;
            }

            public void setItemPedidos(List<ItemPedido> productOrders) {
                this.itemPedidos = productOrders;
            }
        }
}
