package com.ecommerce.ecommercestore.service.product;

import com.ecommerce.ecommercestore.data.exception.ProductException;
import com.ecommerce.ecommercestore.data.model.Product;

import java.util.List;

public interface ProductService {
    public Product findByProductId(Integer id);

    public List<Product> findAllProducts();

    public void deleteProductById(Integer id);

    public Product updateProduct(Product product) throws ProductException;

    public Product createProduct(Product product) throws ProductException;
}
