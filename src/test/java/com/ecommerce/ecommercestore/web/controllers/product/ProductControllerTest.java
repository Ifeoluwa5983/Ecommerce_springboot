package com.ecommerce.ecommercestore.web.controllers.product;

import com.ecommerce.ecommercestore.data.model.Product;
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
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    Product product;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        product = new Product();
        mapper = new ObjectMapper();
    }

    @Test
    void testThatWeCanCreateAProduct() throws Exception {
        product.setName("Biro");
        product.setDescription("Pass your exams");
        product.setPrice(20.0);
        product.setQuantity(25);
        product.setExp("15-14-2025");

        this.mockMvc.perform(post("/product/create")
                .contentType("application/json")
                .content(mapper.writeValueAsString(product)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

    }
    @Test
    void testGetAllProductsEndpoint() throws Exception {
        this.mockMvc.perform(get("/product/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testGetProductByIdEndpoint() throws Exception {
        this.mockMvc.perform(get("/product/one/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testDeleteProductByIdEndpoint() throws Exception {
        this.mockMvc.perform(delete("/product/delete/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void testUpdateProductEndpoint() throws Exception {

        this.mockMvc.perform(post("/product/update")
                .contentType("application/json")
                .content(mapper.writeValueAsString(product)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

}