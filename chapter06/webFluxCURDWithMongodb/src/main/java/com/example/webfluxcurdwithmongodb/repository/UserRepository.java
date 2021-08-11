package com.example.webfluxcurdwithmongodb.repository;

import com.example.webfluxcurdwithmongodb.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User,String> {

}
