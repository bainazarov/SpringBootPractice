package com.bainazarov.springBoot.service;

import com.bainazarov.springBoot.entity.UserEntity;
import java.util.List;

public interface UserService {
    void addUserByUsername(UserEntity user);
    void addUserById(UserEntity user);
    List<UserEntity> getUsers();
    UserEntity getUserByUsername(String username);
    void updateUserByUsername(String username, UserEntity updateUser);
    void updateUserById(Long id, UserEntity updateUser);
    void deleteUserByUsername(String username);
    void deleteAllUsers();
}
