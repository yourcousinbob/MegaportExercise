package com.megaport.test;

import com.megaport.Person;
import com.megaport.PersonSorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonSorterTest {
    PersonSorter personSorter;

    @BeforeEach
    void setUp() {
        personSorter = new PersonSorter();
    }

    @Test
    void sortFileTest() {
        personSorter.sortFile("testfiles/input2.txt");

        List<Person> expectedOrder = List.of(new Person("Eagen, Barry")
                , new Person("Melhem, Bobby")
                , new Person("Melhem, Jada")
                , new Person("Smith, Ben")
                , new Person("Smith, John"));

        List<Person> actualOrder = personSorter.people;

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void blankSortFileTest() {
        assertThrows(ExceptionInInitializerError.class, () -> {
            personSorter.sortFile("testfiles/blank.txt");
        });
    }

    @Test
    void badFormatSortFileTest() {
        assertThrows(ExceptionInInitializerError.class, () -> {
            personSorter.sortFile("testfiles/badFormat.txt");
        });
    }

    @Test
    void saveFileTest() {
        personSorter.sortFile("testfiles/input2.txt");
        personSorter.saveFile();

        try {
            byte[] expectedFile = Files.readAllBytes(Path.of("testfiles/input2-sorted.txt"));
            byte[] actualFile = Files.readAllBytes(Path.of("testfiles/saveFileTest.txt"));
            assertArrayEquals(expectedFile, actualFile);
        } catch (IOException error) {
            error.printStackTrace();
        }

    }
}