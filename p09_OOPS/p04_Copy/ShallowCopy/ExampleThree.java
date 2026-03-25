package p09_OOPS.p04_Copy.ShallowCopy;

// Shallow copy with immutable objects.

public class ExampleThree {
    public static void main(String[] args) {
        A a = new A(new Immutable(10));
        A b = new A(a);

        b.i = new Immutable(30);

        System.out.println(a.i.getAge()); // 10
        System.out.println(b.i.getAge()); // 30
    }
}

// Let's make an immutable class.
class Immutable {
    private final int age;

    Immutable(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class A {
    Immutable i;

    A (Immutable i) {
        this.i = i;
    }

    A (A other) {
        this.i = other.i;
    }
}
