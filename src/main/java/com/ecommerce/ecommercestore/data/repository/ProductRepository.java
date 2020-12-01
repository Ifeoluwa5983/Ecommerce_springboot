package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.exception.ProductException;
import com.ecommerce.ecommercestore.data.model.Card;
import com.ecommerce.ecommercestore.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public default Product saveProduct(Product product) throws ProductException {
        Product product1 = null;
       if(isProductValid(product)) {
          product1 = save(product);
       }
        return product1;
    }
    private boolean isProductValid(Product product) throws ProductException {
        if(!productHasPrice(product)){
            throw new ProductException("Where is the price of your product?");
        }
        if(!productHasExpiryDate(product)){
            throw new ProductException("The product must have an expiry date");
        }
        if(!productHasQuantity(product)){
            throw new ProductException("How many products are you uploading");
        }
        return true;
    }

    private boolean productHasPrice(Product product){
        if(product.getPrice() == null){
            return false;
        }
        return true;
    }
    private boolean productHasExpiryDate(Product product){
        if(product.getExp() == null){
            return false;
        }
        return true;
    }
    private boolean productHasQuantity(Product product){
        if(product.getQuantity() == null){
            return false;
        }
        return true;
    }
}
