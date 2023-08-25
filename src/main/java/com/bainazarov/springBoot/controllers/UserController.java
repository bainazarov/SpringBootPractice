package com.bainazarov.springBoot.controllers;

import com.bainazarov.springBoot.entity.UserEntity;
import com.bainazarov.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // add user by username
    @PostMapping("")
    public void addUserByUsername(@RequestBody UserEntity user) {
        userService.addUserByUsername(user);
    }

    // add user by id
    @PostMapping("/{id}")
    public void addUserById(@RequestBody UserEntity user) {
        userService.addUserById(user);
    }

    // get all users
    @GetMapping("")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    // get user by username
    @GetMapping("/{username}")
    public UserEntity getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }

    // update user by username
    @PutMapping("/{username}")
    public void updateUserByUsername(@PathVariable("username") String username, @RequestBody UserEntity updateUser) {
        userService.updateUserByUsername(username, updateUser);
    }

    // update user by id
    @PutMapping("/{id}")
    public void updateUserById(@PathVariable("id") Long id, @RequestBody UserEntity updateUser) {
        userService.updateUserById(id, updateUser);
    }

    // delete user by id
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    // delete all users
    @DeleteMapping("")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }
}
