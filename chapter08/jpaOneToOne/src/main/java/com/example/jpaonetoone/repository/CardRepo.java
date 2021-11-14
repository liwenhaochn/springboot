package com.example.jpaonetoone.repository;

import com.example.jpaonetoone.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Long> {

//    Card findById(long id);

}
