package com.nivelacion.nivelacion.repositories;


import com.nivelacion.nivelacion.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <Users, String> {
}
