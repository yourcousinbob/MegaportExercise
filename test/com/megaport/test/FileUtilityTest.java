package com.megaport.test;

import com.megaport.FileUtility;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

class FileUtilityTest {
    private FileUtility fileUtility;
    private List<String> names;
    private ByteArrayOutputStream testError;
    private PrintStream originalError;

    @BeforeEach
    void setUp() {
        originalError = System.err;
        testError = new ByteArrayOutputStream();
        System.setErr(new PrintStream(testError));

        fileUtility = new FileUtility();
        names = new ArrayList<>();
        names.add("Wieser, Ben");
        names.add("Melhem, Jada");
        names.add("Melhem, Bobby");
    }

    @AfterEach
    public void restoreStreams() {
        System.setErr(originalError);
    }

    @Test
    void readFileTest() {
        List<String> actualNames = fileUtility.readFile("testfiles/input1.txt");

        assertEquals(names, actualNames);
    }

    @Test
    void readMissingFileTest() {
        fileUtility.readFile("missing.txt");
        String expectedError = "Could not read file missing.txt" + System.lineSeparator();
        assertEquals(expectedError, testError.toString());
    }

    @Test
    void writeFileTest() {
        fileUtility.writeFile("testfiles/fileUtilTest.txt", names);

        try {
            byte[] expectedFile = Files.readAllBytes(Path.of("testfiles/input1.txt"));
            byte[] actualFile = Files.readAllBytes(Path.of("testfiles/fileUtilTest.txt"));
            assertArrayEquals(expectedFile, actualFile);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    @Test
    void writeMissingFileTest() {
        fileUtility.writeFile(null, List.of("Melhem, Bobby"));
        String expectedError = "No path provided." + System.lineSeparator();
        assertEquals(expectedError, testError.toString());
    }
}