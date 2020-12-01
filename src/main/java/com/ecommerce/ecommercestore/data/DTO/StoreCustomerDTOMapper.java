package com.ecommerce.ecommercestore.data.DTO;

import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreCustomerDTOMapper {
    @Autowired
    StoreCustomerDTO storeCustomerDTO;

    public  StoreCustomerDTO setCustomerToDTO(StoreCustomer customer){
        storeCustomerDTO.setFname(customer.getFname());
        storeCustomerDTO.setLname(customer.getLname());
        storeCustomerDTO.setId(customer.getId());
        storeCustomerDTO.setContact(customer.getContact());
        storeCustomerDTO.setEmail(customer.getEmail());
        return storeCustomerDTO;
    }
}
