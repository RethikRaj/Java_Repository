package p09_OOPS.p10_polymorphism;

public class PrivateKeywordPolymorphism {
    public static void main(String[] args) {
        
    }
}

class E {
    private void print() {
        System.out.println("Hello from E");
    }
}

class F extends E {
    // This is a different method , not an overriden method
    private void print() {
        System.out.println("Hello from F");
    }
}
    
