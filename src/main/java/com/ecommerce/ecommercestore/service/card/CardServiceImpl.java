package com.ecommerce.ecommercestore.service.card;

import com.ecommerce.ecommercestore.data.exception.CardException;
import com.ecommerce.ecommercestore.data.model.Card;
import com.ecommerce.ecommercestore.data.model.StoreCustomer;
import com.ecommerce.ecommercestore.data.repository.CardRepository;
import com.ecommerce.ecommercestore.data.repository.StoreCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public Card findByCardId(Integer id) {
        return cardRepository.findById(id).get();
    }

    @Override
    public List<Card> findAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public void deleteCardById(Integer id){
        cardRepository.deleteById(id);
    }

    @Override
    public Card updateCard(Card card) throws CardException {
        if(card == null){
            throw new NullPointerException("Card object cannot be null");
        }
        return cardRepository.saveCard(card);
    }

    @Override
    public Card createCard(Card card) throws CardException {
        if(card == null){
            throw new NullPointerException("Card object cannot be null");
        }
        return cardRepository.saveCard(card);
    }

}
