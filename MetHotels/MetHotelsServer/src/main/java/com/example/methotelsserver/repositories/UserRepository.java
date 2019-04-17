package com.example.methotelsserver.repositories;

import com.example.methotelsserver.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User getByUserId(Long id);
    User getByUsername(String username);
}
