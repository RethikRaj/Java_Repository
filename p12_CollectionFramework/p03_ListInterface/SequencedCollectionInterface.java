package p12_CollectionFramework.p03_ListInterface;

import java.util.*;

public class SequencedCollectionInterface {
    public static void main(String[] args) {
        
        SequencedCollection<String> list = new ArrayList<>();

        list.addFirst("20");
        list.addLast("30");
        list.addFirst("40");

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        System.out.println(list);

        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());

        System.out.println(list);


    }

}