package com.ecommerce.ecommercestore.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String country;

    private String state;

    private String city;

    private String zipcode;

    private String street;

    @ManyToMany(mappedBy = "addresses")
    @ToString.Exclude
    private List<StoreCustomer> storeCustomers;

    public void setStoreCustomers(StoreCustomer storeCustomer){
        if(storeCustomers == null){
            storeCustomers = new ArrayList<>();
        }
        storeCustomers.add(storeCustomer);
    }
}
