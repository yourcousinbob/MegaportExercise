package com.megaport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtility <T> {
    private String fileName;

    public List<String> readFile(String path) {
        List<String> items = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            this.fileName = path;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                items.add(line);
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
        return items;
    }

    public void writeFile(List<T> items) {
        if (this.fileName == null) {
            System.err.println("No input file provided");
            return;
        }

        String[] splitFileName = this.fileName.split("[.]");
        File output = new File(splitFileName[0] + "-sorted." + splitFileName[1]);

        try (FileWriter writer = new FileWriter(output.getAbsolutePath())) {
            for (T item:items) {
                writer.write(item.toString() + System.lineSeparator());
            }
        } catch (IOException error) {
            error.printStackTrace();
        }

        System.out.println("Finished: " + output.getName());
    }
}
