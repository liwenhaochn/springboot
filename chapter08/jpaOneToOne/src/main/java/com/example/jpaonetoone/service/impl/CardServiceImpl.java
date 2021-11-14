package com.example.jpaonetoone.service.impl;

import com.example.jpaonetoone.entity.Card;
import com.example.jpaonetoone.repository.CardRepo;
import com.example.jpaonetoone.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepo cardRepo;

    @Override
    public List<Card> getCardList() {
        return cardRepo.findAll();
    }

    @Override
    public Card findCardById(long id) {
        return cardRepo.findById(id);
    }
}
