package com.example.coursemanager.models;

import javax.persistence.Entity;

@Entity
public class Instructor extends User {

    private String salary;

    public Instructor() {
    }

    public Instructor(String name) {
        super(name, "Instructor");
    }
}
