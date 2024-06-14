package com.example.ecommercepi.service;

import com.example.ecommercepi.model.ItemPedido;
import com.example.ecommercepi.repository.ItemPedidoRepository;

public class ItemPedidoService{

    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public ItemPedido create(ItemPedido itemPedido) {
        return this.itemPedidoRepository.save(itemPedido);
    }

}
