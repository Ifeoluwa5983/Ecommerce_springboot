package com.ecommerce.ecommercestore.web.controllers.address;

import com.ecommerce.ecommercestore.data.exception.AddressException;
import com.ecommerce.ecommercestore.data.model.Address;
import com.ecommerce.ecommercestore.data.model.Product;
import com.ecommerce.ecommercestore.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllAddresses(){
        List<Address> address = addressService.findAllAddresses();
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAddress(@RequestBody Address address){
        try{
            addressService.createAddress(address);
        }catch (AddressException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody Address address){
        try{
            addressService.updateAddress(address);
        }catch (AddressException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Integer id){
        try{
            addressService.deleteAddressById(id);
        }catch (NullPointerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/one/{id}")
    public ResponseEntity<?> findAddressById(@PathVariable Integer id){
        try{
            addressService.findByAddressId(id);
        }catch (NullPointerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
