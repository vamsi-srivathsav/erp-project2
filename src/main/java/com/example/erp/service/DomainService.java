package com.example.erp.service;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Domains;
import com.example.erp.bean.Students;
import com.example.erp.dao.DomainDao;
import com.example.erp.dao.implementation.DomainDaoImpl;

import java.util.List;

public class DomainService {
    DomainDao domainDao = new DomainDaoImpl();

    public boolean modifyDomain(Domains domain){
        return domainDao.modifyDomain(domain);
    }

    public List<Domains> getDomains (){

        return domainDao.getDomains();
    }

    public List<Students> getStudentsDetails(Domains domain){
        return domainDao.getStudentsDetails(domain);
    }

}
