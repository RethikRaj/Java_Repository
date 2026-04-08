package p13_utilityClasses;

import java.util.*;

public class CollectionsClass {

    public static void main(String[] args) {

        // Base List
        List<Integer> numbers = new ArrayList<>(Arrays.asList(23, 100, 2, 10));

        // 1. max , min
        System.out.println("Max : " + Collections.max(numbers));
        System.out.println("Min : " + Collections.min(numbers));


        // 2. sort
        Collections.sort(numbers);
        System.out.println("Sorted : " + numbers);


        // 3. reverse
        Collections.reverse(numbers);
        System.out.println("Reversed : " + numbers);


        // 4. swap
        Collections.swap(numbers, 1, 2);
        System.out.println("After Swap : " + numbers);


        // 5. shuffle
        Collections.shuffle(numbers);
        System.out.println("Shuffled : " + numbers);


        // 6. frequency
        System.out.println("Frequency of 100 : " + Collections.frequency(numbers, 100));


        // 7. fill

        // Capacity != Size
        List<String> emptyList = new ArrayList<>(5);
        System.out.println("Before Fill : " + emptyList.size() + " " + emptyList);

        Collections.fill(emptyList, "Hello"); // No effect (size = 0)
        System.out.println("After Fill : " + emptyList);


        // Proper Fill Example
        List<Integer> filledList =new ArrayList<>(Collections.nCopies(10, -1));

        System.out.println("Before Fill : " + filledList.size() + " " + filledList);

        Collections.fill(filledList, 777);
        System.out.println("After Fill : " + filledList);


        // 8. Binary Search (List must be sorted)
        List<Integer> sortedList = new ArrayList<>(
                Arrays.asList(10, 20, 30, 40, 50)
        );

        System.out.println("Index of 30 : " +
                Collections.binarySearch(sortedList, 30));

        System.out.println("Index of 60 : " +
                Collections.binarySearch(sortedList, 60));


        // 9. unmodifiableList
        List<Integer> readOnlyList =
                Collections.unmodifiableList(sortedList);

        System.out.println("Read Only List : " + readOnlyList);
        // readOnlyList.add(100);  -> UnsupportedOperationException


        // 10. emptyList, emptySet, emptyMap
        List<Integer> emptyImmutableList = Collections.emptyList();
        Set<Integer> emptyImmutableSet = Collections.emptySet();
        Map<Integer, Integer> emptyImmutableMap = Collections.emptyMap();

        System.out.println("Empty List : " + emptyImmutableList);
        System.out.println("Empty Set : " + emptyImmutableSet);
        System.out.println("Empty Map : " + emptyImmutableMap);
    }
}