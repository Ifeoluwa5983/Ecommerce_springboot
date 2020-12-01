package com.ecommerce.ecommercestore.service.customer;

import com.ecommerce.ecommercestore.data.DTO.StoreCustomerDTO;
import com.ecommerce.ecommercestore.data.DTO.StoreCustomerDTOMapper;
import com.ecommerce.ecommercestore.data.exception.CustomerException;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import com.ecommerce.ecommercestore.data.repository.StoreCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    StoreCustomerRepository storeCustomerRepository;

    @Autowired
    StoreCustomerDTOMapper storeCustomerDTOMapper;

    @Override
    public StoreCustomerDTO findByCustomerId(Integer id) {
        StoreCustomer customer =  storeCustomerRepository.findById(id).get();
        return storeCustomerDTOMapper.setCustomerToDTO(customer);
    }

    @Override
    public List<StoreCustomer> findAllCustomers() {
        return storeCustomerRepository.findAll();
    }

    @Override
    public void deleteCustomerById(Integer id){
            storeCustomerRepository.deleteById(id);
    }

    @Override
    public StoreCustomer updateCustomer(StoreCustomer customer) throws CustomerException {
        if(customer.getId() == null){
            throw new CustomerException("Id cannot be null");
        }
        StoreCustomer existingCustomer = storeCustomerRepository.findById(customer.getId()).get();

        if (existingCustomer == null){
            throw new CustomerException("Customer does not exist");
        }
        if(customer.getPassword() != null){
            existingCustomer.setPassword(customer.getPassword());
        }
        if(customer.getContact() != null){
            existingCustomer.setContact(customer.getContact());
        }
        return storeCustomerRepository.saveCustomer(existingCustomer);
    }

    @Override
    public StoreCustomer createCustomer(StoreCustomer customer) throws CustomerException {
        if(customer == null){
            throw new NullPointerException("Customer object cannot be null");
        }
        return storeCustomerRepository.saveCustomer(customer);
    }

}
