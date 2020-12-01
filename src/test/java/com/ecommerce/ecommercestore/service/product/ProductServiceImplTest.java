package com.ecommerce.ecommercestore.service.product;

import com.ecommerce.ecommercestore.data.exception.ProductException;
import com.ecommerce.ecommercestore.data.model.Product;
import com.ecommerce.ecommercestore.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService = new ProductServiceImpl();

    Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
    }
    @Test
    void testThatWeCanCallTheCreateMethodInProductService() throws ProductException {
        when(productRepository.saveProduct(product)).thenReturn(product);
        productService.createProduct(product);
        verify(productRepository, times(1)).saveProduct(product);
    }

    @Test
    void testThatWeCanCallTheUpdateMethodInProductService() throws ProductException {
        when(productRepository.saveProduct(product)).thenReturn(product);
        product.setName("Bottle");
        productService.updateProduct(product);
        verify(productRepository, times(1)).saveProduct(product);
    }

    @Test
    void testThatWeCanCallTheFindByIdMethodInProductService(){
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        productService.findByProductId(1);
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    void testThatWeCanCallAllProducts(){
        when(productRepository.findAll()).thenReturn(List.of(product));
        productService.findAllProducts();
        verify(productRepository, times(1)).findAll();
    }
    @Test
    void testThatWeCanCallTheDeleteMethodInProductService(){
        doNothing().when(productRepository).deleteById(1);
        productService.deleteProductById(1);
        verify(productRepository, times(1)).deleteById(1);
    }

}