package com.ezbytes.cards.controller;

import com.ezbytes.cards.config.CardServiceConfig;
import com.ezbytes.cards.entity.CardEntity;
import com.ezbytes.cards.entity.Customer;
import com.ezbytes.cards.entity.Properties;
import com.ezbytes.cards.repository.CardsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private CardServiceConfig cardServiceConfig;

    @PostMapping("/myCards")
    public List<CardEntity> getCardDetails(@RequestBody Customer customer) {
        List<CardEntity> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        if (cards != null) {
            return cards;
        }

        return null;
    }

    @GetMapping("/card/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardServiceConfig.getMsg(),
                cardServiceConfig.getBuildVersion(),
                cardServiceConfig.getMailDetails(),
                cardServiceConfig.getActiveBranches()
        );
        return ow.writeValueAsString(properties);
    }


}
