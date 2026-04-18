package p15_Streams;

import java.util.*;
import java.util.stream.*;

public class TerminalOperationsDemo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 13, 11, 9, 4, 13); // has a duplicate 13

        System.out.println("Original List: " + numbers);
        System.out.println("=".repeat(55));

        // ─────────────────────────────────────────────────────────
        // 1. forEach(Consumer c) → Iterates over each element.
        // ─────────────────────────────────────────────────────────
        System.out.println("\n1. forEach()");
        System.out.println("   Printing each element after doubling:");

        numbers.stream()
               .map(x -> x * 2)
               .forEach(x -> System.out.print(x + " "));

        System.out.println();

        // ─────────────────────────────────────────────────────────
        // 2. forEachOrdered()
        //    → Same as forEach() for sequential streams.
        //    → Guarantees encounter order — mainly useful in parallel streams where order can get scrambled.
        // ─────────────────────────────────────────────────────────
        System.out.println("\n2. forEachOrdered()");
        System.out.println("   Same output as forEach() on sequential streams:");

        numbers.stream()
               .map(x -> x * 2)
               .forEachOrdered(x -> System.out.print(x + " "));

        System.out.println();

        // ─────────────────────────────────────────────────────────
        // 3. toList()
        //    → Collects stream into an IMMUTABLE list.
        //    → Therefore we cannot add/remove from it — throws UnsupportedOperationException at runtime!
        // ─────────────────────────────────────────────────────────
        System.out.println("\n3. toList()");

        List<Integer> immutableList = numbers.stream()
                                             .filter(x -> x > 5)
                                             .toList();
        System.out.println("   Filtered (> 5) into immutable list: " + immutableList);

        // ─────────────────────────────────────────────────────────
        // 4. collect(Collector c) 
        // ─────────────────────────────────────────────────────────
        System.out.println("\n4. collect()  [quick taste — full demo in CollectorsDemo.java]");

        List<Integer> mutableList = numbers.stream()
                                           .filter(x -> x > 5)
                                           .collect(Collectors.toList()); // mutable!

        mutableList.add(99); // ✅ works because it's mutable
        System.out.println("   Collected into mutable list, then added 99: " + mutableList);

        Set<Integer> asSet = numbers.stream()
                                    .filter(x -> x > 5)
                                    .collect(Collectors.toSet()); // duplicates removed

        System.out.println("   Collected into Set (no duplicates): " + asSet);

        // ─────────────────────────────────────────────────────────
        // 5. long count() → Returns the NUMBER of elements that passed through.
        // ─────────────────────────────────────────────────────────
        System.out.println("\n5. count()");

        long count = numbers.stream()
                            .filter(x -> x > 10)
                            .count();

        System.out.println("   Elements greater than 10: " + count); // 13, 11, 13 → 3

        // ─────────────────────────────────────────────────────────
        // 6. reduce() → Combines ALL elements into ONE single value using a BinaryOperator.
        //    Variant A: with identity (base value) → returns T directly
        //    Variant B: without identity            → returns Optional<T>
        // ─────────────────────────────────────────────────────────
        System.out.println("\n6. reduce()");

        // Variant A — with identity (0 is the base; everything adds onto it)
        int sumWithIdentity = numbers.stream()
                                     .reduce(0, (a, b) -> a + b);

        System.out.println("   Sum (with identity 0): " + sumWithIdentity); // 1+13+11+9+4+13 = 51

        // Variant B — without identity → returns Optional (safe for empty streams)
        Optional<Integer> sumOptional = numbers.stream()
                                               .reduce((a, b) -> a + b);

        System.out.println("   Sum (without identity, via Optional): " + sumOptional.orElse(0)); // 51

        // ─────────────────────────────────────────────────────────
        // 7. Primitive Stream operations: sum(), max(), min(), average()
        //    → These do NOT exist on Stream<Integer>.
        //    → Must convert using mapToInt() / mapToLong() / mapToDouble() to get an IntStream / LongStream / DoubleStream.
        //    → Why? Avoids repeated boxing/unboxing overhead.
        // ─────────────────────────────────────────────────────────
        System.out.println("\n7. Primitive Stream ops — sum(), max(), min(), average()");
        System.out.println("   (Must use mapToInt() first to get an IntStream)");

        // sum()
        int sum = numbers.stream()
                         .filter(x -> x > 10)
                         .mapToInt(x -> x)
                         .sum();

        System.out.println("   sum() of elements > 10  → " + sum); // 13+11+13 = 37

        // max()
        OptionalInt max = numbers.stream()
                                 .filter(x -> x > 10)
                                 .mapToInt(x -> x)
                                 .max();

        System.out.println("   max() of elements > 10  → " + max.getAsInt()); // 13

        // min()
        OptionalInt min = numbers.stream()
                                 .filter(x -> x > 10)
                                 .mapToInt(x -> x)
                                 .min();

        System.out.println("   min() of elements > 10  → " + min.getAsInt()); // 11

        // average()
        OptionalDouble avg = numbers.stream()
                                    .filter(x -> x > 10)
                                    .mapToInt(x -> x)
                                    .average();

        System.out.println("   average() of elements > 10 → " + avg.getAsDouble()); // (13+11+13)/3 = 12.33...

        // ─────────────────────────────────────────────────────────
        // 8. findFirst()
        //    → Returns the FIRST element that reaches this point.
        //    → Short-circuits — stream stops as soon as one is found.
        //    → Returns Optional<T> . Why Optional ? Because there might not be an element which passes all conditions
        // ─────────────────────────────────────────────────────────
        System.out.println("\n8. findFirst()");

        Optional<Integer> first = numbers.stream()
                                         .filter(x -> x > 10)
                                         .findFirst();

        System.out.println("   First element > 10: " + first.get()); // 13 (stream stops here)

        // ─────────────────────────────────────────────────────────
        // 9. findAny()
        //    → Returns ANY one element that passes the filters.
        //    → Same as findFirst() on sequential streams.
        //    → Real advantage shows in PARALLEL streams — no orderingconstraint means it can return whichever thread finishes first, making it faster.
        //    → Returns Optional<T>
        // ─────────────────────────────────────────────────────────
        System.out.println("\n9. findAny()");

        Optional<Integer> any = numbers.stream()
                                       .filter(x -> x > 10)
                                       .findAny();

        System.out.println("   Any element > 10: " + any.get()); // likely 13 (sequential)
        System.out.println("   ℹ In parallel streams, result could differ — that's where findAny() shines.");

        // ─────────────────────────────────────────────────────────
        // 10. anyMatch()
        //     → Returns TRUE if AT LEAST ONE element matches the predicate.
        //     → Short-circuits as soon as the first match is found.
        // ─────────────────────────────────────────────────────────
        System.out.println("\n10. anyMatch()");

        boolean anyMatch = numbers.stream()
                                  .filter(x -> x > 10)
                                  .anyMatch(x -> x % 2 == 0); // any even among > 10?

        System.out.println("   Any even number among elements > 10? → " + anyMatch); // false (13, 11, 13 are all odd)

        // ─────────────────────────────────────────────────────────
        // 11. allMatch()
        //     → Returns TRUE only if EVERY element matches.
        //     → Short-circuits as soon as the FIRST non-match is found.
        // ─────────────────────────────────────────────────────────
        System.out.println("\n11. allMatch()");

        boolean allMatch = numbers.stream()
                                  .filter(x -> x > 10)
                                  .allMatch(x -> x % 2 == 0); // all even among > 10?

        System.out.println("   All even numbers among elements > 10? → " + allMatch); // false

        boolean allAboveFive = numbers.stream()
                                      .allMatch(x -> x > 0); // all positive?

        System.out.println("   All elements > 0? → " + allAboveFive); // true

        // ─────────────────────────────────────────────────────────
        // 12. noneMatch()
        //     → Returns TRUE if NO element matches the predicate.
        //     → i.e., the predicate must be false for every element.
        // ─────────────────────────────────────────────────────────
        System.out.println("\n12. noneMatch()");

        boolean noneMatch = numbers.stream()
                                   .filter(x -> x > 10)
                                   .noneMatch(x -> x % 2 == 0); // none of them even?

        System.out.println("   None of elements > 10 are even? → " + noneMatch); // true (13, 11, 13 — all odd)

        System.out.println("\n" + "=".repeat(55));
    }
}