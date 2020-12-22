package com.example.erp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "students"})
public class Domains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="domain_id")
    private Integer domain_id;
    @Column(nullable = false)
    private String program;
    @Column(nullable = false)
    private String batch;
    @Column(nullable = false)
    private Integer capacity;
    private String qualification;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "domain")
    private List<Students> students;

    public Domains() {
    }

    public Domains(String program, String batch, Integer capacity, String qualification) {
        this.program = program;
        this.batch = batch;
        this.capacity = capacity;
        this.qualification = qualification;
    }

    public Integer getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Integer domain_id) {
        this.domain_id = domain_id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}

