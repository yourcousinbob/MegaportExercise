package com.megaport.test;

import com.megaport.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person1, person2;

    @BeforeEach
    void setUp() {
        person1 = new Person("Melhem, Bobby");
        person2 = new Person("Melhem, Jada");
    }

    @Test
    void constructorFirstNameTest() {
        String expectedFirstName = "Bobby";
        String actualFirstName = person1.firstName;

        assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    void constructorLastNameTest() {
        String expectedLastName = "Melhem";
        String actualLastName = person1.lastName;

        assertEquals(expectedLastName, actualLastName);
    }

    @Test
    void constructorBadCharacters() {
        String badName = "Melhem, B0B";

        assertThrows(ExceptionInInitializerError.class, () -> {
            new Person(badName);
        });
    }

    @Test
    void constructorNoDelim() {
        String badName = "MelhemBobby";

        assertThrows(ExceptionInInitializerError.class, () -> {
            new Person(badName);
        });
    }

    @Test
    void constructorExtraDelim() {
        String badName = "Melhem, Jackson, Bobby";

        assertThrows(ExceptionInInitializerError.class, () -> {
            new Person(badName);
        });
    }

    @Test
    void sameCompareToTest() {
        Person duplicate = new Person("Melhem, Bobby");
        assertTrue(person1.equals(duplicate) && duplicate.equals(person1));
        assertEquals(person1.hashCode(), duplicate.hashCode());
    }

    @Test
    void differentCompareToTest() {
        assertFalse(person1.equals(person2) && person2.equals(person1));
        assertNotEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "Melhem, Bobby";
        String actualString = person1.toString();

        assertEquals(expectedString, actualString);
    }
}