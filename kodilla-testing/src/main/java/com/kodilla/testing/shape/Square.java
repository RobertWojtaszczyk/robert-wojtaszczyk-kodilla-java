package com.kodilla.testing.shape;

public class Square implements Shape {
    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public Double getField() {
        return 5.5;
    }
}
