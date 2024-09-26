package com.supanile.crudapi.controller;

import com.supanile.crudapi.entity.User;
import com.supanile.crudapi.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setId(0);
        return userService.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User myUser = userService.findById(id);
        if ( myUser == null ) {
            throw new RuntimeException("ไม่พบข้อมูลผู้ใช้รหัส " + id);
        }
        return myUser;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        User myUser = userService.findById(id);
        if(myUser == null) {
            throw new RuntimeException("ไม่พบข้อมูลผู้ใช้รหัส " + id);
        }
        userService.deleteById(id);
        return "ลบข้อมูลผู้ใช้รหัส " + id + " เรียบร้อยแล้ว!";
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }
}
