package com.kodilla.good.patterns.challenges;

public class Item {
    private String name;
    private String description;
    private double unitOfMeasure;

    public Item(final String name, final String description, final double unitOfMeasure) {
        this.name = name;
        this.description = description;
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitOfMeasure() {
        return unitOfMeasure;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitOfMeasure=" + unitOfMeasure +
                '}';
    }
}
