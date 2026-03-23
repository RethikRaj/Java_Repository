package p07_strings;


public class StringInitialization {
    public static void main(String[] args) {
        // 1. Literal Way
        String s1 = "Hello";
        String s2 = "Hello";

        System.out.println(s1 == s2); // true
        System.out.println(s1.equals(s2)); // true 
        // equals is overrided by the string class to compare values.

        // 2. Constructor Way
        String s3 = new String("Hello");
        String s4 = new String("Hello");

        System.out.println(s3 == s4); // false
        System.out.println(s3.equals(s4)); // true
    }    
}
