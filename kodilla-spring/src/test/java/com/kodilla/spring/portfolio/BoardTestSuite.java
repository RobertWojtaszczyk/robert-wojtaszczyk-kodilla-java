package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.taskAddToDoList("One task to go");
        board.taskAddInProgressList("One task in progress");
        board.taskAddDoneList("One task already done");
        //Then
        Assert.assertEquals("One task to go", board.getToDoList().getTasks().get(0));
        Assert.assertEquals("One task in progress", board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("One task already done", board.getDoneList().getTasks().get(0));
    }
}
