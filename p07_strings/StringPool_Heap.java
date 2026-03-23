package p07_strings;

/*
Rule : 
1. Compile time string constants are stored in string pool.
2. Run time created string go to heap.
 */

public class StringPool_Heap {
    public static void main(String[] args) {
        // Que1
        String s1 = "ja" + "va";
        String s2 = "java";
        System.out.println(s1 == s2); // true

        // Que2
        String s3 = "ja";
        String s4 = s3 + "va";
        String s5 = "java";
        System.out.println(s4 == s5); // false

        // Que3
        String s6 = "Hello";
        s6 = " World";
        System.out.println(s6); // World

        // Que4
        String s7 = "Rethik";
        String s8 = s7;
        System.out.println(s7 == s8); // true

        // Que5
        String s9 = new String("Raj");
        String s10 = "Raj";
        System.out.println(s9 == s10); // false
    }
}
