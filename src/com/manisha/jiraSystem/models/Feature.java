package com.manisha.jiraSystem.models;

import com.manisha.jiraSystem.enums.TaskType;

public class Feature extends Task {
    public Feature(String summary, int point, User user, String status, TaskType type) {
        super(summary, point, user, status, type);
    }
}
