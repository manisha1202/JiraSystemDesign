package com.manisha.jiraSystem.dao;

import com.manisha.jiraSystem.models.Sprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SprintDaoImpl implements SprintDao{
    List<Sprint> sprintList;

    public SprintDaoImpl(){
        sprintList=new ArrayList<>();
    }
    @Override
    public void addSprint(Sprint sprint) {
        sprintList.add(sprint);
    }

    @Override
    public void deleteSprint(String sprintId) {
        for(Sprint sprint:sprintList){
            if(sprint.getSprintId()==sprintId){
                sprintList.remove(sprintId);
            }
        }
    }

    @Override
    public Sprint getSprint(String sprintId) {
        for(Sprint sprint:sprintList){
            if(sprint.getSprintId()==sprintId){
                return sprint;
            }
        }
        return null;
    }
}
