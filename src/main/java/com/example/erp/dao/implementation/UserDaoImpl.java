package com.example.erp.dao.implementation;


import com.example.erp.bean.Grades;
import com.example.erp.bean.Students;
import com.example.erp.bean.Users;

import com.example.erp.dao.UserDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public Users verifyUserName(Users user) {
        try (Session session = SessionUtil.getSession()) {
            System.out.println("===============in verifyusername doaimply============");
            Query query = session.createQuery("from Users where user_name=:uname and role=:urole");
            query.setParameter("uname", (String)user.getUser_name());
            query.setParameter("urole", (Integer)user.getRole());
            List<Users> fetchedUser = new ArrayList<>();
            fetchedUser = query.list();
            for (final Object fetch : query.list()) {
                Users curU = (Users) fetch;
                System.out.println(curU.getUser_id());
                System.out.println(curU.getUser_name());
                System.out.println(curU.getRole());
                return (Users) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

}
