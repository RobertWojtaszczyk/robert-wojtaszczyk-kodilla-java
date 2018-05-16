package com.kodilla.hibernate.manytomany.facade;

public final class CompanyDto {
    private final int id;
    private final String name;

    public CompanyDto(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}