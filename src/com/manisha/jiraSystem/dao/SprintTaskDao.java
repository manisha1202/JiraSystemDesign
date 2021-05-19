package com.manisha.jiraSystem.dao;

import com.manisha.jiraSystem.models.Sprint;
import com.manisha.jiraSystem.models.Task;

import java.util.List;

public interface SprintTaskDao {
    /**
     * @param task,sprint
     */
    void addTaskToSprint(Task task, Sprint sprint);

    /**
     * @param task,sprint
     */
    void removeTaskFromSprint(Task task, Sprint sprint);

    /**
     * @param sprint
     * @return List of task
     */
    List<Task> getSprintTasks(Sprint sprint);
}
