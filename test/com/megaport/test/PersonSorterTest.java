package com.megaport.test;

import com.megaport.Person;
import com.megaport.PersonSorter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonSorterTest {
    PersonSorter personSorter;
    private ByteArrayOutputStream testOut;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        personSorter = new PersonSorter();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
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

        String expectedOut = "Eagen, Barry" + System.lineSeparator() +
                "Melhem, Bobby" + System.lineSeparator() +
                "Melhem, Jada" + System.lineSeparator() +
                "Smith, Ben" + System.lineSeparator() +
                "Smith, John" + System.lineSeparator() +
                "Finished: input2-sorted.txt" + System.lineSeparator();
        assertEquals(expectedOut, testOut.toString());
    }
}