package com.ecommerce.ecommercestore.data.model;

import lombok.Data;

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

    @ManyToMany(cascade = CascadeType.DETACH)
    private Set<Address> addressList;

    public void setAddress(Address address){
        if(addressList == null){
            addressList = new HashSet<>();
        }
        if(checkIfAddressDoesNotExist(address)) {
            addressList.add(address);
        }
    }

    private boolean checkIfAddressDoesNotExist(Address address){
        if(!getAddressList().contains(address)){
            return true;
        }
        return false;
    }
}
