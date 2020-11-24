package com.griso.hexagonal.user.adapter.repository;

import com.griso.hexagonal.user.domain.model.User;
import com.griso.hexagonal.user.domain.repository.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryMongoDb extends UserRepository, MongoRepository<User, String> {

}
