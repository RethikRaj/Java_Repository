package p15_Streams;

import java.util.*;
import java.util.stream.*;

public class StreamIntermediateOps {

    public static void main(String[] args) {

        // ─────────────────────────────────────────────
        // Base data used across most demos
        // ─────────────────────────────────────────────
        List<Integer> numbers = List.of(1, 13, 11, 9, 34, 13, 34, 5, 7);
        List<String>  words   = List.of("banana", "apple", "cherry", "avocado", "blueberry", "apricot");

        separator("SOURCE DATA");
        System.out.println("numbers : " + numbers);
        System.out.println("words   : " + words);

        // ─────────────────────────────────────────────
        // 1. filter()
        //    Passes only elements that satisfy a Predicate.
        //    Stateless — each element is tested independently.
        // ─────────────────────────────────────────────
        separator("1. filter()");

        System.out.print("Numbers > 5 AND even        : ");
        numbers.stream()
               .filter(x -> x > 5)
               .filter(x -> x % 2 == 0)
               .forEach(x -> System.out.print(x + " "));
        System.out.println();


        // ─────────────────────────────────────────────
        // 2. map()
        //    Transforms every element (T → R).
        //    Stateless — each element is transformed independently.
        // ─────────────────────────────────────────────
        separator("2. map()");

        System.out.print("Each number doubled         : ");
        numbers.stream()
               .map(x -> x * 2)
               .forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.print("Words → their lengths       : ");
        words.stream()
             .map(String::length)
             .forEach(l -> System.out.print(l + " "));
        System.out.println();

        // ─────────────────────────────────────────────
        // 3. flatMap()
        //    Flattens a Stream<Stream<T>> into a single Stream<T>.
        //    Essential when each element produces multiple outputs.
        // ─────────────────────────────────────────────
        separator("3. flatMap()");

        List<List<Integer>> nested = List.of(
            List.of(1, 2, 3),
            List.of(4, 5),
            List.of(6, 7, 8, 9)
        );
        System.out.println("Nested list         : " + nested);

        System.out.print("After flatMap()     : ");
        nested.stream()
              .flatMap(x -> x.stream())
              .forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.print("flatMap + map (*2)  : ");
        nested.stream()
              .flatMap(Collection::stream)
              .map(x -> x * 2)
              .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // ─────────────────────────────────────────────
        // 4. sorted()
        //    Sorts all elements before passing them forward.
        //    STATEFUL — must collect ALL elements first.
        // ─────────────────────────────────────────────
        separator("4. sorted()");

        System.out.print("Natural (ascending) order   : ");
        numbers.stream()
               .sorted()
               .forEach(x -> System.out.print(x + " "));
        System.out.println();

       // Overloaded version : sorted(Comparator c)
        System.out.print("Descending order            : ");
        numbers.stream()
               .sorted((a, b) -> b - a)
               .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // ─────────────────────────────────────────────
        // 5. distinct()
        //    Removes duplicate elements (uses hashing internally).
        //    STATEFUL — remembers all seen elements.
        // ─────────────────────────────────────────────
        separator("5. distinct()");

        System.out.println("With duplicates             : " + numbers);
        System.out.print("After distinct()            : ");
        numbers.stream()
               .distinct()
               .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // ─────────────────────────────────────────────
        // 6. limit(n)
        //    Stops the stream after n elements.
        //    Short-circuits — great for infinite streams.
        // ─────────────────────────────────────────────
        separator("6. limit(n)");

        System.out.print("First 5 from infinite (1,2,3,...) : ");
        Stream.iterate(1, x -> x + 1)
              .limit(5)
              .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // ─────────────────────────────────────────────
        // 7. skip(n)
        //    Discards the first n elements.
        // ─────────────────────────────────────────────
        separator("7. skip(n)");

        System.out.print("skip(3) from numbers list          : ");
        numbers.stream()
               .skip(3)
               .forEach(x -> System.out.print(x + " "));
        System.out.println();


        // Pagination simulation: page 2 (page size = 3)
        int pageSize = 3, page = 2;
        System.out.print("Page " + page + " (size=" + pageSize + ") of numbers : ");
        numbers.stream()
               .skip((long)(page - 1) * pageSize)
               .limit(pageSize)
               .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // ─────────────────────────────────────────────
        // 8. peek()
        //    Observes elements mid-pipeline without modifying them.
        //    Primarily used for debugging.
        // ─────────────────────────────────────────────
        separator("8. peek()  [debug spy]");

        System.out.println("Pipeline: filter(>5) → peek → map(*2) → peek → sorted → forEach");
        numbers.stream()
               .filter(x -> x > 5)
               .peek(x  -> System.out.println("  [after filter ] " + x))
               .map(x   -> x * 2)
               .peek(x  -> System.out.println("  [after map    ] " + x))
               .sorted()
               .forEach(x -> System.out.println("  [final output ] " + x));

        // ─────────────────────────────────────────────
        // 9. Others : mapToInt, mapToDouble , ...
        // ─────────────────────────────────────────────

        separator("DONE");
    }

    // ── helper ──────────────────────────────────────
    static void separator(String title) {
        System.out.println("\n" + "=".repeat(55));
        System.out.println("  " + title);
        System.out.println("=".repeat(55));
    }
}
