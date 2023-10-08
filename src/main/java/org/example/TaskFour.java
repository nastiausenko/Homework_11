package org.example;

import java.util.stream.Stream;

public class TaskFour {
    public Stream<Long> generate(long a, long c, long m, long seed){
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {

    }
}
