package com.manisha.jiraSystem.models;

import com.manisha.jiraSystem.enums.TaskType;

import java.util.ArrayList;
import java.util.List;

public class Story extends Task {
    List<Task> subtasks = new ArrayList<>();

    public Story(String summary, int point, User user, String status, TaskType type) {
        super(summary, point, user, status, type);
    }

    public void addSubTask(Task task) {
        subtasks.add(task);
    }

    public void deleteSubTask(Task task) {
        for (Task t : subtasks) {
            if (t == task) {
                subtasks.remove(task);
            }
        }
    }
}
