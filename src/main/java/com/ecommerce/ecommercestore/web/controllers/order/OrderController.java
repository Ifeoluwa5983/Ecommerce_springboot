package com.ecommerce.ecommercestore.web.controllers.order;

import com.ecommerce.ecommercestore.data.exception.OrderException;
import com.ecommerce.ecommercestore.data.model.Order;
import com.ecommerce.ecommercestore.data.model.Product;
import com.ecommerce.ecommercestore.service.order.OrderModelService;
import com.ecommerce.ecommercestore.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderModelService orderModelService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders(){
        List<Order> orders = orderModelService.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        try{
            orderModelService.createOrder(order);
        }catch (OrderException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestBody Order order){
        try{
            orderModelService.updateOrder(order);
        }catch (OrderException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Integer id){
        try{
            orderModelService.deleteOrderById(id);
        }catch (NullPointerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<?> findOrderById(@PathVariable Integer id){
        try{
            orderModelService.findByOrderId(id);
        }catch (NullPointerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
