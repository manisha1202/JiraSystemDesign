package com.manisha.jiraSystem.models;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }
}
