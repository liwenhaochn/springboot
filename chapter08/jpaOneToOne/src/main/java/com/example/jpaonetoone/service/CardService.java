package com.example.jpaonetoone.service;

import com.example.jpaonetoone.entity.Card;

import java.util.List;

public interface CardService {

    public List<Card> getCardList();

    public Card findCardById(long id);
}
