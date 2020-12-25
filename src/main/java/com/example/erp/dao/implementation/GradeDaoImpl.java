package com.example.erp.dao.implementation;

import com.example.erp.bean.Domains;
import com.example.erp.bean.Grades;
import com.example.erp.dao.DomainDao;
import com.example.erp.dao.GradeDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl implements GradeDao{

    @Override
    public boolean updateGrade(Grades grade) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
//            session.save(course);
            session.saveOrUpdate(grade);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }





    @Override
    public List<Grades> getAllGrades(){
        Session session = SessionUtil.getSession();
        List<Grades> gradesList = new ArrayList<>();
        try {
//
            TypedQuery query = session.createQuery("from Grades ");
            gradesList = query.getResultList();
//            System.out.println(domains.get(1));
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return gradesList;
    }


}
