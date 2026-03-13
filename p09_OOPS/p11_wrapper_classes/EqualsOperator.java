package p09_OOPS.p11_wrapper_classes;

public class EqualsOperator {
    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = 10;

        System.out.println(i1 == i2); // true due to caching both i1 and i2 holds the same address.
        System.out.println(i1.equals(i2)); // true
        System.out.println(i1.intValue() == i2.intValue()); 

        Integer i3 = 1000;
        Integer i4 = 1000;

        System.out.println(i3 == i4); // false because i3 and i4 holds different address.
        System.out.println(i3.equals(i4)); // true
        System.out.println(i3.intValue() == i4.intValue()); // true

        // Therefore always use .equals() operator or .intValue() operator
    }
}
