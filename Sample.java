import java.util.*;

public class Sample {
    public static void main(String[] args) {
        // Object o = "Hello";

        // // Downcasting
        // // String s = o; // compile time error : Cannot convert from Object to String

        // Integer i = (Integer) o;
        // System.out.println(i);

        Map<Integer, Integer> mp = new HashMap<>();

        mp.containsKey(1);

        // mp.put(1, 2);

        System.out.println(mp.get(1));

        

    }
}

final class Integer {
    private int value;           // stores the actual int

    // Deprecated constructor (avoid using)
    Integer(int x) { this.value = x; }

    // Preferred: static factory method (uses caching)
    public static Integer valueOf(int x) { 
        return new Integer(x);
    }

    // Returns the primitive int value
    public int intValue() { return this.value; }

    // Compares value equality
    public boolean equals(Integer y) { return this.value == y.value; }
}
 
