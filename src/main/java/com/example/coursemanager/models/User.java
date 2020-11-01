package com.example.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {

    private @Id @GeneratedValue(strategy= GenerationType.IDENTITY) long id;
    private String name;
    private String role;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> subscriptions = new ArrayList<>();

    public User(){ } //Empty constructor required by hibernate

    public User(String name, String role) {
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }
}
