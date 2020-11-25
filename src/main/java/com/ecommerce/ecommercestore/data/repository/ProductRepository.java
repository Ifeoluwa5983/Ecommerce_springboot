package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
