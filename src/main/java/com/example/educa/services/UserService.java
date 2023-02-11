package com.example.educa.services;

import com.example.educa.Entity.User;
import com.example.educa.pojo.UserPojo;

import java.io.IOException;
import java.util.List;

public interface UserService {
    UserPojo save(UserPojo userPojo) throws IOException;

//    void save(User user);
    void login(String username, String password);
//    User findByUsername(String username);
//    User findByEmail(String email);
    User findById(long id);
    User fetchById(Integer id);
    List<User> fetchAll();
    void deleteById(Integer id);
}

