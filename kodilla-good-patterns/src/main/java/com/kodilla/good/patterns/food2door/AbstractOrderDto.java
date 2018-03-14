package com.kodilla.good.patterns.food2door;

public class AbstractOrderDto {
    private String nameOfSupplier;

    public AbstractOrderDto(String nameOfSupplier) {
        this.nameOfSupplier = nameOfSupplier;
    }

    public String getNameOfSupplier() {
        return nameOfSupplier;
    }
}
