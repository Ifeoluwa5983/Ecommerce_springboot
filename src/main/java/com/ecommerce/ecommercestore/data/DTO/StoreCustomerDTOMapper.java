package com.ecommerce.ecommercestore.data.DTO;

import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreCustomerDTOMapper {

    @Autowired
    StoreCustomerDTO storeCustomerDTO;

    StoreCustomer customer = new StoreCustomer();

    public  StoreCustomerDTO setCustomerToDTO(StoreCustomer customer){
        storeCustomerDTO.setFname(customer.getFname());
        storeCustomerDTO.setLname(customer.getLname());
        storeCustomerDTO.setId(customer.getId());
        storeCustomerDTO.setContact(customer.getContact());
        storeCustomerDTO.setEmail(customer.getEmail());
        storeCustomerDTO.setPassword(customer.getPassword());
        return storeCustomerDTO;
    }

    public List<StoreCustomerDTO> setCustomerToDTO(List<StoreCustomer> customers){
        List<StoreCustomerDTO> customerDTOS = new ArrayList<>();
        for (StoreCustomer customer : customers){
            customerDTOS.add(setCustomerToDTO(customer));
        }
        return customerDTOS;
    }

    public  StoreCustomer setCustomerDTOToCustomer(StoreCustomerDTO customerDTO){
        customer.setFname(customerDTO.getFname());
        customer.setLname(customerDTO.getLname());
        customer.setId(customerDTO.getId());
        customer.setContact(customerDTO.getContact());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        return customer;
    }
}
