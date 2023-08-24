package com.bainazarov.springBoot.dao;

import com.bainazarov.springBoot.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUserByUsername(String username, LocalDate birthday) {
        jdbcTemplate.update("INSERT INTO users (username, birthday) VALUES (?, ?)", username, birthday);
    }

    @Override
    public void addUserById(Long id, LocalDate birthday) {
        jdbcTemplate.update("INSERT INTO users (id, birthday) VALUES (?, ?)", id, birthday);
    }

    @Override
    public List<UserEntity> getUsers() {
        return jdbcTemplate.query("SELECT id, username, birthday FROM users", new BeanPropertyRowMapper<>(UserEntity.class));
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return (UserEntity) jdbcTemplate.query("SELECT id, username, birthday FROM users WHERE username=?", new Object[]{username},
                new BeanPropertyRowMapper<>(UserEntity.class));
    }

    @Override
    public void updateUserByUsername(String username, UserEntity updateUser) {
        jdbcTemplate.update("UPDATE users SET username=?, birthday=?", updateUser.getUsername(), updateUser.getBirthday());
    }

    @Override
    public void updateUserById(Long id, UserEntity updateUser) {
        jdbcTemplate.update("UPDATE users SET id=?, birthday=?", updateUser.getId(), updateUser.getBirthday());
    }

    @Override
    public void deleteUserById(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE FROM users");
    }
}
