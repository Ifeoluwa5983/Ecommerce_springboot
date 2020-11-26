package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
