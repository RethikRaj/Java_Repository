package p12_CollectionFramework.p04_MapInterface;

import java.util.*;

public class TreeMap_ {
    public static void main(String[] args) {
        // Average TC of most methods is O(log n).

        // Construtors
        TreeMap<Integer, String> mp1 = new TreeMap<>();
        TreeMap<Integer, String> mp2 = new TreeMap<>(Map.of(1, "Rethik", 2, "Raj"));
        // TreeMap<Integer, String> mp2 = new TreeMap<>(Comparator);

        // All the methods of map Interface. (Refere HashMap_LinkedHashMap.java)

        mp1.put(80, "abc");
        mp1.put(90, "cde");
        mp1.put(20, "xyz");
        mp1.put(50, "pqr");
        mp1.put(10, "tre");

        // Methods from SortedMap Interface
        // 1. firstKey(), firstEntry()
        System.out.println(mp1.firstKey()); // Returns the smallest Key
        System.out.println(mp1.firstEntry()); // Returns the entry with smallest Key.

        // 2. lastKey(), lastEntry()
        System.out.println(mp1.lastKey()); // Returns the largest key
        System.out.println(mp1.lastEntry()); // Returns the entry with largest Key.

        // 3. headMap(K toKey)
        System.out.println(mp1.headMap(50)); // Returns a map having keys < toKey.

        // 4. tailMap(K fromKey)
        System.out.println(mp1.tailMap(50)); // Returns a map having keys >= fromKey.

        // 5. subMap(K fromkey, K toKey)
        System.out.println(mp1.subMap(20, 90)); // Returns a map having fromKey =< keys > toKey

        // Methods from NavigableMap Interface

        // 1. lowerKey(), lowerEntry()
        System.out.println(mp1.lowerKey(50)); // returns the greatest key < inputKey
        System.out.println(mp1.lowerEntry(50)); // returns the entry with greatest key < inputKey

        // 2. floorKey(), floorEntry()
        System.out.println(mp1.floorKey(50)); // returns the greatest key <= inputKey
        System.out.println(mp1.floorEntry(50)); // returns the entry with greatest key <= inputKey

        // 3. higherKey(), higherEntry()
        System.out.println(mp1.higherKey(50)); // returns the smallest key > inputKey
        System.out.println(mp1.higherEntry(50)); // returns the entry with smallest key > inputKey

        // 4. ceilingKey(), ceilingEntry()
        System.out.println(mp1.ceilingKey(50)); // returns the smallest key >= inputKey
        System.out.println(mp1.ceilingEntry(50));  //  returns the entry with smallest key > inputKey

        // 5. pollFirstEntry() - returns the entry with smallest key and deletes it.
        System.out.println(mp1.pollFirstEntry());
        System.out.println(mp1);

        // 6. pollLastEntry() - returns the entry with largest key and deletes it
        System.out.println(mp1.pollLastEntry());
        System.out.println(mp1);

        // 7. headMap(K toKey, boolean inclusive)
        // If inclusive = true => Returns a map having keys <= toKey.
        // If inclsuive = false(default) => Returns a map having keys < toKey.
        System.out.println(mp1.headMap(50, true)); 

        // 8. tailMap(K fromKey, boolean inclusive)
        // If inclusive = true(default) => Returns a map having keys >= fromKey.
        // If inclsuive = false => Returns a map having keys > toKey.
        System.out.println(mp1.tailMap(50, false));

        // 9. subMap(K fromKey, boolean inclusive, K toKey, boolean inclusive)
        System.out.println(mp1.subMap(50, true, 80, true));

        // 10. descendingMap()
        System.out.println(mp1.descendingMap()); // returns the reverse order of insertion

        // 11. descendingIterator
        Set<Integer> _mp = mp1.descendingKeySet();

        
    }
}
