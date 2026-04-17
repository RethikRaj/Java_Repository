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
       
    }
}
