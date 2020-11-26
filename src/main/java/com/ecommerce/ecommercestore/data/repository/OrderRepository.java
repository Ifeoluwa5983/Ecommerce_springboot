package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel,Integer> {
}
