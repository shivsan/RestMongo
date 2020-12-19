package com.sample.mongorest.RestMongo.entity;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private Role role;

    public Employee(String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Employee(String id, String firstName, String lastName, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
