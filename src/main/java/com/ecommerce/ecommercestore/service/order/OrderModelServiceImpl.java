package com.ecommerce.ecommercestore.service.order;

import com.ecommerce.ecommercestore.data.exception.OrderException;
import com.ecommerce.ecommercestore.data.model.Order;
import com.ecommerce.ecommercestore.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderModelServiceImpl implements OrderModelService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order findByOrderId(Integer id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrderById(Integer id){
        orderRepository.deleteById(id);
    }

    @Override
    public Order updateOrder(Order order) throws OrderException {
        if(order == null){
            throw new NullPointerException("Customer object cannot be null");
        }
        return orderRepository.saveOrder(order);
    }

    @Override
    public Order createOrder(Order order) throws OrderException {
        if(order == null){
            throw new NullPointerException("Customer object cannot be null");
        }
        return orderRepository.saveOrder(order);
    }

}
