package com.example.erp.bean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
@Entity
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="grade_id")
    private Integer grade_id;

    @Column(unique = true)
    private String letter_grade;
    @Column(nullable = false)
    private String grade_points;

    private String comment;

    public Grades(){

    }
    public Grades(Integer grade_id, String letter_grade, String grade_points, String comment) {
        this.grade_id = grade_id;
        this.letter_grade = letter_grade;
        this.grade_points = grade_points;
        this.comment = comment;
    }

    public Integer getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Integer grade_id) {
        this.grade_id = grade_id;
    }

    public String getLetter_grade() {
        return letter_grade;
    }

    public void setLetter_grade(String letter_grade) {
        this.letter_grade = letter_grade;
    }

    public String getGrade_points() {
        return grade_points;
    }

    public void setGrade_points(String grade_points) {
        this.grade_points = grade_points;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
