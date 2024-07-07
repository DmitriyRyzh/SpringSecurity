package com.example.springsequrity.dao;

import com.example.springsequrity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUserName(String userName);

}
