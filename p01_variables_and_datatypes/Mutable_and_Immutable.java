package p01_variables_and_datatypes;

public class Mutable_and_Immutable {
    public static void main(String[] args) {
        // Mutable
        StringBuffer sb = new StringBuffer("rethik");
        sb.append(" raj"); // changed
        System.out.println(sb);

        int[] arr = new int[5]; // created
        arr[0] = 10; // changed
        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();

        // Immutable
        // 1. String
        String s = new String("Rethik");
        s.toUpperCase(); // not changed
        System.out.println(s); // Rethik

        // 2. Wrapper of primitives
        Integer x = 10; // A new object with value 10 is created.
        x = 20; // A new object with value 20 is created.
        
        // 3. Primitives
        int y = 10;
        y = 20; // Reassignment. The value 10 is not changed.
        // We are reassigning the variable, not changing the value. 
        // The value `10` itself is never touched or modified.

        
    }
}
