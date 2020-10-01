package com.example.coursemanager.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    private @Id @GeneratedValue(strategy= GenerationType.IDENTITY) long id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
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
