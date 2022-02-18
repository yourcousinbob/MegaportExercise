package com.megaport;

import java.util.List;

public class PersonSorter {

    public static void main(String[] args) throws Exception {
        FileUtility<Person> fileUtility = new FileUtility<>();

        if (args.length != 1) {
            throw new Exception("Proper Usage is: java program filename");
        }
        List<String> text = fileUtility.readFile(args[0]);

        List<Person> people = text.stream().map(Person::new).sorted().toList();
        people.forEach(System.out::println);
        fileUtility.writeFile(people);
    }
}
