package com.megaport;

import java.util.Objects;

public class Person implements Comparable<Person> {
    public String firstName;
    public String lastName;

    public Person(String line) {
        String[] fullName = line.split(", ");
        if (fullName.length != 2) {
            throw new ExceptionInInitializerError("Name not formatted correctly.");
        }
        this.lastName = fullName[0];
        this.firstName = fullName[1];
    }

    @Override
    public int compareTo(Person person) {
        if (Objects.equals(this.lastName, person.lastName)) {
            return this.firstName.compareTo(person.firstName);
        }
        return this.lastName.compareTo(person.lastName);
    }

    @Override
    public String toString() {
        return this.lastName + ", " + this.firstName;
    }
}
