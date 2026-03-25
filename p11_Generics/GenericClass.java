package p11_Generics;

public class GenericClass {
    public static void main(String[] args) {

        // ⚠️ Raw Type — no type argument provided
        // Java defaults T to Object as type argument
        Box b0 = new Box(10);
        System.out.println(b0.getValue());

        // T is replaced with String throughout the class
        // T = String as type argument
        Box<String> b1 = new Box<String>("Hello");

        // ✅ Diamond operator <> — Java infers T = Integer from the left side
        // Preferred modern style, avoids repeating the type argument
        // T = Integer - autoboxing converts primitive `12` → Integer object
        // Remember: T must always be a reference type, never a primitive
        Box<Integer> b2 = new Box<>(12);

        // ✅ T = Boolean — autoboxing converts primitive `true` → Boolean object
        Box<Boolean> b3 = new Box<>(true);

        // No casting needed — getValue() returns the exact type (String, Integer, Boolean)
        // Type information is preserved unlike the Object-based Box
        System.out.println(b1.getValue());          // String  → "Hello"
        System.out.println(b2.getValue() + 5);      // Integer → 17 (arithmetic works!)
        System.out.println(b3.getValue());          // Boolean → true
    }
}

// Generic class — T is a type parameter (placeholder for the actual type)
// T is decided by the caller at the time of object creation, not here
class Box<T> {

    // value's type is unknown here — it will be whatever T resolves to
    private T value;

    // Constructor accepts T — so it only accepts the type the caller specified
    public Box(T value) {
        this.value = value;
    }

    // Returns T — no casting needed by the caller, type is already known
    public T getValue() {
        return this.value;
    }

    // Setter also enforces T — caller can't accidentally pass a wrong type
    // e.g. if Box<Integer>, passing a String here → compile error
    public void setValue(T value) {
        this.value = value;
    }
}

// Two independent type parameters — first and second can be completely different types
class Pair<T, U> {

    private T first;   // type decided by first type argument
    private U second;  // type decided by second type argument

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}