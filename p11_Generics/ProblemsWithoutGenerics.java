package p11_Generics;


public class ProblemsWithoutGenerics {
    public static void main(String[] args) {
        Box b1 = new Box("Hello");
        Box b2 = new Box(12);
        Box b3 = new Box(true);

        // Problem with solution 2
        // ❌ Problem 1: Type information is lost
        // b2 holds Integer, but compiler only sees Object
        // So we can't do arithmetic directly
        // System.out.println(b2.getValue() + 5); // Compile error
        // The operator + is undefined for type Object

        // ❌ Problem 2: Manual downcasting required every time
        Integer val = (Integer) b2.getValue(); // Need to cast manually
        System.out.println(val + 5);           // Works, but ugly

        // ❌ Problem 3: ClassCastException at RUNTIME (not compile time) => it happens due to the dangerous downcasting
        // Compiler sees no issue here, but crashes when run
        Integer wrong = (Integer) b1.getValue(); // b1 holds "Hello" (String)
        // java.lang.ClassCastException: String cannot be cast to Integer
        // You only discover this when the app is already running!

        // ❌ Problem 4: No type safety — wrong types can be inserted silently
        // b2 was meant to hold Integer, but nothing stops this:
        b2.setValue("Oops I'm a String now"); // No error at all!
    }
}

// Problem Statement : Create a Box class that can hold any type of value.

// Solution 1 : Create BoxInt class , BoxString class , BoxBoolean class , ... 
// Problems : code duplication

// Solution 2 : We know that Object can hold any non-primitive value and even if we assign primitive it is autoboxed. So it can hold any value.
class Box {
    private Object value;

    public Box(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}


