public class Sample {
    public static void main(String[] args) {
        
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