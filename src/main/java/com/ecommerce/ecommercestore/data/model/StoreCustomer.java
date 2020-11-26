package com.ecommerce.ecommercestore.data.model;

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
    private Set<Card> cards;

    @ManyToMany(cascade = CascadeType.DETACH)
    @ToString.Exclude
    private Set<Address> addressList;

    @OneToMany(mappedBy = "storeCustomer")
    private Set<OrderModel> orderModels;

    public void setAddress(Address address){
        if(addressList == null){
            addressList = new HashSet<>();
        }
        if(checkIfAddressDoesNotExist(address)) {
            addressList.add(address);
        }
    }

    public void setCard(Card card){
        if(cards == null){
            cards = new HashSet<>();
        }
            cards.add(card);
    }

    private boolean checkIfAddressDoesNotExist(Address address){
        if(!getAddressList().contains(address)){
            return true;
        }
        return false;
    }
}
