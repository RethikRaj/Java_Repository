package p15_Streams;

import java.util.stream.*;

public class StreamConversions {
    public static void main(String[] args) {

        // 1. Stream<T> → Primitive Stream
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4);
        IntStream s2 = s1.mapToInt(Integer::intValue);

        // 2. Primitive Stream → Stream<T>
        // 2.1 ) Boxed : Wraps each primitive into its wrapper type  ( No transformations )
        IntStream s3 = IntStream.of(1,2,3,4);
        Stream<Integer> boxed = s3.boxed(); 
        // .boxed is just a shortcut == .mapToObj(Integer::valueOf)

        Stream<Long> long_boxed = LongStream.of(1L, 2L).boxed();  // Stream<Long>
        Stream<Double> double_boxed = DoubleStream.of(1.1).boxed();   // Stream<Double>

        // 2.2) MapToObj : Converts each primitive to any object type you want — full transformation.
        Stream<String> labeled = IntStream.of(1, 2, 3).mapToObj(x -> "num:" + x); // Stream<String>
        Stream<Boolean> isEven = IntStream.of(1, 2, 3).mapToObj(x -> x % 2 == 0);  // Stream<Boolean>

        // 3 ) Primitive Streams to other primitive streams
        // 3.1) IntStream → LongStream / DoubleStream  (use asXxxStream for simple widening)
        LongStream   longs   = IntStream.of(1, 2, 3, 4).asLongStream();
        DoubleStream doubles = IntStream.of(1, 2, 3, 4).asDoubleStream();

        // 3.2) IntStream → LongStream / DoubleStream  (use mapToXxx for transformations)
        LongStream   mappedLong   = IntStream.of(1, 2, 3, 4).mapToLong(x -> x * 100L);
        DoubleStream mappedDouble = IntStream.of(1, 2, 3, 4).mapToDouble(x -> x * 1.5);

        // 3.3) LongStream → DoubleStream
        DoubleStream fromLong = LongStream.of(1L, 2L, 3L).asDoubleStream();

        // 3.4) DoubleStream → LongStream (needs explicit cast)
        LongStream fromDouble = DoubleStream.of(1.9, 2.7, 3.1).mapToLong(x -> (long) x);

        // --- print to verify ---
        System.out.println("=== boxed ===");
        boxed.forEach(System.out::println);

        System.out.println("=== labeled ===");
        labeled.forEach(System.out::println);

        System.out.println("=== longs ===");
        longs.forEach(System.out::println);

        System.out.println("=== doubles ===");
        doubles.forEach(System.out::println);

        System.out.println("=== mappedLong ===");
        mappedLong.forEach(System.out::println);

        System.out.println("=== mappedDouble ===");
        mappedDouble.forEach(System.out::println);

        System.out.println("=== fromLong ===");
        fromLong.forEach(System.out::println);

        System.out.println("=== fromDouble (truncated) ===");
        fromDouble.forEach(System.out::println);
    }
}