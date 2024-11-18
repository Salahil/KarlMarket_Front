package com.example.ecommercepi.service;

import com.example.ecommercepi.model.Pedido;
import com.example.ecommercepi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


    public Iterable<Pedido> getAllOrders() {
        return this.pedidoRepository.findAll();
    }

    
    public Pedido create(Pedido p) {
        p.setDataPedido(LocalDate.now());

        return this.pedidoRepository.save(p);
    }


    public void update(Pedido p) {
        this.pedidoRepository.save(p);
    }
}
