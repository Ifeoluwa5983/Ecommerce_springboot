package com.ecommerce.ecommercestore.data.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private String price;

    private Integer quantity;

    private String exp;

//    @OneToMany(cascade = CascadeType.PERSIST)
//    private Order order;
}
