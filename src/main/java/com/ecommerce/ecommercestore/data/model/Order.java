package com.ecommerce.ecommercestore.data.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

public class Order {
    private Integer id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> productList;
}
