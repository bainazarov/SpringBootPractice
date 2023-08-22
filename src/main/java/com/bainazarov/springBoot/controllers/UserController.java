package com.bainazarov.springBoot.controllers;

import com.bainazarov.springBoot.entity.Post;
import com.bainazarov.springBoot.entity.User;
import com.bainazarov.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // add user
    @PostMapping("")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // add Post for user
    @PostMapping("/{id}")
    public Post addPostById(@PathVariable("id") Long id, @RequestBody Post post) {
        return userService.addPostById(id, post);
    }

    // get all users
    @GetMapping("")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // get user by username
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }

    // update user by username
    @PutMapping("/{username}")
    public Post updateUserByUsername(@PathVariable("username") String username, @RequestBody Post post) {
        return userService.updateUserByUsername(username, post);
    }

    // update user by id
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User updateUser) {
        return userService.updateUserById(id, updateUser);
    }

    // delete user
    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        return userService.deleteUser(username);
    }

    // delete all users
    @DeleteMapping("")
    public String deleteAllUsers() {
        return userService.deleteAllUsers();
    }
}
