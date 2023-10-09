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
            private boolean nextItem = true;
            @Override
            public boolean hasNext() {
                return firstStream.hasNext() && secondStream.hasNext();
            }

            @Override
            public T next() {
                if (nextItem){
                    nextItem = false;
                    return firstStream.next();
                } else {
                    nextItem = true;
                    return secondStream.next();
                }
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(result,
                Spliterator.ORDERED | Spliterator.NONNULL);

        return StreamSupport.stream(spliterator, false);
    }
    public static void main(String[] args) {

    }
}
