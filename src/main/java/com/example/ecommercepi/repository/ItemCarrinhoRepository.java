package com.example.ecommercepi.repository;

import com.example.ecommercepi.model.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemCarrinho, Long> {
}
