package com.ecommerce.ecommercestore.web.controllers.product;

import com.ecommerce.ecommercestore.data.exception.ProductException;
import com.ecommerce.ecommercestore.data.model.Product;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import com.ecommerce.ecommercestore.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        try{
            productService.createProduct(product);
        }catch (ProductException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        try{
            productService.updateProduct(product);
        }catch (ProductException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer id){
        try{
            productService.deleteProductById(id);
        }catch (NullPointerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Integer id){
        try{
            productService.findByProductId(id);
        }catch (NullPointerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
