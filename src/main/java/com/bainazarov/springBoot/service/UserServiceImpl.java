package com.bainazarov.springBoot.service;
import com.bainazarov.springBoot.dao.UserDao;
import com.bainazarov.springBoot.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserByUsername(String username, LocalDate birthday) {
        userDao.addUserByUsername(username, birthday);
    }

    @Override
    public void addUserById(Long id, LocalDate birthday) {
        userDao.addUserById(id, birthday);
    }

    @Override
    public List<UserEntity> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public void updateUserByUsername(String username, UserEntity updateUser) {
        userDao.updateUserByUsername(username, updateUser);
    }

    @Override
    public void updateUserById(Long id, UserEntity updateUser) {
        userDao.updateUserById(id, updateUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public String deleteAllUsers() {
        userDao.deleteAllUsers();
        return "All users have been deleted";
    }
}
