package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.exception.AddressException;
import com.ecommerce.ecommercestore.data.exception.OrderException;
import com.ecommerce.ecommercestore.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

     default Address saveAddress(Address address) throws AddressException {
         Address savedAddress = null;
         if(isAddressValid(address)){
            savedAddress = save(address);
         }
        return savedAddress;
    }

    private boolean isAddressValid(Address address) throws AddressException {
        if(!addressHasCustomer(address)){
            throw new AddressException("Customer cannot be null");
        }
        if (!addressHasZipcode(address)){
            throw new AddressException("Zip code cannot be null");
        }
        return true;
    }

    private boolean addressHasCustomer(Address address){
        if(address.getStoreCustomers() == null){
            return false;
        }
        return true;
    }

    private boolean addressHasZipcode(Address address){
        if(address.getZipcode() == null){
            return false;
        }
        return true;
    }
}
