package com.bainazarov.springBoot.dao;

import com.bainazarov.springBoot.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface UserDao {

    void addUserByUsername(String username, LocalDate birthday);
    void addUserById(Long id, LocalDate birthday);
    List<UserEntity> getUsers();
    UserEntity getUserByUsername(String username);
    void updateUserByUsername(String username, UserEntity updateUser);
    void updateUserById(Long id, UserEntity updateUser);
    void deleteUserById(Long id);
    void deleteAllUsers();
}
