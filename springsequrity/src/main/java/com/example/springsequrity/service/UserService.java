package com.example.springsequrity.service;

import com.example.springsequrity.entity.User;

public interface UserService {

    void save(User user);

    User findByUserName(String userName);
}
