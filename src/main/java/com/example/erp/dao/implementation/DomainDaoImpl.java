package com.example.erp.dao.implementation;
import javax.persistence.TypedQuery;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Domains;
import com.example.erp.bean.Students;
import com.example.erp.dao.DomainDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
public class DomainDaoImpl implements DomainDao {
    @Override
    public boolean modifyDomain(Domains domain) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
//            session.save(course);
            session.saveOrUpdate(domain);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Domains> getDomains() {
        Session session = SessionUtil.getSession();
        List<Domains> domainsList = new ArrayList<>();
        try {
//            for (final Object domain : session.createQuery("from Domains ").list()) {
//                domainsList.add((Domains) domain);
//            }
                TypedQuery query = session.createQuery("from Domains ");
                domainsList = query.getResultList();
//            System.out.println(domains.get(1));
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return domainsList;
    }

    @Override
    public List<Students> getStudentsDetails(Domains domain) {
        List<Students> students = new ArrayList<>();
        try (Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from Students where domain.domain_id=:did");
            query.setParameter("did", domain.getDomain_id());
            students = query.list();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return students;
    }
}
