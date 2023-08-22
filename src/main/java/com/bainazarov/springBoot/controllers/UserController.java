package com.bainazarov.springBoot.controllers;

import com.bainazarov.springBoot.entity.Post;
import com.bainazarov.springBoot.entity.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final static List<User> users = new ArrayList<>();

    // add user
    @PostMapping("")
    public User addUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    // add Post for user
    @PostMapping("/{id}")
    public Post addPostById(@PathVariable("id") Long id, @RequestBody Post post) {
        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(user != null) {
            user.getPosts().add(post);
        }
        return post;
    }


    // get all users
    @GetMapping("")
    public List<User> getUsers() {
        return users;
    }

    // get user by username
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .get();
    }

    // update user by username
    @PutMapping("/{username}")
    public Post update(@PathVariable("username") String username, @RequestBody Post post) {
        users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny()
                .ifPresent(user -> user.getPosts().add(post));
        return post;
    }

    // update user by id
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User updateUser) {
        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (user !=null) {
            user.setUsername(updateUser.getUsername());
        } return user;
    }


    // delete user
    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny()
                .ifPresent(users::remove);
        return "User with username " + username + " has been deleted";
    }

    // delete all users
    @DeleteMapping("")
    public String deleteAllUsers() {
        users.clear();
        return "All users have been deleted";
    }
}
