package com.bainazarov.springBoot.dao;

import com.bainazarov.springBoot.entity.UserEntity;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserDao {

    void addUserByUsername(UserEntity user);
    void addUserById(UserEntity user);
    List<UserEntity> getUsers();
    UserEntity getUserByUsername(String username);
    void updateUserByUsername(String username, UserEntity updateUser);
    void updateUserById(Long id, UserEntity updateUser);
    void deleteUserByUsername(String username);
    void deleteAllUsers();
}
