package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Testing Hibernate";

    @Test
    public void testTaskListDaoSave() {
        //Given
        TaskList taskList = new TaskList("First List", DESCRIPTION);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        TaskList readTaskList = taskListDao.findOne(id);
        Assert.assertEquals(id, readTaskList.getId());

        //CleanUp
        taskListDao.delete(id);

    }
    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("Second List", DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();

        //When
        List<TaskList> readTaskList = taskListDao.findByListName(listName);

        //Then
        Assert.assertEquals(1, readTaskList.size());

        //CleanUp
        taskListDao.delete(readTaskList);

    }
}