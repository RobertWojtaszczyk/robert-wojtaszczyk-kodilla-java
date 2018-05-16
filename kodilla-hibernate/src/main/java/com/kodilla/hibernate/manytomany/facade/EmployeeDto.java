package com.kodilla.hibernate.manytomany.facade;

public final class EmployeeDto {
    private final int id;
    private final String firstname;
    private final String lastname;

    public EmployeeDto(final int id, final String firstname, final String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}