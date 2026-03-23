package p07_strings;

public class StringImmutability {
    public static void main(String[] args) {
        // String is immutable

        String s1 = "Hello";
        // s1[0] = "8"; Error
        s1 = "World";
        System.out.println(s1); // World


        // Problem with immutability
        String s = "";
        for (int i = 0; i < 10 ; i++) {
            s += i; // Each time a new object is created in heap => Memory wastage.
            System.out.println(s);
        }

    }
}
