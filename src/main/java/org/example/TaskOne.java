package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskOne {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Bill", "Peter", "Sam");
        String result = IntStream.range(0, names.size())
                .filter(index  -> index % 2 == 0)
                .mapToObj(index -> index + 1 + ". " + names.get(index))
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}