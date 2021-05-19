package com.manisha.jiraSystem.dao;

import com.manisha.jiraSystem.models.Task;
import com.manisha.jiraSystem.models.User;

import java.util.List;

public interface TaskDao {

    /**
     * @param task
     */
    void addTask(Task task);

    /**
     * @param taskId
     */
    void deleteTask(String taskId);

    /**
     * @param taskId
     */
    Task getTask(String taskId);

    /**
     * @param user
     * @return List of Task
     */
    List<Task> getTasksByUser(User user);
}
