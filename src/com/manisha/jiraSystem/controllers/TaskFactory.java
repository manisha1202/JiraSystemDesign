package com.manisha.jiraSystem.controllers;

import com.manisha.jiraSystem.enums.TaskType;
import com.manisha.jiraSystem.models.*;

public class TaskFactory {

    public Task getTask(String summary, int point, User user, String status, TaskType type) {
        if (type == TaskType.BUG) {
            return new Bug(summary, point, user, status, type);
        } else if (type == TaskType.FEATURE) {
            return new Feature(summary, point, user, status, type);
        } else if (type == TaskType.STORY) {
            return new Story(summary, point, user, status, type);
        }
        return null;
    }

}
