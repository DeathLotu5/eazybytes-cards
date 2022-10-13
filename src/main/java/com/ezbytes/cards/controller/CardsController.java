package com.ezbytes.cards.controller;

import com.ezbytes.cards.entity.CardEntity;
import com.ezbytes.cards.entity.Customer;
import com.ezbytes.cards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @PostMapping("/myCards")
    public List<CardEntity> getCardDetails(@RequestBody Customer customer) {
        List<CardEntity> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        if (cards != null) {
            return cards;
        }

        return null;
    }


}
