package com.ecommerce.ecommercestore.web.controllers.customer;

import com.ecommerce.ecommercestore.data.DTO.StoreCustomerDTO;
import com.ecommerce.ecommercestore.data.DTO.StoreCustomerDTOMapper;
import com.ecommerce.ecommercestore.data.exception.CustomerException;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import com.ecommerce.ecommercestore.service.customer.CustomerService;
import com.ecommerce.ecommercestore.service.customer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    StoreCustomerDTOMapper storeCustomerDTOMapper;

    @GetMapping("/all")
    public ResponseEntity<?>  getAllCustomers(){
       List<StoreCustomer> customers = customerService.findAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody StoreCustomerDTO customerDTO){
        try{
            customerService.createCustomer(storeCustomerDTOMapper.setCustomerDTOToCustomer(customerDTO));
        }catch (CustomerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateCustomer(@RequestBody StoreCustomerDTO customerDTO){
        try{
            customerService.updateCustomer(storeCustomerDTOMapper.setCustomerDTOToCustomer(customerDTO));
        }catch (CustomerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Integer id){
        try{
            customerService.deleteCustomerById(id);
        }catch (NullPointerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable Integer id){
        StoreCustomer customer;
        try{
            customer = customerService.findByCustomerId(id);
        }catch (NullPointerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(storeCustomerDTOMapper.setCustomerToDTO(customer),HttpStatus.OK);
    }

}
