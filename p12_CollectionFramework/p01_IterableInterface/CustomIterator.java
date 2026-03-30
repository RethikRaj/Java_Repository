package p12_CollectionFramework.p01_IterableInterface;

import java.util.Iterator;

public class CustomIterator {
    public static void main(String[] args) {
        NamesContainer nc = new NamesContainer(5);
        nc.insert(0, "Rethik");
        nc.insert(1, "Raj");
        nc.insert(2, "Hello");
        nc.insert(3, "Bye");

        Iterator<String> it = nc.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // Syntactic sugar
        for(String s : nc) {
            System.out.println(s);
        }
    }
}

class NamesContainer implements Iterable<String> {
    private String[] arr;
    private int size;

    public NamesContainer(int size) {
        this.arr = new String[size];
        this.size = size;
    }

    public void insert(int index, String val) {
        arr[index] = val;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public String next() {
                return arr[pos++];
            }
        };
    }
}
