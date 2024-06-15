package com.example.ecommercepi.service;

import com.example.ecommercepi.model.ItemPedido;
import com.example.ecommercepi.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService{

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public ItemPedido create(ItemPedido itemPedido) {
        return this.itemPedidoRepository.save(itemPedido);
    }

}
