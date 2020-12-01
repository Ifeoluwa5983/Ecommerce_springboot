package com.ecommerce.ecommercestore.service.card;

import com.ecommerce.ecommercestore.data.exception.CardException;
import com.ecommerce.ecommercestore.data.model.Card;

import java.util.List;

public interface CardService {

    public Card findByCardId(Integer id);

    public List<Card> findAllCards();

    public void deleteCardById(Integer id);

    public Card updateCard(Card card) throws CardException;

    public Card createCard(Card card) throws CardException;
}
