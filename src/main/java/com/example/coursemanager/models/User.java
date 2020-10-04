package com.example.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {

    private @Id @GeneratedValue(strategy= GenerationType.IDENTITY) long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> subscriptions = new ArrayList<>();

    public User(){ } //Empty constructor required by hibernate

    public User(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Course> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
