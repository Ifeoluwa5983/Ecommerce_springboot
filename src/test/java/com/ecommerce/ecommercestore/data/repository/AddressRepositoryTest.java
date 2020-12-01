package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.exception.AddressException;
import com.ecommerce.ecommercestore.data.model.Address;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = "classpath:db/insert-db.sql")
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    StoreCustomerRepository storeCustomerRepository;

    Address address;

    @BeforeEach
    void setUp() {
        address = new Address();
    }

    @Test
    void testThatWeCanCreateAddress(){
        address.setCity("Sabo");
        address.setCountry("Nigeria");
        address.setState("Lagos");
        address.setStreet("314, Herbert Macaulay");
        address.setZipcode("1234");
        StoreCustomer customer = storeCustomerRepository.findById(1).get();
        address.setStoreCustomers(customer);

        assertDoesNotThrow( ()->{addressRepository.saveAddress(address);});
        assertThat(address).isNotNull();

        log.info("Address after saving --> {}", address);
    }

    @Test
    void testThatWeCannotCreateAddressWithoutCustomer(){
        address.setCity("Sabo");
        address.setCountry("Nigeria");
        address.setState("Lagos");
        address.setStreet("314, Herbert Macaulay");
        address.setZipcode("1234");

        assertThrows(AddressException.class, ()->{
            addressRepository.saveAddress(address);
        });

        log.info("Address after saving --> {}", address);
    }


    @Test
    @Transactional
    @Rollback(value = false)
    void testThatWeCanDeleteAddress(){
        assertThat(addressRepository.existsById(2)).isTrue();
        Address address = addressRepository.findById(2).get();
        address.getStoreCustomers().clear();
        addressRepository.deleteById(2);
        assertThat(addressRepository.existsById(2)).isFalse();
    }

    @Test
    void testThatWeCanUpdateAddress(){
        address = addressRepository.findById(1).orElse(null);
        assertThat(address).isNotNull();
        address.setZipcode("4567");
        addressRepository.save(address);
        assertThat(address).isNotNull();
        log.info("Address after updating --> {}", address);
    }

    @Test
    void testThatWeCanReadAllAddresses(){
        List<Address> addresses = addressRepository.findAll();
        assertThat(addresses).isNotNull();
        log.info("All addresses --> {}", addresses);
    }
}