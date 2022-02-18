package com.megaport.test;

import com.megaport.FileUtility;
import com.megaport.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class FileUtilityTest {
    List<String> input1;
    FileUtility<Person> fileUtility;

    @BeforeEach
    void setUp() {
        fileUtility = new FileUtility<>();
        input1 = new ArrayList<>();
        input1.add("Wieser, Ben");
        input1.add("Melhem, Jada");
        input1.add("Melhem, Bobby");

        List<String> output1 = new ArrayList<>();
    }

    @Test
    void readFileInput1() {
        Assertions.assertEquals(input1, fileUtility.readFile("inputfiles/input1.txt"));
    }


    @Test
    void writeFile() {
    }
}