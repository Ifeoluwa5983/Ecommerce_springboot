package com.ecommerce.ecommercestore.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cardType;

    private String cardCVV;

    private  String cardNumber;

    private String cardName;

    private String exp;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private StoreCustomer storeCustomer;

    public void setStoreCustomer(StoreCustomer customer){
        if(getStoreCustomer() == null){
            this.storeCustomer = customer;
        }
    }
}
