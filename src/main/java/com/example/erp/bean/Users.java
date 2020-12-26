package com.example.erp.bean;


import javax.persistence.*;
import java.util.List;
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer user_id;

    @Column(unique = true)
    private String user_name;
    @Column(nullable = false)
    private Integer role;

    public Users() {
    }
    public Users(Integer user_id, String user_name, Integer role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.role = role;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
