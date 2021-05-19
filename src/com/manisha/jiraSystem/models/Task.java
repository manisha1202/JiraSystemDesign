package com.manisha.jiraSystem.models;

import com.manisha.jiraSystem.enums.TaskType;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public abstract class Task {
    String taskId;
    String summary;
    int point;
    User user;
    List<Sprint> sprints;
    String status;
    TaskType type;

    public Task(String summary, int point, User user, String status, TaskType type) {
        this.taskId = UUID.randomUUID().toString();
        this.summary = summary;
        this.point = point;
        this.user = user;
        this.status = status;
        this.type = type;
    }
}
