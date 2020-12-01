package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.exception.ProductException;
import com.ecommerce.ecommercestore.data.model.Address;
import com.ecommerce.ecommercestore.data.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert-db.sql"})
class ProductRepositoryTest {

        @Autowired
        ProductRepository productRepository;

        Product product;

        @BeforeEach
        void setUp() {
            product = new Product();
        }

        @Test
        void testThatWeCanCreateAProduct(){
            product.setName("Biro");
            product.setDescription("Pass your exams");
            product.setPrice(20.0);
            product.setQuantity(25);
            product.setExp("15-14-2025");

            assertDoesNotThrow( ()->{productRepository.saveProduct(product);});
            log.info("Product after saving --> {}", product);
        }
    @Test
    void testThatWeCanCreateAProductWithoutExpiryDate(){
        product.setName("Biro");
        product.setDescription("Pass your exams");
        product.setPrice(20.0);
        product.setQuantity(25);

        assertThrows(ProductException.class, ()->{productRepository.saveProduct(product);});
    }
    @Test
    void testThatWeCanDeleteProduct(){
        AssertionsForClassTypes.assertThat(productRepository.existsById(1)).isTrue();
        productRepository.deleteById(1);
        AssertionsForClassTypes.assertThat(productRepository.existsById(1)).isFalse();
    }

    @Test
    void testThatWeCanUpdateProduct(){
        product = productRepository.findById(1).orElse(null);
        AssertionsForClassTypes.assertThat(product).isNotNull();
        product.setPrice(120.0);
        productRepository.save(product);
        AssertionsForClassTypes.assertThat(product).isNotNull();
        log.info("Product after updating --> {}", product);
    }

    @Test
    void testThatWeCanReadAllProducts(){
        List<Product> products = productRepository.findAll();
        assertThat(products).isNotNull();
        log.info("All products --> {}", products);
    }
    }