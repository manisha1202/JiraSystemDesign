package com.manisha.jiraSystem.managers;

import com.manisha.jiraSystem.controllers.TaskFactory;
import com.manisha.jiraSystem.dao.*;
import com.manisha.jiraSystem.enums.TaskType;
import com.manisha.jiraSystem.models.Sprint;
import com.manisha.jiraSystem.models.Story;
import com.manisha.jiraSystem.models.Task;
import com.manisha.jiraSystem.models.User;

import java.util.List;
import java.util.UUID;

public class JiraManager {
    private TaskFactory taskFactory;
    private SprintDao sprintDao;
    private SprintTaskDao sprintTaskDao;
    private TaskDao taskDao;

    public JiraManager(TaskFactory taskFactory,
                       SprintDaoImpl sprintDaoImpl, SprintTaskDaoImpl sprintTaskDaoImpl,
                       TaskDaoImpl taskDaoImpl) {
        this.taskFactory = taskFactory;
        this.sprintDao = sprintDaoImpl;
        this.sprintTaskDao = sprintTaskDaoImpl;
        this.taskDao = taskDaoImpl;
    }

    public String createTask(String summary, int point, User user,
                             String status, String type) {
        Task task = taskFactory.getTask(summary, point, user, status, TaskType.getTaskType(type));
        taskDao.addTask(task);
        System.out.println(task.getTaskId());
        return task.getTaskId();
    }

    public String createSprint(long fromDate, long toDate) {
        Sprint sprint = new Sprint();
        sprint.setSprintId(UUID.randomUUID().toString());
        sprint.setFromDate(fromDate);
        sprint.setToDate(toDate);
        sprintDao.addSprint(sprint);
        return sprint.getSprintId();
    }

    public void addTaskToSprint(String sprintId, String taskId) {
        Sprint sprint = sprintDao.getSprint(sprintId);
        Task task = taskDao.getTask(taskId);
        sprintTaskDao.addTaskToSprint(task, sprint);
    }

    public void removeTaskFromSprint(String sprintId, String taskId) {
        Sprint sprint = sprintDao.getSprint(sprintId);
        Task task = taskDao.getTask(taskId);
        sprintTaskDao.removeTaskFromSprint(task, sprint);
    }

    public List<Task> getDelayedTasks() {
        return null;
    }

    public void getSprintDetails(String sprintId) {
        System.out.println("Sprint details: ");
        Sprint sprint = sprintDao.getSprint(sprintId);
        System.out.println("Sprint duration: " + sprint.getFromDate() + " - " + sprint.getToDate());
        System.out.println("Sprint tasks:-");
        if (sprintTaskDao.getSprintTasks(sprint) != null) {
            System.out.println(sprintTaskDao.getSprintTasks(sprint));
        }
    }

    public void getUserTasks(User user) {
        if (taskDao.getTasksByUser(user) != null) {
            System.out.println(taskDao.getTasksByUser(user));
        }
    }

    public void createSubTask(Task subTask, String storyId) {
        Task task = taskDao.getTask(storyId);
        if (task.getType() != TaskType.STORY) {
            System.out.println("Invalid story id.");
        } else {
            Story story = (Story) task;
            story.addSubTask(subTask);

        }

    }

}
