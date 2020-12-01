package com.ecommerce.ecommercestore.service.address;

import com.ecommerce.ecommercestore.data.exception.AddressException;
import com.ecommerce.ecommercestore.data.model.Address;
import com.ecommerce.ecommercestore.data.model.Card;
import com.ecommerce.ecommercestore.data.repository.AddressRepository;
import com.ecommerce.ecommercestore.data.repository.CardRepository;
import com.ecommerce.ecommercestore.service.card.CardService;
import com.ecommerce.ecommercestore.service.card.CardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressServiceImplTest {

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    AddressService addressService = new AddressServiceImpl();

    Address address;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        address = new Address();
    }
    @Test
    void testThatWeCanCallTheCreateMethodInAddressService() throws AddressException {
        when(addressRepository.saveAddress(address)).thenReturn(address);
        addressService.createAddress(address);
        verify(addressRepository, times(1)).saveAddress(address);
    }

    @Test
    void testThatWeCanCallTheFindByIdMethodInAddressService(){
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));
        addressService.findByAddressId(1);
        verify(addressRepository, times(1)).findById(1);
    }

    @Test
    void testThatWeCanCallTheUpdateMethodInAddressService() throws AddressException {
        when(addressRepository.saveAddress(address)).thenReturn(address);
        address.setState("Ekiti");
        addressService.createAddress(address);
        verify(addressRepository, times(1)).saveAddress(address);
    }

    @Test
    void testThatWeCanCallAllAddresses(){
        when(addressRepository.findAll()).thenReturn(List.of(address));
        addressService.findAllAddresses();
        verify(addressRepository, times(1)).findAll();
    }
    @Test
    void testThatWeCanCallTheDeleteMethodInAddressService(){
        doNothing().when(addressRepository).deleteById(1);
        addressService.deleteAddressById(1);
        verify(addressRepository, times(1)).deleteById(1);
    }


}