package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.model.Address;
import com.ecommerce.ecommercestore.data.model.Product;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert-db.sql"})
class StoreCustomerRepositoryTest {

    @Autowired
    StoreCustomerRepository storeCustomerRepository;

    @Autowired
    AddressRepository addressRepository;

    StoreCustomer storeCustomer;

    @BeforeEach
    void setUp() {
        storeCustomer = new StoreCustomer();
    }

    @Test
    void testThatWeCanCreateAProduct(){
        storeCustomer.setFname("Hannah");
        storeCustomer.setLname("Oluwafemi");
        storeCustomer.setContact("07098765432");
        storeCustomer.setEmail("test2@gmail.com");
        storeCustomer.setPassword("ifeoluwa1234");

        storeCustomerRepository.save(storeCustomer);

        assertThat(storeCustomer).isNotNull();
        log.info("Product after saving --> {}", storeCustomer);
    }
    @Test
    void testThatWeCanDeleteAddress(){
        AssertionsForClassTypes.assertThat(storeCustomerRepository.existsById(1)).isTrue();
        storeCustomerRepository.deleteById(1);
        AssertionsForClassTypes.assertThat(storeCustomerRepository.existsById(1)).isFalse();
    }

    @Test
    void testThatWeCanUpdateAddress(){
        storeCustomer = storeCustomerRepository.findById(1).orElse(null);
        AssertionsForClassTypes.assertThat(storeCustomer).isNotNull();
        storeCustomer.setLname("Dorcas");
        storeCustomerRepository.save(storeCustomer);
        AssertionsForClassTypes.assertThat(storeCustomer).isNotNull();
        log.info("Product after updating --> {}", storeCustomer);
    }

    @Test
    void testThatWeCanReadAllAddresses(){
        List<StoreCustomer> storeCustomers = storeCustomerRepository.findAll();
        AssertionsForInterfaceTypes.assertThat(storeCustomer).isNotNull();
        log.info("All products --> {}", storeCustomer);
    }
    @Test
    @Transactional
    @Rollback(value = false)
    void addAddressToCustomer(){
        storeCustomer.setFname("Hannah");
        storeCustomer.setLname("Oluwafemi");
        storeCustomer.setContact("07098765432");
        storeCustomer.setEmail("test2@gmail.com");
        storeCustomer.setPassword("ifeoluwa1234");

        Address address = new Address();
        address.setCity("Yaba");
        address.setCountry("Nigeria");
        address.setState("Lagos");
        address.setStreet("312, Herbert Macaulay");
        address.setZipcode("1234");

        addressRepository.save(address);

        storeCustomer.setAddress(address);
        storeCustomerRepository.save(storeCustomer);

        log.info("Customer after saving --> {}", storeCustomer);
    }

    @Test
    void testThatTwoCustomerCanUseOneAddress(){
        storeCustomer.setFname("Ifeoluwa");
        storeCustomer.setLname("Oluwafemi");
        storeCustomer.setContact("07042441564");
        storeCustomer.setEmail("test@gmail.com");
        storeCustomer.setPassword("ifeoluwa123456");

        Address address = addressRepository.findById(2).orElse(null);

        storeCustomer.setAddress(address);
        storeCustomerRepository.save(storeCustomer);

        log.info("customer --> {}", storeCustomer);

        assertThat(storeCustomer.getId()).isNotNull();
        assertThat(storeCustomer.getAddressList()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void testThatOneCustomerCanHaveMultipleAddresses(){
        storeCustomer = storeCustomerRepository.findById(2).orElse(null);

        Address address = addressRepository.findById(2).orElse(null);

        storeCustomer.setAddress(address);

        storeCustomerRepository.save(storeCustomer);

        log.info("storeCustomer --> {}", storeCustomer);

        assertThat(storeCustomer.getAddressList().size()).isEqualTo(2);

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void testThatWeCanFetchAllCustomerAddress(){
        storeCustomer = storeCustomerRepository.findById(2).orElse(null);

        assert storeCustomer != null;
        for(Address address : storeCustomer.getAddressList()){
            log.info("All addresses -->{}", address);
        }
        assert storeCustomer != null;
        assertThat(storeCustomer.getAddressList().size()).isEqualTo(1);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void testThatWeCanRemoveAnAddressFromACustomerAddressList(){
        storeCustomer = storeCustomerRepository.findById(2).orElse(null);

        Address address = addressRepository.findById(3).orElse(null);

        if (storeCustomer.getAddressList().contains(address)) {
            storeCustomer.getAddressList().remove(address);
        }
        assertThat(storeCustomer.getAddressList().size()).isEqualTo(1);
    }
}