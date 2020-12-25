package com.example.erp.dao;

import com.example.erp.bean.Domains;
import com.example.erp.bean.Grades;

import java.util.List;

public interface GradeDao {
    List<Grades> getAllGrades();
    boolean updateGrade(Grades grade);
    boolean addGrade(Grades grade);
}
