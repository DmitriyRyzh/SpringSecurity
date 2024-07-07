package com.example.springsequrity.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="MyRoles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="Role")
    private String role;

    @ManyToMany(mappedBy = "MyRoles")
    private Set<User> users;


    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }



}
