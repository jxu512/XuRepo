package com.example.springjdbc;

public class Company {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    private String location;
    private int numberOfEmployees;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String toString() {
        return "Name:" + name + ", localtion:" + location + ", employees:" + numberOfEmployees;
    }
}
