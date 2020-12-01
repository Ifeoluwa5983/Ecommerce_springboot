package com.ecommerce.ecommercestore.service.order;

import com.ecommerce.ecommercestore.data.exception.OrderException;
import com.ecommerce.ecommercestore.data.model.Order;

import java.util.List;

public interface OrderModelService {
    public Order findByOrderId(Integer id);

    public List<Order> findAllOrders();

    public void deleteOrderById(Integer id);

    public Order updateOrder(Order order) throws OrderException;

    public Order createOrder(Order order) throws OrderException;
}
