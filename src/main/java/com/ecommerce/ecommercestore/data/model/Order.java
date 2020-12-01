package com.ecommerce.ecommercestore.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "order_tb")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;

    private  boolean delivered;

    private boolean cancelled;

    @ManyToOne
    private StoreCustomer storeCustomer;

    @ManyToMany( cascade = CascadeType.DETACH)
    private List<Product> products;

//    public void setProductList(Product product){
//        if(productList == null){
//            productList = new ArrayList<>();
//            }
//        productList.add(product);
//        }
    }
