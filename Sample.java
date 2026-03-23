public class Sample {
    public static void main(String[] args) {
        B b = new B();
        B.method1();

        Object o = new Object();
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


class A {
    static void method1() {
        System.out.println("A.method1()");
    }
}


class B extends A {

}