package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskTwo {
    public static void main(String[] args) {
        Stream<String> names = Stream.of("John", "Bill", "Peter", "Sam")
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder());

        List<String> result = names.collect(Collectors.toList());
        System.out.println(result);
    }
}