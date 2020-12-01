package com.ecommerce.ecommercestore.web.controllers.order;

import com.ecommerce.ecommercestore.data.model.Order;
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

@AutoConfigureMockMvc
@SpringBootTest
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper;
    Order order;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        order = new Order();
    }

    @Test
    void testThatWeCanCreateAnOrder() throws Exception {
        order.setDate("12-3-2018");
        order.setDelivered(false);
        order.setCancelled(false);

        this.mockMvc.perform(post("/order/create")
                .contentType("application/json")
                .content(mapper.writeValueAsString(order)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void testThatWeCanGetAllOrders() throws Exception {

        this.mockMvc.perform(get("/order/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testThatWeCanGetAnOrderById() throws Exception {

        this.mockMvc.perform(get("/order/one/6"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void testThatWeCanDeleteOrderById() throws Exception {

        this.mockMvc.perform(delete("/order/delete/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testThatWeCanUpdateAnOrder() throws Exception {

        this.mockMvc.perform(post("/order/update")
                .contentType("application/json")
                .content(mapper.writeValueAsString(order)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }
}