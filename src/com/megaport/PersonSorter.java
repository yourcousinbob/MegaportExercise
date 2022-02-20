package com.megaport;

import java.io.File;
import java.util.List;

/**
 * Handles the sorting and saving of the people.
 */
public class PersonSorter {
    private final FileUtility fileUtility;
    public String fileName;
    public List<Person> people;

    /**
     * Creates the fileUtility for the person sorter.
     */
    public PersonSorter() {
        this.fileUtility = new FileUtility();
    }

    /**
     * Sorts the given file and updates the people list.
     * @param path the file path with people to sort.
     */
    public void sortFile(String path) {
        this.fileName = path;
        List<String> inputText = this.fileUtility.readFile(this.fileName);
        this.people = inputText.stream().map(Person::new).sorted().toList();
    }

    /**
     * Saves the current list of people to a separate sorted file.
     */
    public void saveFile() {
        if (this.fileName == null) {
            System.err.println("No input file provided.");
            return;
        }

        this.people.forEach(System.out::println);

        String trimFileName = this.fileName.substring(0, this.fileName.length() - 4);
        File output = new File(trimFileName + "-sorted.txt");
        System.out.println("Finished: " + output.getName());

        List<String> outputText = this.people.stream().map(Person::toString).toList();
        this.fileUtility.writeFile(output.getAbsolutePath(), outputText);
    }
}
