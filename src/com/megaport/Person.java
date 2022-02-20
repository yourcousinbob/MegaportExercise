package com.megaport;

import java.util.Objects;

/**
 * Represents a person with a first and last name.
 */
public class Person implements Comparable<Person> {
    // Words in a full name
    static final int fullNameLength = 2;
    // Symbol to split full name with
    static final String nameDelimiter = ", ";

    public String firstName;
    public String lastName;

    /**
     * Constructor takes the full name of a person and split it into first and last.
     * @param line The full name of the person.
     */
    public Person(String line) {
        String[] fullName = line.split(nameDelimiter);

        if (fullName.length == fullNameLength &&
                fullName[0].matches("[a-zA-Z]+") &&
                fullName[1].matches("[a-zA-Z]+")) {

            this.lastName = fullName[0];
            this.firstName = fullName[1];
        } else {
            throw new ExceptionInInitializerError("Name not formatted correctly.");
        }
    }

    /**
     * Enables comparison between such that last name and then first name for sorting.
     * @param person another person to compare to.
     * @return 0 if equal, >0 if greater than and <0 if less than other comparison person.
     */
    @Override
    public int compareTo(Person person) {
        if (Objects.equals(this.lastName, person.lastName)) {
            return this.firstName.compareTo(person.firstName);
        }
        return this.lastName.compareTo(person.lastName);
    }

    /**
     * String representation of a person following comma separated last then first name.
     * @return String representation of a person.
     */
    @Override
    public String toString() {
        return this.lastName + nameDelimiter + this.firstName;
    }

    /**
     * Whether another person is equal based on first and last name.
     * @param object other person/object to compare to.
     * @return boolean representing equal or not.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Person person = (Person) object;
        return Objects.equals(this.firstName, person.firstName) && Objects.equals(this.lastName, person.lastName);
    }

    /**
     * Implements a hashcode based on first and last name.
     * @return the hashcode.
     */
    @Override
    public int hashCode() {
        return this.firstName.hashCode() * this.lastName.hashCode();
    }
}
