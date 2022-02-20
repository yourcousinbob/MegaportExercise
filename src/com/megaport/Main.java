package com.megaport;

/**
 * Main class to run command line application.
 */
public class Main {

    /**
     * Main function to process command arguments and pass the file to PersonSorter.
     * @param args command line arguments.
     * @throws Exception Incorrect usage of command line args.
     */
    public static void main(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Proper Usage is: java program filepath");
        }
        String filePath = args[0];

        PersonSorter sorter = new PersonSorter();
        sorter.sortFile(filePath);
        sorter.saveFile();
    }
}
