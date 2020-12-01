package com.ecommerce.ecommercestore.web.controllers.card;

import com.ecommerce.ecommercestore.data.exception.CardException;
import com.ecommerce.ecommercestore.data.model.Card;
import com.ecommerce.ecommercestore.data.model.Product;
import com.ecommerce.ecommercestore.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {


    @Autowired
    CardService cardService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCards(){
        List<Card> cards = cardService.findAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCard(@RequestBody Card card){
        try{
            cardService.createCard(card);
        }catch (CardException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateCard(@RequestBody Card card){
        try{
            cardService.updateCard(card);
        }catch (CardException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCardById(@PathVariable Integer id){
        try{
            cardService.deleteCardById(id);
        }catch (NullPointerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<?> findCardById(@PathVariable Integer id){
        try{
            cardService.findByCardId(id);
        }catch (NullPointerException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
