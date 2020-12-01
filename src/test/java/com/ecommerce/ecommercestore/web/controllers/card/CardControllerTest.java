package com.ecommerce.ecommercestore.web.controllers.card;

import com.ecommerce.ecommercestore.data.model.Card;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    Card card;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        card = new Card();
        mapper = new ObjectMapper();
    }

    @Test
    void testThatWeCanCreateACard() throws Exception {
        card.setCardType("Credit");
        card.setCardCVV("124");
        card.setCardNumber("123456789");
        card.setCardName("Ifeoluwa");
        card.setExp("12-12-2020");

        this.mockMvc.perform(post("/product/create")
                .contentType("application/json")
                .content(mapper.writeValueAsString(card)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

    }
    @Test
    void testGetAllCardsEndpoint() throws Exception {
        this.mockMvc.perform(get("/card/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testGetCardByIdEndpoint() throws Exception {
        this.mockMvc.perform(get("/card/one/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testDeleteCardByIdEndpoint() throws Exception {
        this.mockMvc.perform(delete("/card/delete/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void testUpdateCardEndpoint() throws Exception {

        this.mockMvc.perform(post("/card/update")
                .contentType("application/json")
                .content(mapper.writeValueAsString(card)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }


}