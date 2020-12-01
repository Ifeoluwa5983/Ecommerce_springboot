package com.ecommerce.ecommercestore.service.customer;

import com.ecommerce.ecommercestore.data.DTO.StoreCustomerDTO;
import com.ecommerce.ecommercestore.data.exception.CustomerException;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;

import java.util.List;


public interface CustomerService {

    public StoreCustomerDTO findByCustomerId(Integer id);

    public List<StoreCustomer> findAllCustomers();

    public void deleteCustomerById(Integer id);

    public StoreCustomer updateCustomer(StoreCustomer customer) throws CustomerException;

    public StoreCustomer createCustomer(StoreCustomer customer) throws CustomerException;
}
