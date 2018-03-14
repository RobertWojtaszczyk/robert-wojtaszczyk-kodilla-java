package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask(final String taskToExecute) {
        switch (taskToExecute) {
            case DRIVING:
                return new DrivingTask("Driving", "Shop", "Car");
            case PAINTING:
                return new PaintingTask("Painting", "Green", "Bedroom");
            case SHOPPING:
                return new ShoppingTask("Shopping", "Paint", 5);
            default:
                return null;
        }
    }
}