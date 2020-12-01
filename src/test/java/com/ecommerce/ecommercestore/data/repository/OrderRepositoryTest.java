package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.exception.OrderException;
import com.ecommerce.ecommercestore.data.model.Order;
import com.ecommerce.ecommercestore.data.model.Product;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Sql(scripts = {"classpath:db/insert-db.sql"})
@Slf4j
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
            StoreCustomerRepository storeCustomerRepository;

    Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testThatACustomerCanPlaceAnOrder(){
        StoreCustomer customer = storeCustomerRepository.findById(1).orElse(null);
        assertThat(customer).isNotNull();

        List<Product> products = productRepository.findAll();
        order.setDate("12-3-2018");
        order.setDelivered(false);
        order.setCancelled(false);
        order.setStoreCustomer(customer);
        order.setProducts(products);

        assertDoesNotThrow( ()-> {orderRepository.saveOrder(order);});

    }

    @Test
    void testSaveOrderWithoutCustomer(){
        List<Product> products = productRepository.findAll();

        order.setDate("12-3-2018");
        order.setDelivered(false);
        order.setCancelled(false);

        order.setProducts(products);
        assertThrows(OrderException.class, ()-> {
            orderRepository.saveOrder(order);
        });

        assertNull(order.getId());
    }

    @Test
    void testSaveOrderWithoutProduct(){
        StoreCustomer customer = storeCustomerRepository.findById(1).orElse(null);
        assertThat(customer).isNotNull();

        order.setDate("12-3-2018");
        order.setDelivered(false);
        order.setCancelled(false);
        order.setStoreCustomer(customer);

        assertThrows(OrderException.class, ()-> {
            orderRepository.saveOrder(order);
        });

        assertNull(order.getId());
    }

    @Test
    void testSaveOrderWithoutOrder(){
        Order fakeOrder = new Order();

        assertThrows(OrderException.class, ()-> {
            orderRepository.saveOrder(fakeOrder);
        });

        assertNull(order.getId());

    }
}