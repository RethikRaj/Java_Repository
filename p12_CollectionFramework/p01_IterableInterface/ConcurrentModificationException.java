package p12_CollectionFramework.p01_IterableInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
`ConcurrentModificationException` occurs when a collection is modified while it is being iterated, without using the iterator's own modification methods.
 */

public class ConcurrentModificationException {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            int val = it.next();
            if (val == 3) {
                list.remove(val); // Throws ConcurrentModificationException
                // but we can use it.remove(val);
            }
        }
    }
}


