package com.gbss.auth.repositories;


import com.gbss.auth.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Akshay Misra on 09-08-2018.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String userName);
}
