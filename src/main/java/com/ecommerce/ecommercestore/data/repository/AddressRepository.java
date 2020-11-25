package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
