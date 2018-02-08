package com.kodilla.testing.shape;

public class Circle implements Shape {
    private double r;
    public Circle(double r) {
        this.r = r;
    }
    @Override
    public String getShapeName() {
        return "Circle";
    }
    @Override
    public Double getField() {
        return 3.14 * r * r;
    }
}
