package com.example.springsequrity.dao;

import com.example.springsequrity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
