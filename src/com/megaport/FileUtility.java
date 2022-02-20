package com.megaport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tool for reading and writing to files segmenting by line.
 */
public class FileUtility {

    /**
     * Read a files contents and store it line by line in a list.
     * @param path The path of the file to be read.
     * @return The list of lines in the file.
     */
    public List<String> readFile(String path) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException error) {
            System.err.println("Could not read file " + path);
            return null;
        }

        return lines;
    }

    /**
     * Write/create the desired file with each element of the list corresponding to a line.
     * @param path The path to save the file under.
     * @param lines The content to write to file split into lines.
     */
    public void writeFile(String path, List<String> lines) {
        if (path == null) {
            System.err.println("No path provided.");
            return;
        }

        try (FileWriter writer = new FileWriter(path)) {
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException error) {
            System.err.println("Could not write to file" + path);
        }
    }
}
