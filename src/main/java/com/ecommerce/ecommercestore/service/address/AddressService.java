package com.ecommerce.ecommercestore.service.address;

import com.ecommerce.ecommercestore.data.exception.AddressException;
import com.ecommerce.ecommercestore.data.model.Address;

import java.util.List;

public interface AddressService {

    public List<Address> findAllAddresses();

    public Address findByAddressId(Integer id);

    public void deleteAddressById(Integer id);

    public Address createAddress(Address address) throws AddressException;

    public Address updateAddress(Address address) throws AddressException;
}
