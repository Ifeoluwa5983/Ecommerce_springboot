package com.ecommerce.ecommercestore.service.card;

import com.ecommerce.ecommercestore.data.exception.CardException;
import com.ecommerce.ecommercestore.data.model.Card;
import com.ecommerce.ecommercestore.data.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class CardServiceImplTest {

    @Mock
    CardRepository cardRepository;

    @InjectMocks
    CardService cardService = new CardServiceImpl();

    Card card;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        card = new Card();
    }
    @Test
    void testThatWeCanCallTheCreateMethodInCardService() throws CardException {
        when(cardRepository.saveCard(card)).thenReturn(card);
        cardService.createCard(card);
        verify(cardRepository, times(1)).saveCard(card);
    }

    @Test
    void testThatWeCanCallTheFindByIdMethodInCardService(){
        when(cardRepository.findById(1)).thenReturn(Optional.of(card));
        cardService.findByCardId(1);
        verify(cardRepository, times(1)).findById(1);
    }

    @Test
    void testThatWeCanCallTheUpdateMethodInCardService() throws CardException {
        when(cardRepository.saveCard(card)).thenReturn(card);
        card.setCardName("Heavy");
        cardService.createCard(card);
        verify(cardRepository, times(1)).saveCard(card);
    }

    @Test
    void testThatWeCanCallAllCards(){
        when(cardRepository.findAll()).thenReturn(List.of(card));
        cardService.findAllCards();
        verify(cardRepository, times(1)).findAll();
    }
    @Test
    void testThatWeCanCallTheDeleteMethodInCardService(){
        doNothing().when(cardRepository).deleteById(1);
        cardService.deleteCardById(1);
        verify(cardRepository, times(1)).deleteById(1);
    }

}