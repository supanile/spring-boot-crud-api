package com.supanile.crudapi.services;

import com.supanile.crudapi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
}
