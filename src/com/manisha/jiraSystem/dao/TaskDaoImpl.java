package com.manisha.jiraSystem.dao;

import com.manisha.jiraSystem.models.Task;
import com.manisha.jiraSystem.models.User;

import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements TaskDao {
    List<Task> taskList;

    public TaskDaoImpl() {
        this.taskList = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public void deleteTask(String taskId) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                taskList.remove(taskId);
            }
        }
    }

    @Override
    public Task getTask(String taskId) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    @Override
    public List<Task> getTasksByUser(User user) {
        List<Task> tasks=new ArrayList<>();
        for(Task task:taskList){
            if(task.getUser()==user){
                tasks.add(task);
            }
        }
        return tasks;
    }
}
