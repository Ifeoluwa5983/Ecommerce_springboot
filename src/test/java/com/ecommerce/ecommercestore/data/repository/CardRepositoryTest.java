package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.model.Card;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert-db.sql"})
class CardRepositoryTest {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    StoreCustomerRepository storeCustomerRepository;

    Card card;

    @BeforeEach
    void setUp() {
        card = new Card();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void testThatWeCanSaveCard(){
        card.setCardType("Credit");
        card.setCardCVV("124");
        card.setCardNumber("123456789");
        card.setCardName("Ifeoluwa");
        card.setExp("12-12-2020");

        StoreCustomer customer = storeCustomerRepository.findById(1).orElse(null);
        card.setStoreCustomer(customer);

        cardRepository.save(card);

        assertThat(customer).isNotNull();
        assertThat(card.getId()).isNotNull();

        log.info("Card --> {}", card);
    }

    @Test
    void testThatOneCustomerCanHaveMultipleCards(){
        card = cardRepository.findById(2).orElse(null);
        assertThat(card).isNotNull();
        StoreCustomer customer = storeCustomerRepository.findById(1).orElse(null);
        assertThat(customer).isNotNull();
        card.setStoreCustomer(customer);

        cardRepository.save(card);
        assertThat(card.getId()).isNotNull();
        assertThat(card.getStoreCustomer()).isNotNull();
        log.info("Card --> {}", card);

    }
}