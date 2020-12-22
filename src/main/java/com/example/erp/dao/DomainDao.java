package com.example.erp.dao;
import com.example.erp.bean.Domains;
import com.example.erp.bean.Students;

import java.util.List;

public interface DomainDao {

    boolean modifyDomain(Domains domain);
    List<Domains> getDomains();
    List<Students> getStudentsDetails(Domains domain);
}
