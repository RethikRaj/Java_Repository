package p12_CollectionFramework.p04_MapInterface;

import java.util.*;

public class HashMap_LinkedHashMap {
    public static void main(String[] args) {
        // Below every method works the same for HashMap and LinkedHashMap.
        // The only difference: LinkedHashMap preserves insertion order.

        // ─────────────────────────────────────────────
        // 1. CONSTRUCTORS
        // ─────────────────────────────────────────────
        Map<Integer, String> mp1 = new HashMap<>();                          // default capacity=16, load_factor=0.75
        Map<Integer, String> mp2 = new HashMap<>(20);                        // custom initial capacity
        Map<Integer, String> mp3 = new HashMap<>(20, 0.8f);                  // custom capacity + load factor
        Map<Integer, String> mp4 = new HashMap<>(Map.of(100, "Rethik", 102, "Raj")); // from another map

        // LinkedHashMap — same 4 constructors, just preserves insertion order

        // ─────────────────────────────────────────────
        // 2. BASIC INFO
        // ─────────────────────────────────────────────
        System.out.println("size()    : " + mp1.size());      // 0
        System.out.println("isEmpty() : " + mp1.isEmpty());   // true

        // ─────────────────────────────────────────────
        // 3. INSERTING / UPDATING
        // ─────────────────────────────────────────────

        // put(K key, V value)
        // → inserts if new key, overwrites if existing key
        // → returns null if new key, returns OLD value if key existed. Note that this old value returned might be null because actual value stored might be null.
        System.out.println(mp1.put(1, "Name1"));           // null  (new key)
        System.out.println(mp1.put(2, "Name2"));           // null  (new key)
        System.out.println(mp1.put(1, "Name1Updated"));    // "Name1"  (old value returned, key overwritten)
        mp1.put(3, null);                                   // null value is allowed
        mp1.put(null, "NullKey");                           // null key is allowed (only ONE null key)

        // putIfAbsent(K key, V value)
        // → inserts ONLY if key is absent (does NOT overwrite existing)
        // → returns null if inserted, returns EXISTING value if key already present
        System.out.println(mp1.putIfAbsent(2, "WillNotOverwrite")); // "Name2" (key exists, nothing changes)
        System.out.println(mp1.putIfAbsent(9, "NewEntry"));         // null    (new key inserted)

        // putAll(Map m)
        // → bulk insert from another map, overwrites on duplicate keys
        mp1.putAll(mp4);    // adds 100→"Rethik", 102→"Raj" into mp1

        // replace(K key, V newValue)
        // → updates ONLY if key already exists (never inserts a new key — unlike put)
        // → returns old value, or null if key not found
        System.out.println(mp1.replace(2, "Name2Replaced")); // "Name2"  (updated)
        System.out.println(mp1.replace(99, "Ghost"));        // null     (key 99 doesn't exist, nothing happens)

        // replace(K key, V oldValue, V newValue)
        // → updates ONLY if key exists AND current value matches oldValue (safe replace)
        // → returns true if replaced, false if not
        System.out.println(mp1.replace(2, "Name2Replaced", "Name2Final")); // true
        System.out.println(mp1.replace(2, "WrongOldValue", "Name2Final")); // false (old value mismatch)


        // ─────────────────────────────────────────────
        // 4. READING
        // ─────────────────────────────────────────────

        // get(K key)
        // → returns value, or null if key not found . The retured actual value might also be null.
        System.out.println(mp1.get(1));     // "Name1Updated"
        System.out.println(mp1.get(null));  // "NullKey"
        System.out.println(mp1.get(3));     // null  (value is null)
        System.out.println(mp1.get(5));     // null  (key doesn't exist) — ambiguous! => always use containsKey() to check if key exist or not

        // getOrDefault(K key, V defaultValue)
        // → returns value if key exists, else returns defaultValue (never null)
        // → prefer this over get() in production to avoid NullPointerException
        System.out.println(mp1.getOrDefault(5, "DefaultValue")); // "DefaultValue"
        System.out.println(mp1.getOrDefault(1, "DefaultValue")); // "Name1Updated"

        // containsKey(Object key)  → O(1) average (uses hashing)
        System.out.println(mp1.containsKey(2));       // true
        System.out.println(mp1.containsKey(999));     // false

        // containsValue(Object value)  → O(n) (must scan all buckets)
        System.out.println(mp1.containsValue("Rethik")); // true
        System.out.println(mp1.containsValue("Ghost"));  // false


        // ─────────────────────────────────────────────
        // 5. REMOVING
        // ─────────────────────────────────────────────

        // remove(Object key)
        // → removes the entry and returns its value, or null if key not found
        System.out.println(mp1.remove(2));    // "Name2Final"  (removed)
        System.out.println(mp1.remove(999));  // null          (key doesn't exist)

        // remove(Object key, Object value)
        // → removes ONLY if key exists AND value matches (safe remove)
        // → returns true if removed, false otherwise
        System.out.println(mp1.remove(100, "Rethik"));    // true  (key+value match)
        System.out.println(mp1.remove(102, "WrongName")); // false (value mismatch)


        // ─────────────────────────────────────────────
        // 6. BULK / UTILITY
        // ─────────────────────────────────────────────


        // clear() → removes ALL entries
        Map<Integer, String> temp = new HashMap<>(mp1);
        temp.clear();
        System.out.println(temp.isEmpty()); // true


        // ─────────────────────────────────────────────
        // !7. VIEWS — keySet(), values(), entrySet()
        // ─────────────────────────────────────────────
        mp1.put(10, "Alice");
        mp1.put(20, "Bob");
        mp1.put(30, "Charlie");

        // keySet() → returns Set<K> (keys are unique, hence a Set)
        Set<Integer> keys = mp1.keySet();
        System.out.println("Keys: " + keys);

        // values() → returns Collection<V> (values can be duplicate, so NOT a Set)
        Collection<String> values = mp1.values();
        System.out.println("Values: " + values);

        // entrySet() → returns Set<Map.Entry<K,V>> — each entry is a key-value pair
        // Map.Entry has two methods getKey(), getValue()
        // Since key is unique => Map.Entry is also unique => Can be stored in set
        Set<Map.Entry<Integer, String>> entries = mp1.entrySet();
        System.out.println("\n--- entrySet iteration ---");
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("Key: " + entry.getKey() + " -> Value: " + entry.getValue());
        }

        // You can also SET a value directly on an entry while iterating
        // (use carefully — can cause ConcurrentModificationException if misused)
        // entry.setValue("NewValue");


        // ─────────────────────────────────────────────
        // 8. ITERATING — 3 common ways
        // ─────────────────────────────────────────────
        System.out.println("\n--- forEach lambda ---");
        mp1.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\n--- for-each over entrySet ---");
        for (Map.Entry<Integer, String> e : mp1.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // Same above using iterator.
        System.out.println("Using classical iterable interface : ");
        Iterator<Map.Entry<Integer, String>> it = mp1.entrySet().iterator();
        while(it.hasNext()) {
            System.out.println(it.next().getKey() + " -> " + it.next().getValue());
        }


        System.out.println("\n--- for-each over keySet + get ---");
        for (Integer k : mp1.keySet()) {
            System.out.println(k + " -> " + mp1.get(k));
        }
        // Note: entrySet iteration is fastest — keySet+get does two lookups per entry


        // ─────────────────────────────────────────────
        // 9. IMMUTABLE MAP — Map.of()
        // ─────────────────────────────────────────────
        Map<Integer, String> immutable = Map.of(1, "A", 2, "B", 3, "C");
        System.out.println(immutable.get(1)); // "A"
        // immutable.put(4, "D"); // ← throws UnsupportedOperationException
        // immutable.remove(1);   // ← throws UnsupportedOperationException
        // Also: Map.of() does NOT allow null keys or null values
        // Also: Map.of() does NOT guarantee insertion order


        // ─────────────────────────────────────────────
        // 10. LinkedHashMap — insertion order demo
        // ─────────────────────────────────────────────
        // System.out.println("\n--- LinkedHashMap preserves insertion order ---");
        Map<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(3, "Three");
        lhm.put(1, "One");
        lhm.put(2, "Two");
        System.out.println(lhm); // {3=Three, 1=One, 2=Two} — always in insertion order

        Map<Integer, String> hm = new HashMap<>(lhm);
        System.out.println(hm);  // order NOT guaranteed
    }
}