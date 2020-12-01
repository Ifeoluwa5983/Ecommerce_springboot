package com.ecommerce.ecommercestore.service.customer;

import com.ecommerce.ecommercestore.data.exception.CustomerException;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import com.ecommerce.ecommercestore.data.repository.StoreCustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    @Mock
    StoreCustomerRepository storeCustomerRepository;

    @InjectMocks
    CustomerService customerService = new CustomerServiceImpl();

    StoreCustomer customer;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new StoreCustomer();
    }

    @Test
    void testThatWeCanCallTheCreateMethodInCustomerService() throws CustomerException {
        when(storeCustomerRepository.saveCustomer(customer)).thenReturn(customer);
        customerService.createCustomer(customer);
        verify(storeCustomerRepository, times(1)).saveCustomer(customer);
    }

    @Test
    void testThatWeCanCallTheUpdateMethodInCustomerService() throws CustomerException {
        when(storeCustomerRepository.saveCustomer(customer)).thenReturn(customer);
        customer.setFname("Ifeoluwa");
        customerService.updateCustomer(customer);
        verify(storeCustomerRepository, times(1)).saveCustomer(customer);
    }

    @Test
    void testThatWeCanCallTheDeleteMethodInCustomerService(){
       doNothing().when(storeCustomerRepository).deleteById(1);
        customerService.deleteCustomerById(1);
        verify(storeCustomerRepository, times(1)).deleteById(1);
    }

    @Test
    void testThatWeCanCallTheFindByIdMethodInCustomerService(){
        when(storeCustomerRepository.findById(1)).thenReturn(Optional.of(customer));
        customerService.findByCustomerId(1);
        verify(storeCustomerRepository, times(1)).findById(1);
    }
    @Test
    void testThatWeCanCallAllCustomers(){
        when(storeCustomerRepository.findAll()).thenReturn(List.of(customer));
        customerService.findAllCustomers();
        verify(storeCustomerRepository, times(1)).findAll();
    }
}