package com.ecommerce.ecommercestore.service.product;

import com.ecommerce.ecommercestore.data.exception.ProductException;
import com.ecommerce.ecommercestore.data.model.Product;
import com.ecommerce.ecommercestore.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product findByProductId(Integer id)  {
            return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(Integer id){
            productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) throws ProductException {
        if(product == null){
            throw new NullPointerException("Product object cannot be null");
        }
        return productRepository.saveProduct(product);
    }

    @Override
    public Product createProduct(Product product) throws ProductException {
        if(product == null){
            throw new NullPointerException("Product object cannot be null");
        }
        return productRepository.saveProduct(product);
    }

}
