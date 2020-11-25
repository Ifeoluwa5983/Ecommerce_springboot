package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

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

        addressRepository.save(address);
        log.info("Address after saving --> {}", address);
    }

    @Test
    void testThatWeCanDeleteAddress(){
        assertThat(addressRepository.existsById(1)).isTrue();
        addressRepository.deleteById(1);
        assertThat(addressRepository.existsById(1)).isFalse();
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