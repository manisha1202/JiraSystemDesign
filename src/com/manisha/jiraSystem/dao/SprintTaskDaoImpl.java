package com.manisha.jiraSystem.dao;

import com.manisha.jiraSystem.models.Sprint;
import com.manisha.jiraSystem.models.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SprintTaskDaoImpl implements SprintTaskDao{
    HashMap<Sprint, List<Task>> sprintTasks;
    public SprintTaskDaoImpl(){
        sprintTasks=new HashMap<>();
    }

    @Override
    public void addTaskToSprint(Task task, Sprint sprint) {
        if(sprintTasks.containsKey(sprint)){
            sprintTasks.get(sprint).add(task);
        }else{
            List<Task> tasks=new ArrayList<>();
            tasks.add(task);
            sprintTasks.put(sprint,tasks);
        }

    }

    @Override
    public void removeTaskFromSprint(Task task, Sprint sprint) {
        Task temp=null;
        if(sprintTasks.containsKey(sprint)){
            List<Task> tasks=sprintTasks.get(sprint);
            for(Task t:tasks){
                if(t==task){
                    temp=t;
                }
            }
            if(temp!=null){
                tasks.remove(temp);
            }
        }

    }

    @Override
    public List<Task> getSprintTasks(Sprint sprint) {
        if(sprintTasks.containsKey(sprint)){
            return sprintTasks.get(sprint);
        }
        return null;
    }

}
