package com.ecommerce.ecommercestore.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;

    private  boolean delivered;

    private boolean status;

    @ManyToOne
    private StoreCustomer storeCustomer;

    @ManyToMany
    private List<Product> productList;
}
