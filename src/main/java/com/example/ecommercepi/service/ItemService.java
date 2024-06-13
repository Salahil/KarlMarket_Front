package com.example.ecommercepi.service;

import com.example.ecommercepi.model.ItemCarrinho;
import com.example.ecommercepi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemCarrinho> findAll() {
        return this.itemRepository.findAll();
    }

    public ItemCarrinho findById(Long id) {
        return this.itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

    public ItemCarrinho save(ItemCarrinho item){
        return this.itemRepository.save(item);
    }

    public void delete(Long id){
        this.itemRepository.deleteById(id);
    }
}
