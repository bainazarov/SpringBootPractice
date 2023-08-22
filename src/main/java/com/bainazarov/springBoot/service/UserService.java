package com.bainazarov.springBoot.service;
import com.bainazarov.springBoot.entity.Post;
import com.bainazarov.springBoot.entity.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final static List<User> users = new ArrayList<>();

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public Post addPostById(Long id, Post post) {
        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(user != null) {
            user.getPosts().add(post);
        }
        return post;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .get();
    }

    public Post updateUserByUsername(String username, Post post) {
        users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny()
                .ifPresent(user -> user.getPosts().add(post));
        return post;
    }

    public User updateUserById(Long id, User updateUser) {
        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (user !=null) {
            user.setUsername(updateUser.getUsername());
        } return user;
    }

    public String deleteUser( String username) {
        users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny()
                .ifPresent(users::remove);
        return "User with username " + username + " has been deleted";
    }

    public String deleteAllUsers() {
        users.clear();
        return "All users have been deleted";
    }

}
