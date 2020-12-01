package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.exception.OrderException;
import com.ecommerce.ecommercestore.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    public default Order saveOrder(Order ordermodel) throws OrderException {
        Order savedOrder = null;
        if (isOrderValid(ordermodel)) {
           savedOrder = save(ordermodel);
        }
        return ordermodel;
    }

    private boolean isOrderValid(Order ordermodel) throws OrderException {
        if (!isOrderHasCustomer(ordermodel) && !isOrderHasProducts(ordermodel)){
            throw new OrderException("This operation is impossible,an order must have products and a customer");
        }
        if(!isOrderHasProducts(ordermodel)){
            throw new OrderException("Order must have products");
        }
        if(!isOrderHasCustomer(ordermodel)){
            throw new OrderException("Customer cannot be null");
        }
        return true;
    }

    private boolean isOrderHasCustomer(Order order){
        if(order.getStoreCustomer() == null){
            return false;
        }
        return true;
    }

    private boolean isOrderHasProducts(Order order){
        if(order.getProducts() == null){
            return false;
        }
        return true;
    }
}
