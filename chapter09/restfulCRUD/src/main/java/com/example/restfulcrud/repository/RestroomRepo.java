package com.example.restfulcrud.repository;

import com.example.restfulcrud.entity.Restroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestroomRepo extends JpaRepository<Restroom, Long> {
    Restroom findById(long id);
}
