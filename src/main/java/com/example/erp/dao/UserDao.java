package com.example.erp.dao;


import com.example.erp.bean.Grades;
import com.example.erp.bean.Users;

import java.util.List;

public interface UserDao {
    Users verifyUserName(Users user);
}
