package com.example.coursemanager.models;

import javax.persistence.Entity;

@Entity
public class Student extends User {

    private String joinDate;

    public Student() {
    }

    public Student(String name) {
        super(name, "Student");
    }

}

