package com.lhl.springjpa.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lunhengle on 2015/8/15.
 */
@Entity
public class Teacher_student {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "teacher_id")
    private Integer teacher_id;
    @Column(name = "student_id")
    private Integer student_id;

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }
}
