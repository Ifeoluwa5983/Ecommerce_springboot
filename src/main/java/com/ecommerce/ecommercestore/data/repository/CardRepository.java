package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.exception.CardException;
import com.ecommerce.ecommercestore.data.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

    public default Card saveCard(Card card) throws CardException {
        Card savedCard = null;
        if(isCardValid(card)){
            savedCard = save(card);
        }
        return card;
    }

    private boolean isCardValid(Card card) throws CardException {
        if(!cardHasCustomer(card)){
            throw new CardException("A card must always have a user");
        }
        if(!cardHasExpiryDate(card)){
            throw new CardException("A card must always have an expiry date");
        }
        if(!cardHasCvv(card)){
            throw new CardException("A card must always have the cvv digits");
        }
        return true;
    }
    private boolean cardHasCustomer(Card card){
        if(card.getStoreCustomer() == null){
            return false;
        }
        return true;
    }
    private boolean cardHasExpiryDate(Card card){
        if(card.getExp() == null){
            return false;
        }
        return true;
    }
    private boolean cardHasCvv(Card card){
        if(card.getCardCVV() == null){
            return false;
        }
        return true;
    }

}
