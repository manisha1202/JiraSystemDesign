package com.manisha.jiraSystem.dao;

import com.manisha.jiraSystem.models.Sprint;

public interface SprintDao {
    /**
     * @param sprint
     */
    void addSprint(Sprint sprint);

    /**
     *
     * @param sprintId
     */
    void deleteSprint(String sprintId);

    /**
     *
     * @param sprintId
     * @return sprint
     */
    Sprint getSprint(String sprintId);
}
