package com.manisha.jiraSystem.enums;

public enum TaskType {
    STORY("story"),
    FEATURE("feature"),
    BUG("bug");
    String type;

    TaskType(String type) {
        this.type = type;
    }

    public static TaskType getTaskType(String s) {
        for (TaskType taskType : values()) {
            if (taskType.type.equals(s)) {
                return taskType;
            }
        }
        return null;
    }
}
