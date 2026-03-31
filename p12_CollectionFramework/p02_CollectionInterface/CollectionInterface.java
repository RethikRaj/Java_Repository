package p12_CollectionFramework.p02_CollectionInterface;

import java.util.*;

public class CollectionInterface {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        c.add(100);
        c.add(200);
        c.add(300);

        // 1. Query Operations

        // 1.1 int size()
        System.out.println(c.size());

        // 1.2 boolean isEmpty() - this function is optimized for some data structures
        System.out.println(c.isEmpty());

        // 1.3 boolean contains(Object o)
        System.out.println(c.contains(2));
        System.out.println(c.contains(12.33));

        // 1.4 Iterator<E> iterator() - inherited from Iterable interface

        // 1.5 Object[] toArray()
        Object[] arr = c.toArray();
        for(Object o : arr) {
            System.out.println(o);
            // System.out.println(o+5); can't do
        }

        // 1.6 T[] toArray()
        Integer[] arr2 = c.toArray(new Integer[0]);
        for(Integer i : arr2) {
            System.out.println(i + 5);
        }

        // 2.Modification operation

        // 2.1 boolean add(E e) - returns true if added succesfully , else returns false;
        System.out.println(c.add(1));
        System.out.println(c.add(2));

        System.out.println(c);

        // 2.2 boolean remove(Object o) 
        System.out.println(c.remove(3));  // false
        System.out.println(c.remove(2)); // true

        System.out.println(c);

        // 3. Bulk operations

        // 3.1 boolean addAll(Collection<? extends E> c)
        System.out.println(c.addAll(List.of(3,4,5,6,7)));

        System.out.println(c);

        // 3.2 boolean removeAll(Collection<?> c)
        System.out.println(c.removeAll(List.of(1, 5)));

        System.out.println(c);

        // 3.3 boolean retainAll(Collection<?> c) - retains the listed elements , removes other elements
        System.out.println(c.retainAll(List.of(3,7)));

        System.out.println(c);

        // 3.4 boolean containsAll(Collection<?> c)
        System.out.println(c.containsAll(List.of(1,2,3)));
        System.out.println(c.containsAll(List.of(3,7)));

        // 3.5 void clear()
        c.clear();
        System.out.println(c);
    }
}