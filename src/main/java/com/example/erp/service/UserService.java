package com.example.erp.service;
import com.example.erp.bean.Grades;
import com.example.erp.bean.Users;

import java.util.List;

import com.example.erp.dao.UserDao;
import com.example.erp.dao.implementation.UserDaoImpl;
public class UserService {
    UserDao userDao = new UserDaoImpl();


    public Users verifyUserName(Users user){

        return userDao.verifyUserName(user);
    }
}
