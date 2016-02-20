package com.kit.hibernate;

/**
 * Created by Eldest on 20.02.2016.
 */
public class Person {
    private Long id;
    private String firstName;
    private String lastName;

    Person(){

    }

    Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
