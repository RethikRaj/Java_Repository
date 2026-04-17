package p15_Streams;

import java.util.List;
import java.util.Arrays;
import java.util.stream.*;

public class StreamSource {
    public static void main(String[] args) {
            // 1. From a Collection
            List<Integer> numbers = List.of(1, 2, 3, 4, 4, 5, 66, 6, 7);
            Stream<Integer> s1 = numbers.stream();

            // 2. From Arrays
            int[] primitiveArr = {1, 2, 3, 4, 45, 6, 7};
            IntStream s2 = Arrays.stream(primitiveArr);

            Integer[] objectArr = {1, 2, 3, 34};
            Stream<Integer> s3 = Arrays.stream(objectArr);

            // 3. Stream.of()
            Stream<Double> s4 = Stream.of(2.3, 3.0, 5.746);

            // 4. Infinite Streams

            // 4a. Stream.iterate() — generates: 7, 8, 9 ... (unbounded) , we should bound it with limit
            Stream.iterate(7, x -> x + 1)
            .limit(10)
            .forEach(System.out::println);

            // 4b. Stream.iterate() with predicate (Java 9+) — stops at 17
            Stream.iterate(7, x -> x < 17, x -> x + 1)
            .forEach(System.out::println);

            // 4c. Stream.generate() — generates random doubles
            Stream.generate(Math::random)
            .limit(5)
            .forEach(System.out::println);

            // 5. Empty Stream
            Stream<Integer> empty = Stream.empty();

            // 6. Primitive Streams
            IntStream    s8  = IntStream.of(1, 2, 3);
            DoubleStream s9  = DoubleStream.of(1.1, 1.2, 3.4, 2.5);
            LongStream   s10 = LongStream.of(1_233_444, 123, 1);

            // 6a. IntStream range shortcuts
            IntStream range       = IntStream.range(1, 10);       // 1 to 9
            IntStream rangeClosed = IntStream.rangeClosed(1, 10); // 1 to 10

            // 7. From a String
            IntStream chars = "hello".chars();

            // 8. Stream.builder()
            Stream<String> built = Stream.<String>builder()
                                          .add("A")
                                          .add("B")
                                          .add("C")
                                          .build();

            // 9. Parallel Stream
            Stream<Integer> parallel = numbers.parallelStream();
    }
}