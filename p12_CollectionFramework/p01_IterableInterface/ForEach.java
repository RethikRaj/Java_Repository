package p12_CollectionFramework.p01_IterableInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8,9));

        // Method 1 :
        for(int i = 0 ; i < list.size(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Method 2 :
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Method 3 : Uses Method 2 internally
        for(Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Method 4 : Uses Method 3 internally
        // ForEach( Consumer action)
        list.forEach((x) -> System.out.println(x));

        list.forEach(System.out::println);

    }
}
