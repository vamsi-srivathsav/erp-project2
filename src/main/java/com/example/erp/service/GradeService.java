package com.example.erp.service;

import com.example.erp.bean.Grades;

import java.util.List;

import com.example.erp.dao.DomainDao;
import com.example.erp.dao.GradeDao;
import com.example.erp.dao.implementation.DomainDaoImpl;
import com.example.erp.dao.implementation.GradeDaoImpl;

public class GradeService {
    GradeDao gradeDao = new GradeDaoImpl();

    public List<Grades> getAllGrades() {
//        GradeDao gradeDao = new GradeDao();

//        return gradeDao.getAllGrades();
        return gradeDao.getAllGrades();
    }
    public boolean updateGrade(Grades grade){

        return gradeDao.updateGrade(grade);
    }
}