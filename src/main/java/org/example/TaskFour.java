package org.example;

import java.util.stream.Stream;

public class TaskFour {
    public static Stream<Long> generate(long a, long c, long m, long seed){
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = System.currentTimeMillis();

        Stream<Long> randomStream = generate(a, c, m, seed);
        randomStream.limit(10)
                .forEach(System.out::println);
    }
}
