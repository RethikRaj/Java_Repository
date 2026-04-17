package p15_Streams;

import java.util.Arrays;
import java.util.List;

public class FlatMapIntermediateOperationDemo {
    public static void main(String[] args) {
        // Problem Statement : Splitting sentences into individual words
        List<String> sentences = List.of("Hello World", "Java Streams", "FlatMap Demo");

        // Method 1 : Using map 
        sentences.stream()
                 .map(s -> s.split(" ")) // List<String[]>
                 .forEach((stringArr) -> {
                    for(String s : stringArr) {
                        System.out.println(s);
                    }
                 });

        // method 2 : Using flat map

        System.out.print("Split sentences     : ");
        sentences.stream()
                 .flatMap(s -> Arrays.stream(s.split(" ")))
                 .forEach(w -> System.out.print(w + " "));
        System.out.println();

        // The tell-tale sign you need flatMap instead of map: if your lambda returns something iterable (an array, a list, a stream), you almost certainly want flatMap. map is for one-to-one transformations; flatMap is for one-to-many.
        // map : 3 sentences => 3 String[] (string arr) objects after split
        // flatmap : 3 sentences => 6 individual string 
       
    }
}
