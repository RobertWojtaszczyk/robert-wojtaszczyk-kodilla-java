package com.kodilla.spring.portfolio;

public final class Board {
    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    public void taskAddToDoList(String task) {
        getToDoList().getTasks().add(task);
    }

    public void taskAddInProgressList(String task) {
        getInProgressList().getTasks().add(task);
    }

    public void taskAddDoneList(String task) {
        getDoneList().getTasks().add(task);
    }
}
