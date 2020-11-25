package com.ecommerce.ecommercestore.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
