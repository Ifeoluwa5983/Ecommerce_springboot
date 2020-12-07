package com.ecommerce.ecommercestore.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class StoreCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fname;

    private String lname;

    private String email;

    private String contact;

    private String password;

    @OneToMany(mappedBy = "storeCustomer")
    @ToString.Exclude
    @JsonIgnore
    private Set<Card> cards;

    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private Set<Address> addresses;

    @OneToMany(mappedBy = "storeCustomer")
    private Set<Order> orders;

    public void setAddress(Address address){
        if(addresses == null){
            addresses = new HashSet<>();
        }
        if(checkIfAddressDoesNotExist(address)) {
            addresses.add(address);
        }
    }

    public void setCard(Card card){
        if(cards == null){
            cards = new HashSet<>();
        }
            cards.add(card);
    }

    private boolean checkIfAddressDoesNotExist(Address address){
        if(!getAddresses().contains(address)){
            return true;
        }
        return false;
    }
}
