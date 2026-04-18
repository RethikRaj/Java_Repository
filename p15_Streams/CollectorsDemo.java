package p15_Streams;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

// A simple Employee class to demonstrate real-world grouping scenarios
class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName()       { return name; }
    public String getDepartment() { return department; }
    public double getSalary()     { return salary; }

    @Override
    public String toString() {
        return name + "(" + department + ", $" + salary + ")";
    }
}

public class CollectorsDemo {    

    public static void main(String[] args) {

        // ── Data Setup ──────────────────────────────────────────────
        List<String> words = List.of("apple", "bat", "cat", "avocado", "ball", "cherry", "blueberry");

        List<Integer> numbers = List.of(1, 13, 11, 9, 4, 6, 20);

        List<Employee> employees = List.of(
            new Employee("Alice",   "Engineering", 90000),
            new Employee("Bob",     "Marketing",   60000),
            new Employee("Charlie", "Engineering", 85000),
            new Employee("Diana",   "HR",          55000),
            new Employee("Eve",     "Marketing",   70000),
            new Employee("Frank",   "HR",          58000),
            new Employee("Grace",   "Engineering", 95000)
        );

        System.out.println("Words   : " + words);
        System.out.println("Numbers : " + numbers);
        System.out.println("Employees: " + employees);
        System.out.println("=".repeat(60));

        // ─────────────────────────────────────────────────────────────
        // 1. Collectors.toList() → Collects into a MUTABLE ArrayList.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n1. Collectors.toList()");

        List<String> filteredWords = words.stream()
                                          .filter(w -> w.startsWith("a"))
                                          .collect(Collectors.toList());

        filteredWords.add("apricot"); // ✅ mutable — this works!
        System.out.println("   Words starting with 'a' (+ added 'apricot'): " + filteredWords);

        // ─────────────────────────────────────────────────────────────
        // 2. Collectors.toUnmodifiableList() -> Explicitly immutable version — same as stream's .toList()
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n2. Collectors.toUnmodifiableList()");

        List<String> immutable = words.stream()
                                      .filter(w -> w.startsWith("b"))
                                      .collect(Collectors.toUnmodifiableList());

        System.out.println("   Words starting with 'b': " + immutable);

        // ─────────────────────────────────────────────────────────────
        // 3. Collectors.toSet()
        //    → Collects into a HashSet — duplicates are automatically removed.
        //    → Order is NOT guaranteed.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n3. Collectors.toSet()");

        List<Integer> withDupes = List.of(1, 2, 2, 3, 3, 3, 4);

        Set<Integer> uniqueNums = withDupes.stream()
                                           .collect(Collectors.toSet());

        System.out.println("   Input (with dupes): " + withDupes);
        System.out.println("   After toSet()      : " + uniqueNums); // order may vary

        // ─────────────────────────────────────────────────────────────
        // 4. Collectors.toCollection()
        //    → Collect into ANY specific Collection type you choose.
        //    → Useful when you need TreeSet (sorted), LinkedList, etc.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n4. Collectors.toCollection()");

        // Collect into a TreeSet — stays sorted, no duplicates
        TreeSet<Integer> sortedSet = withDupes.stream()
                                              .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("   Collected into TreeSet (sorted, no dupes): " + sortedSet);

        // Collect into a LinkedList
        LinkedList<String> linkedWords = words.stream()
                                              .filter(w -> w.length() > 3)
                                              .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("   Words longer than 3 chars into LinkedList: " + linkedWords);

        // ─────────────────────────────────────────────────────────────
        // 5. Collectors.toMap()
        //    → Collect into a Map by specifying a key-mapper and
        //      a value-mapper function.
        //    ⚠ IMPORTANT: If two elements produce the same KEY,
        //      it throws IllegalStateException (duplicate key error).
        //      Use the 3-arg version with a merge function to handle it.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n5. Collectors.toMap()");

        // key = word, value = its length
        Map<String, Integer> wordLengthMap = words.stream()
                                                  .collect(Collectors.toMap(
                                                      w -> w,            // key: the word itself
                                                      w -> w.length()    // value: length of word
                                                  ));

        System.out.println("   word → length map: " + wordLengthMap);

        // toMap() with a MERGE FUNCTION to handle duplicate keys
        // key = first character, value = word (multiple words may share same first char)
        Map<Character, String> firstCharMap = words.stream()
                                                   .collect(Collectors.toMap(
                                                       w -> w.charAt(0),          // key: first char
                                                       w -> w,                     // value: word
                                                       (existing, newVal) -> existing + ", " + newVal // merge if key clash
                                                   ));

        System.out.println("   first char → words (merged): " + firstCharMap);

        // ─────────────────────────────────────────────────────────────
        // 6. Collectors.joining()
        //    → Only works on Stream<String>.
        //    → Joins all elements into a single String.
        //    → Three overloads:
        //         joining()                     → no separator
        //         joining(delimiter)            → separator between elements
        //         joining(delimiter, prefix, suffix) → full control
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n6. Collectors.joining()");

        String noSeparator = words.stream()
                                  .collect(Collectors.joining());

        System.out.println("   No separator    : " + noSeparator);

        String withComma = words.stream()
                                .collect(Collectors.joining(", "));

        System.out.println("   With ', '       : " + withComma);

        String withBrackets = words.stream()
                                   .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("   With [ ] wrapper: " + withBrackets);

        // ─────────────────────────────────────────────────────────────
        // 7. Collectors.counting()
        //    → Counts the number of elements — like stream's count(),
        //      but as a Collector so it can be used INSIDE groupingBy.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n7. Collectors.counting()");

        long wordCount = words.stream()
                              .filter(w -> w.length() > 4)
                              .collect(Collectors.counting());

        System.out.println("   Words with length > 4: " + wordCount);

        // ─────────────────────────────────────────────────────────────
        // 8. Collectors.summingInt() / summingLong() / summingDouble()
        //    → Sums a numeric property extracted from each element.
        //    → Useful when you want to sum INSIDE a groupingBy.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n8. Collectors.summingInt()");

        int totalLetters = words.stream()
                                .collect(Collectors.summingInt(String::length));

        System.out.println("   Total letters across all words: " + totalLetters);

        // ─────────────────────────────────────────────────────────────
        // 9. Collectors.averagingInt() / averagingDouble()
        //    → Computes average of a numeric property.
        //    → Returns a Double (always).
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n9. Collectors.averagingInt()");

        double avgLength = words.stream()
                                .collect(Collectors.averagingInt(String::length));

        System.out.println("   Average word length: " + avgLength);

        // ─────────────────────────────────────────────────────────────
        // 10. Collectors.summarizingInt()
        //     → One call — gives you count, sum, min, max, average
        //       ALL at once as an IntSummaryStatistics object.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n10. Collectors.summarizingInt()");

        IntSummaryStatistics stats = words.stream()
                                          .collect(Collectors.summarizingInt(String::length));

        System.out.println("   Word length statistics:");
        System.out.println("   Count   : " + stats.getCount());
        System.out.println("   Sum     : " + stats.getSum());
        System.out.println("   Min     : " + stats.getMin());
        System.out.println("   Max     : " + stats.getMax());
        System.out.println("   Average : " + stats.getAverage());

        // ─────────────────────────────────────────────────────────────
        // 11. Collectors.groupingBy()
        //     → THE most-used collector in real-world code.
        //     → Groups elements by a classifier key.
        //     → Result: Map<Key, anything> , anything is determined based on downstream.(default is toList())
        //
        //     Three overloads:
        //       groupingBy(classifier)
        //       groupingBy(classifier, downstream)
        //       groupingBy(classifier, mapFactory, downstream)
        // downstream ->  what to do with elements in each bucket
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n11. Collectors.groupingBy()");

        // Basic: group words by their length
        Map<Integer, List<String>> byLength = words.stream()
                                                   .collect(Collectors.groupingBy(String::length));

        System.out.println("   Grouped by length: " + byLength);

        // Real-world: group employees by department
        Map<String, List<Employee>> byDept = employees.stream()
                                                      .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("   Employees by department:");
        byDept.forEach((dept, emps) -> System.out.println("     " + dept + " -> " + emps));

        // groupingBy + downstream: count employees per department
        Map<String, Long> countByDept = employees.stream()
                                                 .collect(Collectors.groupingBy(
                                                     Employee::getDepartment,
                                                     Collectors.counting()          // downstream collector
                                                 ));

        System.out.println("   Employee count per department: " + countByDept);

        // groupingBy + downstream: average salary per department
        Map<String, Double> avgSalaryByDept = employees.stream()
                                                       .collect(Collectors.groupingBy(
                                                           Employee::getDepartment,
                                                           Collectors.averagingDouble(Employee::getSalary)
                                                       ));

        System.out.println("   Avg salary per department: " + avgSalaryByDept);

        // groupingBy + downstream: get only names per department (using mapping)
        Map<String, List<String>> namesByDept = employees.stream()
                                                         .collect(Collectors.groupingBy(
                                                             Employee::getDepartment,
                                                             Collectors.mapping(
                                                                 Employee::getName,       // transform value
                                                                 Collectors.toList()      // then collect
                                                             )
                                                         ));

        System.out.println("   Employee names per department: " + namesByDept);

        // ─────────────────────────────────────────────────────────────
        // 12. Collectors.partitioningBy()
        //     → Special case of groupingBy — splits into exactly TWO groups:
        //         true  → elements that match the predicate
        //         false → elements that don't
        //     → Result: Map<Boolean, List<Element>>
        //     → Can also take a downstream collector.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n12. Collectors.partitioningBy()");

        // Partition numbers into even and odd
        Map<Boolean, List<Integer>> evenOdd = numbers.stream()
                                                     .collect(Collectors.partitioningBy(
                                                         x -> x % 2 == 0
                                                     ));

        System.out.println("   Even (true) / Odd (false): " + evenOdd);

        // Partition + Downstream : Partition numbers into even and odd and then count 
        Map<Boolean, Long> count = numbers.stream()
                                          .collect(Collectors.partitioningBy(
                                                x -> x%2 == 0,
                                                Collectors.counting()
                                            ));
        System.out.println("Even (true) / Odd (false): count : " +  count);

        // Partition employees: salary above 70k vs below
        Map<Boolean, List<String>> highEarners = employees.stream()
                                                          .collect(Collectors.partitioningBy(
                                                              e -> e.getSalary() > 70000,
                                                              Collectors.mapping(Employee::getName, Collectors.toList())
                                                          ));

        System.out.println("   Salary > 70k (true) / <= 70k (false): " + highEarners);

        // ─────────────────────────────────────────────────────────────
        // 13. Collectors.mapping()
        //     → A downstream collector — used INSIDE groupingBy or
        //       partitioningBy to transform values before collecting.
        //     → Standalone use is rare but possible.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n13. Collectors.mapping()  [standalone]");

        // Standalone: collect uppercased words into a list
        List<String> upperWords = words.stream()
                                       .collect(Collectors.mapping(
                                           String::toUpperCase,
                                           Collectors.toList()
                                       ));

        System.out.println("   Uppercased words: " + upperWords);

        // ─────────────────────────────────────────────────────────────
        // 14. Collectors.collectingAndThen()
        //     → Wraps another collector and applies a FINISHER function
        //       to the result after collection is done.
        //     → Common use: collect to list, then make it unmodifiable.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n14. Collectors.collectingAndThen()");

        // Collect filtered words into a list, then immediately wrap as unmodifiable
        List<String> unmodifiableFiltered = words.stream()
                                                 .filter(w -> w.startsWith("c"))
                                                 .collect(Collectors.collectingAndThen(
                                                     Collectors.toList(),
                                                     Collections::unmodifiableList  // finisher
                                                 ));

        System.out.println("   Words starting with 'c' (unmodifiable): " + unmodifiableFiltered);

        // Another use: collect, then get the size of the resulting list
        int sizeOfLongWords = words.stream()
                                   .filter(w -> w.length() > 5)
                                   .collect(Collectors.collectingAndThen(
                                       Collectors.toList(),
                                       List::size   // finisher: get the size
                                   ));

        System.out.println("   Number of words longer than 5 chars: " + sizeOfLongWords);

        // ─────────────────────────────────────────────────────────────
        // 15. Collectors.teeing()  [Java 12+]
        //     → Feeds the stream into TWO separate downstream collectors,
        //       then merges their results using a BiFunction.
        //     → Think of it as a Y-splitter for your stream.
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n15. Collectors.teeing()  [Java 12+]");

        // Find min AND max salary in one single stream pass
        Map<String, Double> salaryRange = employees.stream()
                                                   .collect(Collectors.teeing(
                                                       Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)),
                                                       Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                                       (min, max) -> {
                                                           Map<String, Double> result = new LinkedHashMap<>();
                                                           result.put("min", min.map(Employee::getSalary).orElse(0.0));
                                                           result.put("max", max.map(Employee::getSalary).orElse(0.0));
                                                           return result;
                                                       }
                                                   ));

        System.out.println("   Salary range (min & max in ONE pass): " + salaryRange);

        System.out.println("\n" + "=".repeat(60));
        System.out.println("All Collectors demonstrated!");
    }
}