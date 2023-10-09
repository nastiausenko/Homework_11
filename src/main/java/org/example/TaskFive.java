package org.example;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TaskFive {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Iterator<T> firstStream = first.iterator();
        Iterator<T> secondStream = second.iterator();

        Iterator<T> result = new Iterator<>() {
            private boolean useFirst = true;
            @Override
            public boolean hasNext() {
                return firstStream.hasNext() && secondStream.hasNext();
            }

            @Override
            public T next() {
                if (useFirst){
                    useFirst = false;
                    return firstStream.next();
                } else {
                    useFirst = true;
                    return secondStream.next();
                }
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(result,
                Spliterator.ORDERED | Spliterator.NONNULL);

        return StreamSupport.stream(spliterator, false);
    }
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 2, 3, 4, 5, 6, 7);
        Stream<Integer> second = Stream.of(20, 13, 15);

        Stream<Integer> result = zip(first, second);

        result.forEach(System.out::println);
    }
}
