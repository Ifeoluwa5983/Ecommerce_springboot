package com.ecommerce.ecommercestore.service.address;

import com.ecommerce.ecommercestore.data.exception.AddressException;
import com.ecommerce.ecommercestore.data.model.Address;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import com.ecommerce.ecommercestore.data.repository.AddressRepository;
import com.ecommerce.ecommercestore.data.repository.StoreCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address findByAddressId(Integer id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteAddressById(Integer id){
        addressRepository.deleteById(id);
    }

    @Override
    public Address updateAddress(Address address ) throws AddressException {
        if(address == null){
            throw new NullPointerException("Address object cannot be null");
        }
        return addressRepository.saveAddress(address);
    }

    @Override
    public Address createAddress(Address address) throws AddressException {
        if(address == null){
            throw new NullPointerException("Address object cannot be null");
        }
        return addressRepository.saveAddress(address);
    }

}
