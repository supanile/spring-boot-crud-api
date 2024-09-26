package com.supanile.crudapi.repository;

import com.supanile.crudapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User save(User user);
}
