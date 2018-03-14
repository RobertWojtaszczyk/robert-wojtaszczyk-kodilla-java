package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.makeTask(TaskFactory.SHOPPING);
        task.executeTask();
        //Then
        Assert.assertTrue(task.isTaskExecuted());
        Assert.assertEquals("Shopping", task.getTaskName());
    }

    @Test
    public void testDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.makeTask(TaskFactory.DRIVING);
        task.executeTask();
        //Then
        Assert.assertTrue(task.isTaskExecuted());
        Assert.assertEquals("Driving", task.getTaskName());
    }

    @Test
    public void testPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.makeTask(TaskFactory.PAINTING);
        task.executeTask();
        //Then
        Assert.assertTrue(task.isTaskExecuted());
        Assert.assertEquals("Painting", task.getTaskName());
    }
}