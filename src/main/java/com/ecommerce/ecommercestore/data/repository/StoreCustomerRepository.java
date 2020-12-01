package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.exception.CustomerException;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreCustomerRepository extends JpaRepository<StoreCustomer, Integer> {

    public default StoreCustomer saveCustomer(StoreCustomer customer) throws CustomerException {
        StoreCustomer customer1 = null;
        if (isCustomerValid(customer)) {
           customer1 = save(customer);
        }
        return customer1;
    }
    private boolean isCustomerValid(StoreCustomer customer) throws CustomerException {
        if(!customerHaveEmail(customer)){
            throw new CustomerException("Please input an email");
        }
        if(!customerHaveFirstName(customer)){
            throw new CustomerException("Please input your first name");
        }
        if(!customerHaveLastName(customer)){
            throw new CustomerException("Please input your last name");
        }
        return true;
    }

    private boolean customerHaveEmail(StoreCustomer customer){
        if(customer.getEmail() == null){
            return false;
        }
        return true;
    }
    private boolean customerHaveFirstName(StoreCustomer customer){
        if(customer.getFname() == null){
            return false;
        }
        return true;
    }
    private boolean customerHaveLastName(StoreCustomer customer){
        if(customer.getLname() == null){
            return false;
        }
        return true;
    }
}
