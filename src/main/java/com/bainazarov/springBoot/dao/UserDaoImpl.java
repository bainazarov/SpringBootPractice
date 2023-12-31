package com.bainazarov.springBoot.dao;

import com.bainazarov.springBoot.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUserByUsername(UserEntity user) {
        jdbcTemplate.update("INSERT INTO users (username, birthday) VALUES (?, ?, ?)", user.getId(), user.getUsername(), user.getBirthday());
    }

    @Override
    public void addUserById(UserEntity user) {
        jdbcTemplate.update("INSERT INTO users (id, birthday) VALUES (?, ?)", user.getId(), user.getBirthday());
    }

    @Override
    public List<UserEntity> getUsers() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(UserEntity.class));
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return jdbcTemplate.queryForObject("SELECT id, username, birthday FROM users WHERE username=?", new Object[]{username},
                new BeanPropertyRowMapper<>(UserEntity.class));
    }

    @Override
    public void updateUserByUsername(String username, UserEntity updateUser) {
        jdbcTemplate.update("UPDATE users SET username=?, birthday=? WHERE username=?", updateUser.getUsername(), updateUser.getBirthday(), username);
    }

    @Override
    public void updateUserById(Long id, UserEntity updateUser) {
        jdbcTemplate.update("UPDATE users SET id=?, birthday=? WHERE id=?", updateUser.getId(), updateUser.getBirthday(), id);
    }

    @Override
    public void deleteUserByUsername(String username) {
        jdbcTemplate.update("DELETE FROM users WHERE username=?", username);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE FROM users");
    }
}
