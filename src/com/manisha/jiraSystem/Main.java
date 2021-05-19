package com.manisha.jiraSystem;

import com.manisha.jiraSystem.controllers.TaskFactory;
import com.manisha.jiraSystem.dao.SprintDaoImpl;
import com.manisha.jiraSystem.dao.SprintTaskDaoImpl;
import com.manisha.jiraSystem.dao.TaskDaoImpl;
import com.manisha.jiraSystem.managers.JiraManager;
import com.manisha.jiraSystem.models.User;

public class Main {

    public static void main(String[] args) {
        // write your code here
        TaskFactory taskFactory = new TaskFactory();
        SprintDaoImpl sprintDao = new SprintDaoImpl();
        SprintTaskDaoImpl sprintTaskDao = new SprintTaskDaoImpl();
        TaskDaoImpl taskDao = new TaskDaoImpl();
        JiraManager jiraManager = new JiraManager(taskFactory, sprintDao,
                sprintTaskDao, taskDao);
        String sprintId = jiraManager.createSprint(01012021, 14012021);
        User user = new User("Manisha");
        String taskId = jiraManager.createTask("Add first task", 3, user, "IceBox", "story");
        jiraManager.addTaskToSprint(sprintId, taskId);
        jiraManager.getSprintDetails(sprintId);
        jiraManager.getUserTasks(user);
        jiraManager.removeTaskFromSprint(sprintId, taskId);
        jiraManager.getSprintDetails(sprintId);
    }
}
