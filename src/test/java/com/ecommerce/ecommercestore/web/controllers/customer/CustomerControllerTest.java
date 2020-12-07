package com.ecommerce.ecommercestore.web.controllers.customer;

import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper;
    StoreCustomer storeCustomer;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        storeCustomer = new StoreCustomer();
    }

    @Test
    void testCreateCustomerEndpoint_thenReturnOK() throws Exception {
        storeCustomer.setFname("Hannah");
        storeCustomer.setLname("Oluwafemi");
        storeCustomer.setContact("07098765432");
        storeCustomer.setEmail("test2@gmail.com");
        storeCustomer.setPassword("ifeoluwa1234");

        this.mockMvc.perform(post("/customer/create")
                .contentType("application/json")
                .content(mapper.writeValueAsString(storeCustomer)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void testGetAllCustomersEndpoint() throws Exception {
        this.mockMvc.perform(get("/customer/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testGetCustomerByIdEndpoint() throws Exception {
        this.mockMvc.perform(get("/customer/one/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testDeleteCustomerByIdEndpoint() throws Exception {
        this.mockMvc.perform(delete("/customer/delete/3"))
                .andDo(print())
                .andExpect(status().isNoContent())
                .andReturn();
    }

    @Test
    void testUpdateCustomerEndpoint() throws Exception {

        storeCustomer.setId(1);
        storeCustomer.setFname("Bolu");

        this.mockMvc.perform(post("/customer/update")
                .contentType("application/json")
                .content(mapper.writeValueAsString(storeCustomer)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }
}