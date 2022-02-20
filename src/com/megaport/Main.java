package com.megaport;

/**
 * Main class to run command line application.
 */
public class Main {

    /**
     * Main function to process command arguments and pass the file to PersonSorter.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        String filePath = args[0];

        PersonSorter sorter = new PersonSorter();
        sorter.sortFile(filePath);
        sorter.saveFile();
    }
}
