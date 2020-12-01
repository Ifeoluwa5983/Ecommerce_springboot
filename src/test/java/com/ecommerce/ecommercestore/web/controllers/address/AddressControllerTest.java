package com.ecommerce.ecommercestore.web.controllers.address;

import com.ecommerce.ecommercestore.data.model.Address;
import com.ecommerce.ecommercestore.data.model.Card;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    Address address;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        address = new Address();
        mapper = new ObjectMapper();
    }

    @Test
    void testThatWeCanCreateAnAddress() throws Exception {
        address.setCity("Sabo");
        address.setCountry("Nigeria");
        address.setState("Lagos");
        address.setStreet("314, Herbert Macaulay");
        address.setZipcode("1234");

        this.mockMvc.perform(post("/address/create")
                .contentType("application/json")
                .content(mapper.writeValueAsString(address)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

    }
    @Test
    void testGetAllAddressesEndpoint() throws Exception {
        this.mockMvc.perform(get("/address/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testGetAddressByIdEndpoint() throws Exception {
        this.mockMvc.perform(get("/address/one/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testDeleteAddressByIdEndpoint() throws Exception {
        this.mockMvc.perform(delete("/address/delete/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void testUpdateAddressEndpoint() throws Exception {

        this.mockMvc.perform(post("/address/update")
                .contentType("application/json")
                .content(mapper.writeValueAsString(address)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

}