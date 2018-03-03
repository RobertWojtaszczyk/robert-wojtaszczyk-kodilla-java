package com.kodilla.good.patterns.food2door;

public final class Product {
    private final String name;
    private final String description;
    private final double unitOfMeasure;
    private final Supplier supplier;

    public Product(final String name, final String description, final double unitOfMeasure, final Supplier supplier) {
        this.name = name;
        this.description = description;
        this.unitOfMeasure = unitOfMeasure;
        this.supplier = supplier;
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

    public Supplier getSupplier() {
        return supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitOfMeasure=" + unitOfMeasure +
                '}';
    }
}
