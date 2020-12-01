package com.ecommerce.ecommercestore.service.order;

import com.ecommerce.ecommercestore.data.exception.OrderException;
import com.ecommerce.ecommercestore.data.model.Order;
import com.ecommerce.ecommercestore.data.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class OrderServiceImplTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderModelService orderModelService = new OrderModelServiceImpl();

    Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        order = new Order();
    }
    @Test
    void testThatWeCanCallTheCreateMethodInOrderModelService() throws OrderException {
        when(orderRepository.saveOrder(order)).thenReturn(order);
        orderModelService.createOrder(order);
        verify(orderRepository, times(1)).saveOrder(order);
    }

    @Test
    void testThatWeCanCallTheFindByIdMethodInOrderModelService(){
        when(orderRepository.findById(1)).thenReturn(Optional.of(order));
        orderModelService.findByOrderId(1);
        verify(orderRepository, times(1)).findById(1);
    }

    @Test
    void testThatWeCanCallTheUpdateMethodInOrderModelService() throws OrderException {
        when(orderRepository.saveOrder(order)).thenReturn(order);
        order.setDate("12-6-2011");
        orderModelService.createOrder(order);
        verify(orderRepository, times(1)).saveOrder(order);
    }

    @Test
    void testThatWeCanCallAllOrders(){
        when(orderRepository.findAll()).thenReturn(List.of(order));
        orderModelService.findAllOrders();
        verify(orderRepository, times(1)).findAll();
    }
    @Test
    void testThatWeCanCallTheDeleteMethodInOrderModelService(){
        doNothing().when(orderRepository).deleteById(1);
        orderModelService.deleteOrderById(1);
        verify(orderRepository, times(1)).deleteById(1);
    }
}