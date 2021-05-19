package com.manisha.jiraSystem.models;

import com.manisha.jiraSystem.enums.TaskType;

public class Bug extends Task{
    public Bug(String summary, int point, User user, String status, TaskType type) {
        super(summary,point,user,status,type);
    }
}
